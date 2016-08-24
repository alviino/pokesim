package org.alviino.pokesim;

public class Battle {
	
	private final boolean isQuiet;
	private Pokemon attacker;
	private Pokemon defender;

	private int clock;
	
//	private final boolean useRealTime;
//	private Timer timer;
	
	public Battle(Pokemon attacker, Pokemon defender) {
		this(attacker, defender, false, false);
	}
	
	public Battle(Pokemon attacker, Pokemon defender, boolean isQuiet) {
		this(attacker, defender, isQuiet, false);
	}
	
	private Battle(Pokemon attacker, Pokemon defender, boolean isQuiet, boolean useRealTime) {
		this.isQuiet = isQuiet;
		this.attacker = attacker;
		this.defender = defender;
//		this.useRealTime = useRealTime;
	}
	
	public int go() {
		this.clock = 0;
		this.attacker.join(this, false);
		this.defender.join(this, true);
		
		while (this.clock <= this.attacker.getTakeDamageTime() || this.clock <= this.defender.getTakeDamageTime()) {
			if (!this.attacker.isDead()) {
				this.attacker.takeDamageIfAny();
			}
			if (!this.defender.isDead()) {
				this.defender.takeDamageIfAny();
			}
			if (!this.attacker.isDead() && !this.defender.isDead()) {
				this.attacker.tryToAttack(this.defender);
				this.defender.tryToAttack(this.attacker);
			}
			this.clock++;
		}
		
		if (this.attacker.isDead() && this.defender.isDead()) {
			if (!this.isQuiet) {
				System.out.println("Both attacker and defender are dead...");
			}
			return 0;
		} else if (this.defender.isDead()) {
			if (!this.isQuiet) {
				System.out.println(this.attacker.getSpecies().toString() + "(Attacker) win.");
			}
			return 100 * this.attacker.getHp() / this.attacker.getHpMax();
		} else {
			if (!this.isQuiet) {
				System.out.println(this.defender.getSpecies().toString() + "(Defender) win.");
			}
			return -100 * this.defender.getHp() / this.defender.getHpMax();
		}
	}
	
	public void log(Pokemon pokemon, String message) {
		if (!this.isQuiet) {
			System.out.println(String.format("[%d] - %s(%s, HP = %d(%d%%), Energy = %d) %s",
					this.clock,
					pokemon.getSpecies().toString(), 
					(pokemon.isDefender() ? "Defender" : "Attacker"),
					pokemon.getHp(),
					(int) (100 * pokemon.getHp() / pokemon.getHpMax()),
					(int) pokemon.getEnergy(),
					message));
		}
	}
	
	public int getClock() {
		return clock;
	}
	
}
