package org.alviino.pokesim;

public class Pokemon {
	
	private final Species species;
	private final BasicMove basicMove;
	private final ChargeMove chargeMove;
	private final int attackIv;
	private final int defenseIv;
	private final int staminaIv;
	private final double level;
	
	private final double attack;
	private final double defense;

	private Battle battle;
	private boolean isDefender;
	private boolean isDead;
	private int hp;
	private int hpMax;
	private double energy;
	private double energyCap;
	private int moveTime;
	private int takeDamageTime;
	private int incomingDamage;
	private int basicMoveCounter;
	
	public Pokemon(Species species, BasicMove basicMove, ChargeMove chargeMove, 
			int attackIv, int defenseIv, int staminaIv, double level) {
		this.species = species;
		if (this.species.canUse(basicMove)) {
			this.basicMove = basicMove;
		} else {
			throw new UnsupportedOperationException(this.species.toString() + " can't use " + basicMove.toString());
		}
		if (this.species.canUse(chargeMove)) {
			this.chargeMove = chargeMove;
		} else {
			throw new UnsupportedOperationException(this.species.toString() + " can't use " + chargeMove.toString());
		}
		this.attackIv = attackIv;
		this.defenseIv = defenseIv;
		this.staminaIv = staminaIv;
		this.level = level;
		
		this.attack = Calculator.calculateAttack(this.species, this.attackIv, this.level);
		this.defense = Calculator.calculateDefense(this.species, this.defenseIv, this.level);
	}
	
	public void join(Battle battle, boolean isDefender) {
		this.battle = battle;
		this.isDefender = isDefender;
		this.isDead = false;
		this.hp = Calculator.calculateHp(this.species, this.staminaIv, this.level, isDefender);
		this.hpMax = this.hp;
		this.energy = 0;
		this.energyCap = this.isDefender ? 200 : 100;
		this.incomingDamage = 0;
		this.takeDamageTime = Integer.MAX_VALUE;
		this.moveTime = battle.getClock() + (this.isDefender ? 1000 : 0); // 1st 1000ms pause
		this.basicMoveCounter = 0;
	}
	
	public void takeDamageIfAny() {
		if (this.battle.getClock() == this.takeDamageTime) {
			this.takeDamage();
		}
	}
	
	public void tryToAttack(Pokemon opponent) {
		if (!this.isDead && this.battle.getClock() == this.moveTime) {
			if (this.energy >= this.chargeMove.getEnergyCost()
					&& ((double) Calculator.calculateDamage(this, opponent, this.chargeMove) / (double) this.chargeMove.getDuration() 
							> (double) Calculator.calculateDamage(this, opponent, this.basicMove) / (double) (this.basicMove.getDuration() 
									+ (this.isDefender ? (this.basicMoveCounter < 2 ? 1000 : 2000) : 0)))) {
				this.useChargeMove(opponent);
			} else {
				this.useBasicMove(opponent);
			}
		}
	}
	
	private void useBasicMove(Pokemon opponent) {
		this.checkNotDead();
		
		this.battle.log(this, "used " + this.basicMove.toString());
		
		this.increaseEnergyBy(this.basicMove.getEnergyGeneration());
		opponent.incomingDamage = Calculator.calculateDamage(this, opponent, this.basicMove);
		opponent.takeDamageTime = this.moveTime + this.basicMove.getDuration();
		
		this.moveTime += this.basicMove.getDuration();
		if (this.isDefender) {
			this.moveTime += (this.basicMoveCounter < 2 ? 1000 : 2000); // 2nd 1000ms pause
		}
		this.basicMoveCounter++;
	}
	
	private void useChargeMove(Pokemon opponent) {
		this.checkNotDead();
		
		this.battle.log(this, "used " + this.chargeMove.toString());
		
		this.energy -= this.chargeMove.getEnergyCost();
		opponent.incomingDamage = Calculator.calculateDamage(this, opponent, this.chargeMove);
		opponent.takeDamageTime = this.moveTime + this.chargeMove.getDuration();

		this.moveTime += this.chargeMove.getDuration();
	}

	private void takeDamage() {
		this.checkNotDead();
		
		this.hp -= this.incomingDamage;
		this.increaseEnergyBy(0.5 * this.incomingDamage);
		this.battle.log(this, "lost " + this.incomingDamage + " HP");
		
		if (this.hp <= 0) {
			this.isDead = true;
			this.battle.log(this, "died"); 
		}
	}

	private void checkNotDead() {
		if (this.isDead) {
			throw new RuntimeException(this.getSpecies().toString() + " is dead!");
		}
	}
	
	private void increaseEnergyBy(double amount) {
		this.energy += amount;
		if (this.energy > this.energyCap) {
			this.energy = this.energyCap;
		}
	}
	
	public String getSpeciesMoveSetCombinationName() {
		return (this.getSpecies().toString() + "_" + this.getBasicMove().toString() + "_" + this.getChargeMove().toString());
	}
	
	public boolean isDefender() {
		return isDefender;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public int getMoveTime() {
		return moveTime;
	}

	public int getTakeDamageTime() {
		return takeDamageTime;
	}

	public int getHp() {
		return hp;
	}

	public int getHpMax() {
		return hpMax;
	}

	public double getEnergy() {
		return energy;
	}

	public Species getSpecies() {
		return species;
	}

	public BasicMove getBasicMove() {
		return basicMove;
	}

	public ChargeMove getChargeMove() {
		return chargeMove;
	}

	public int getAttackIv() {
		return attackIv;
	}

	public int getDefenseIv() {
		return defenseIv;
	}

	public int getStaminaIv() {
		return staminaIv;
	}

	public double getLevel() {
		return level;
	}

	public double getAttack() {
		return attack;
	}

	public double getDefense() {
		return defense;
	}
	
}
