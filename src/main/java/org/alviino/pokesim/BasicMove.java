package org.alviino.pokesim;

public enum BasicMove implements Move {
	
	DUMMY_ATTACK       (Type.NONE    , 0 , 1000, 0 ),
	ACID               (Type.POISON  , 10, 1050, 10),
	BITE               (Type.DARK    , 6 , 500 , 7 ),
	BUBBLE             (Type.WATER   , 25, 2300, 25),
	BUG_BITE           (Type.BUG     , 5 , 450 , 7 ),
	BULLET_PUNCH       (Type.STEEL   , 10, 1200, 10),
	CONFUSION          (Type.PSYCHIC , 15, 1510, 14),
	CUT                (Type.NORMAL  , 12, 1130, 10),
	DRAGON_BREATH      (Type.DRAGON  , 6 , 500 , 7 ),
	EMBER              (Type.FIRE    , 10, 1050, 10),
	FEINT_ATTACK       (Type.DARK    , 12, 1040, 10),
	FIRE_FANG          (Type.FIRE    , 10, 840 , 8 ),
	FROST_BREATH       (Type.ICE     , 9 , 810 , 7 ),
	FURY_CUTTER        (Type.BUG     , 3 , 400 , 6 ),
	ICE_SHARD          (Type.ICE     , 15, 1400, 12),
	KARATE_CHOP        (Type.FIGHTING, 6 , 800 , 8 ),
	LICK               (Type.GHOST   , 5 , 500 , 6 ),
	LOW_KICK           (Type.FIGHTING, 5 , 600 , 7 ),
	METAL_CLAW         (Type.STEEL   , 8 , 630 , 7 ),
	MUD_SHOT           (Type.GROUND  , 6 , 550 , 7 ),
	MUD_SLAP           (Type.GROUND  , 15, 1350, 12),
	PECK               (Type.FLYING  , 10, 1150, 10),
	POISON_JAB         (Type.POISON  , 12, 1050, 10),
	POISON_STING       (Type.POISON  , 6 , 575 , 8 ),
	POUND              (Type.NORMAL  , 7 , 540 , 7 ),
	PSYCHO_CUT         (Type.PSYCHIC , 7 , 570 , 7 ),
	QUICK_ATTACK       (Type.NORMAL  , 10, 1330, 12),
	RAZOR_LEAF         (Type.GRASS   , 15, 1450, 12),
	ROCK_SMASH         (Type.FIGHTING, 15, 1410, 12),
	ROCK_THROW         (Type.ROCK    , 12, 1360, 15),
	SCRATCH            (Type.NORMAL  , 6 , 500 , 7 ),
	SHADOW_CLAW        (Type.GHOST   , 11, 950 , 8 ),
	SPARK              (Type.ELECTRIC, 7 , 700 , 8 ),
	SPLASH             (Type.WATER   , 0 , 1230, 10),
	STEEL_WING         (Type.STEEL   , 15, 1330, 12),
	SUCKER_PUNCH       (Type.DARK    , 7 , 700 , 9 ),
	TACKLE             (Type.NORMAL  , 12, 1100, 10),
	THUNDER_SHOCK      (Type.ELECTRIC, 5 , 600 , 8 ),
	VINE_WHIP          (Type.GRASS   , 7 , 650 , 7 ),
	WATER_GUN          (Type.WATER   , 6 , 500 , 7 ),
	WATER_GUN_BLASTOISE(Type.WATER   , 6 , 500 , 7 ),
	WING_ATTACK        (Type.FLYING  , 9 , 750 , 7 ),
	ZEN_HEADBUTT       (Type.PSYCHIC , 12, 1050, 9 );

	private final Type type;
	private final int power;
	private final int duration;
	private final double energyGeneration;
	
	private BasicMove(Type type, int power, int duration, double energyGeneration) {
		this.type = type;
		this.power = power;
		this.duration = duration;
		this.energyGeneration = energyGeneration;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public int getPower() {
		return power;
	}

	@Override
	public int getDuration() {
		return duration;
	}

	public double getEnergyGeneration() {
		return energyGeneration;
	}
	
}
