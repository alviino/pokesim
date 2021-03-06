package org.alviino.pokesim;

public class Calculator {

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

	public static int calculateDamage(Pokemon caster, Pokemon opponent, Move move) {
		double stab = 1.0;
		double effectiveness = 1.0;
		
		if (move.getType() == caster.getSpecies().getType()[0] || move.getType() == caster.getSpecies().getType()[1]) {
			stab *= 1.25;
		}
		
		effectiveness *= move.getType().getMultiplierAgainst(opponent.getSpecies().getType()[0]);
		effectiveness *= move.getType().getMultiplierAgainst(opponent.getSpecies().getType()[1]);
		
		return (int) (Math.floor(0.5 * caster.getAttack() / opponent.getDefense() * move.getPower() * stab * effectiveness) + 1);
	}
	
	public static int calculateCp(Species species, int attackIv, int defenseIv, int staminaIv, double level) {
		double attack = Calculator.calculateAttack(species, attackIv, level);
		double defense = Calculator.calculateDefense(species, defenseIv, level);
		double stamina = Calculator.calculateStamina(species, staminaIv, level);
		return Math.max(10, (int) Math.floor(attack * Math.sqrt(defense) * Math.sqrt(stamina) / 10));
	}
	
	public static int calculateHp(Species species, int staminaIv, double level, boolean isDefender) {
		return (int) (Calculator.getCpMultiplier(level) * ((isDefender ? 2 : 1) * species.getStamina() + staminaIv));
	}
	
	public static double calculateAttack(Species species, int attackIv, double level) {
		return Calculator.getCpMultiplier(level) * (species.getAttack() + attackIv);
	}
	
	public static double calculateDefense(Species species, int defenseIv, double level) {
		return Calculator.getCpMultiplier(level) * (species.getDefense() + defenseIv);
	}
	
	public static double calculateStamina(Species species, int staminaIv, double level) {
		return Calculator.getCpMultiplier(level) * (species.getStamina() + staminaIv);
	}
	
	public static double getCpMultiplier(double level) {
		return CPM_TABLE[(int) ((level - 1) / 0.5)];
	}

}
