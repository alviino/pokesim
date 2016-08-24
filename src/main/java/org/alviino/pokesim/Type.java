package org.alviino.pokesim;

public enum Type {

	NORMAL,
	FIGHTING,
	FLYING,
	POISON,
	GROUND,
	ROCK,
	BUG,
	GHOST,
	STEEL,
	FIRE,
	GRASS,
	WATER,
	ELECTRIC,
	PSYCHIC,
	ICE,
	DRAGON,
	DARK,
	FAIRY,
	NONE;

	public double getMultiplierAgainst(Type type) {
		switch (this) {
		case NORMAL:
			if (type == ROCK || type == GHOST || type == STEEL) {
				return 0.8;
			} else {
				return 1.0;
			}
		case FIGHTING:
			if (type == FLYING || type == POISON || type == BUG || type == GHOST || type == PSYCHIC || type == FAIRY) {
				return 0.8;
			} else if (type == NORMAL || type == ROCK || type == STEEL || type == ICE || type == DARK) {
				return 1.25;
			} else {
				return 1.0;
			}
		case FLYING:
			if (type == ROCK || type == STEEL || type == ELECTRIC) {
				return 0.8;
			} else if (type == FIGHTING || type == BUG || type == GRASS) {
				return 1.25;
			} else {
				return 1.0;
			}
		case POISON:
			if (type == POISON || type == GROUND || type == ROCK || type == GHOST || type == STEEL) {
				return 0.8;
			} else if (type == GRASS || type == FAIRY) {
				return 1.25;
			} else {
				return 1.0;
			}
		case GROUND:
			if (type == FLYING || type == BUG || type == GRASS) {
				return 0.8;
			} else if (type == POISON || type == FIRE || type == ROCK || type == ELECTRIC || type == STEEL) {
				return 1.25;
			} else {
				return 1.0;
			}
		case ROCK:
			if (type == FIGHTING || type == GROUND || type == STEEL) {
				return 0.8;
			} else if (type == FLYING || type == BUG || type == FIRE || type == ICE) {
				return 1.25;
			} else {
				return 1.0;
			}
		case BUG:
			if (type == FIGHTING || type == FLYING || type == POISON || type == STEEL || type == GHOST || type == FIRE || type == FAIRY) {
				return 0.8;
			} else if (type == GRASS || type == PSYCHIC || type == DARK) {
				return 1.25;
			} else {
				return 1.0;
			}
		case GHOST:
			if (type == NORMAL || type == DARK) {
				return 0.8;
			} else if (type == GHOST || type == PSYCHIC) {
				return 1.25;
			} else {
				return 1.0;
			}
		case STEEL:
			if (type == STEEL || type == FIRE || type == WATER || type == ELECTRIC) {
				return 0.8;
			} else if (type == ROCK || type == FAIRY || type == ICE) {
				return 1.25;
			} else {
				return 1.0;
			}
		case FIRE:
			if (type == ROCK || type == FIRE || type == WATER || type == DRAGON) {
				return 0.8;
			} else if (type == BUG || type == STEEL || type == GRASS || type == ICE) {
				return 1.25;
			} else {
				return 1.0;
			}
		case GRASS:
			if (type == FLYING || type == POISON || type == BUG || type == STEEL || type == FIRE || type == GRASS || type == DRAGON) {
				return 0.8;
			} else if (type == GROUND || type == ROCK || type == WATER) {
				return 1.25;
			} else {
				return 1.0;
			}
		case WATER:
			if (type == WATER || type == GRASS || type == DRAGON) {
				return 0.8;
			} else if (type == GROUND || type == ROCK || type == FIRE) {
				return 1.25;
			} else {
				return 1.0;
			}
		case ELECTRIC:
			if (type == GROUND || type == GRASS || type == ELECTRIC || type == DRAGON) {
				return 0.8;
			} else if (type == FLYING || type == WATER) {
				return 1.25;
			} else {
				return 1.0;
			}
		case PSYCHIC:
			if (type == STEEL || type == PSYCHIC || type == DARK) {
				return 0.8;
			} else if (type == FIGHTING || type == POISON) {
				return 1.25;
			} else {
				return 1.0;
			}
		case ICE:
			if (type == STEEL || type == FIRE || type == WATER || type == ICE) {
				return 0.8;
			} else if (type == FLYING || type == GROUND || type == GRASS || type == DRAGON) {
				return 1.25;
			} else {
				return 1.0;
			}
		case DRAGON:
			if (type == STEEL || type == FAIRY) {
				return 0.8;
			} else if (type == DRAGON) {
				return 1.25;
			} else {
				return 1.0;
			}
		case DARK:
			if (type == FIGHTING || type == DARK || type == FAIRY) {
				return 0.8;
			} else if (type == GHOST || type == PSYCHIC) {
				return 1.25;
			} else {
				return 1.0;
			}
		case FAIRY:
			if (type == STEEL || type == FIRE || type == POISON) {
				return 0.8;
			} else if (type == FIGHTING || type == DRAGON || type == DARK) {
				return 1.25;
			} else {
				return 1.0;
			}
		default:
			return 1.0;
		}
	}
	
}
