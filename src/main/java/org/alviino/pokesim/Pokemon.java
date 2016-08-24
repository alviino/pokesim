package org.alviino.pokesim;

public class Pokemon {
	
	private static final double[] CPM_TABLE = {
			0.094,
			0.135137432,
			0.16639787,
			0.192650919,
			0.21573247,
			0.236572661,
			0.25572005,
			0.273530381,
			0.29024988,
			0.306057377,
			0.3210876,
			0.335445036,
			0.34921268,
			0.362457751,
			0.37523559,
			0.387592406,
			0.39956728,
			0.411193551,
			0.42250001,
			0.432926419,
			0.44310755,
			0.453059958,
			0.46279839,
			0.472336083,
			0.48168495,
			0.4908558,
			0.49985844,
			0.508701765,
			0.51739395,
			0.525942511,
			0.53435433,
			0.542635767,
			0.55079269,
			0.558830576,
			0.56675452,
			0.574569153,
			0.58227891,
			0.589887917,
			0.59740001,
			0.604818814,
			0.61215729,
			0.619399365,
			0.62656713,
			0.633644533,
			0.64065295,
			0.647576426,
			0.65443563,
			0.661214806,
			0.667934,
			0.674577537,
			0.68116492,
			0.687680648,
			0.69414365,
			0.700538673,
			0.70688421,
			0.713164996,
			0.71939909,
			0.725571552,
			0.7317,
			0.734741009,
			0.73776948,
			0.740785574,
			0.74378943,
			0.746781211,
			0.74976104,
			0.752729087,
			0.75568551,
			0.758630378,
			0.76156384,
			0.764486065,
			0.76739717,
			0.770297266,
			0.7731865,
			0.776064962,
			0.77893275,
			0.781790055,
			0.78463697,
			0.787473578,
			0.79030001	
	};

	private final Species species;
	private final BasicMove basicMove;
	private final ChargeMove chargeMove;
	private final int attackIv;
	private final int defenseIv;
	private final int staminaIv;
	private final double level;
	
	private final double cpm;
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
		
		this.cpm = CPM_TABLE[(int) ((this.level - 1) / 0.5)];
		this.attack = this.cpm * (this.species.getAttack() + this.attackIv);
		this.defense = this.cpm * (this.species.getDefense() + this.defenseIv);
	}
	
	public void join(Battle battle, boolean isDefender) {
		this.battle = battle;
		this.isDefender = isDefender;
		this.isDead = false;
		this.hp = (int) (this.getCpm() * ((this.isDefender ? 2 : 1) * this.getSpecies().getStamina() + this.getStaminaIv()));
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
					&& ((double) this.computeDamage(opponent, this.chargeMove) / (double) this.chargeMove.getDuration() 
							> (double) this.computeDamage(opponent, this.basicMove) / (double) (this.basicMove.getDuration() 
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
		opponent.incomingDamage = this.computeDamage(opponent, this.basicMove);
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
		opponent.incomingDamage = this.computeDamage(opponent, this.chargeMove);
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
	
	private int computeDamage(Pokemon opponent, Move move) {
		double stab = 1.0;
		double effectiveness = 1.0;
		
		if (move.getType() == this.getSpecies().getType()[0] || move.getType() == this.getSpecies().getType()[1]) {
			stab *= 1.25;
		}
		
		effectiveness *= move.getType().getMultiplierAgainst(opponent.getSpecies().getType()[0]);
		effectiveness *= move.getType().getMultiplierAgainst(opponent.getSpecies().getType()[1]);
		
		return (int) (Math.floor(0.5 * this.getAttack() / opponent.getDefense() * move.getPower() * stab * effectiveness) + 1);
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

	public double getCpm() {
		return cpm;
	}

	public double getAttack() {
		return attack;
	}

	public double getDefense() {
		return defense;
	}
	
}
