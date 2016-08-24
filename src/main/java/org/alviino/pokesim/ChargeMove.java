package org.alviino.pokesim;

public enum ChargeMove implements Move {

	DUMMY_ATTACK        (Type.NONE    , 0  , 9999, 100  , 0.00),
	AERIAL_ACE          (Type.FLYING  , 30 , 2900, 25   , 0.05),
	AIR_CUTTER          (Type.FLYING  , 30 , 3300, 25   , 0.25),
	ANCIENT_POWER       (Type.ROCK    , 35 , 3600, 25   , 0.05),
	AQUA_JET            (Type.WATER   , 25 , 2350, 20   , 0.05),
	AQUA_TAIL           (Type.WATER   , 45 , 2350, 50   , 0.05),
	BLIZZARD            (Type.ICE     , 100, 3900, 100  , 0.05),
	BODY_SLAM           (Type.NORMAL  , 40 , 1560, 50   , 0.05),
	BONE_CLUB           (Type.GROUND  , 25 , 1600, 25   , 0.05),
	BRICK_BREAK         (Type.FIGHTING, 30 , 1600, 100/3, 0.25),
	BRINE               (Type.WATER   , 25 , 2400, 25   , 0.05),
	BUBBLE_BEAM         (Type.WATER   , 30 , 2900, 25   , 0.05),
	BUG_BUZZ            (Type.BUG     , 75 , 4250, 50   , 0.05),
	BULLDOZE            (Type.GROUND  , 35 , 3400, 25   , 0.05),
	CROSS_CHOP          (Type.FIGHTING, 60 , 2000, 100  , 0.25),
	CROSS_POISON        (Type.POISON  , 25 , 1500, 25   , 0.25),
	DARK_PULSE          (Type.DARK    , 45 , 3500, 100/3, 0.05),
	DAZZLING_GLEAM      (Type.FAIRY   , 55 , 4200, 100/3, 0.05),
	DIG                 (Type.GROUND  , 70 , 5800, 100/3, 0.05),
	DISARMING_VOICE     (Type.FAIRY   , 25 , 3900, 20   , 0.05),
	DISCHARGE           (Type.ELECTRIC, 35 , 2500, 100/3, 0.05),
	DRAGON_CLAW         (Type.DRAGON  , 35 , 1500, 50   , 0.25),
	DRAGON_PULSE        (Type.DRAGON  , 65 , 3600, 50   , 0.05),
	DRAINING_KISS       (Type.FAIRY   , 25 , 2800, 20   , 0.05),
	DRILL_PECK          (Type.FLYING  , 40 , 2700, 100/3, 0.05),
	DRILL_RUN           (Type.GROUND  , 50 , 3400, 100/3, 0.25),
	EARTHQUAKE          (Type.GROUND  , 100, 4200, 100  , 0.05),
	FIRE_BLAST          (Type.FIRE    , 100, 4100, 100  , 0.05),
	FIRE_PUNCH          (Type.FIRE    , 40 , 2800, 100/3, 0.05),
	FLAMETHROWER        (Type.FIRE    , 55 , 2900, 50   , 0.05),
	FLAME_BURST         (Type.FIRE    , 30 , 2100, 25   , 0.05),
	FLAME_CHARGE        (Type.FIRE    , 25 , 3100, 20   , 0.05),
	FLAME_WHEEL         (Type.FIRE    , 40 , 4600, 25   , 0.05),
	FLASH_CANNON        (Type.STEEL   , 60 , 3900, 100/3, 0.05),
	GIGA_DRAIN          (Type.GRASS   , 50 , 3600, 100/3, 0.05),
	GUNK_SHOT           (Type.POISON  , 65 , 3000, 100  , 0.05),
	HEART_STAMP         (Type.PSYCHIC , 25 , 2550, 25   , 0.05),
	HEAT_WAVE           (Type.FIRE    , 80 , 3800, 100  , 0.05),
	HORN_ATTACK         (Type.NORMAL  , 25 , 2200, 25   , 0.05),
	HURRICANE           (Type.FLYING  , 80 , 3200, 100  , 0.05),
	HYDRO_PUMP          (Type.WATER   , 90 , 3800, 100  , 0.05),
	HYDRO_PUMP_BLASTOISE(Type.WATER   , 90 , 3800, 100  , 0.05),
	HYPER_BEAM          (Type.NORMAL  , 120, 5000, 100  , 0.05),
	HYPER_FANG          (Type.NORMAL  , 35 , 2100, 100/3, 0.05),
	ICE_BEAM            (Type.ICE     , 65 , 3650, 50   , 0.05),
	ICE_PUNCH           (Type.ICE     , 45 , 3500, 100/3, 0.05),
	ICY_WIND            (Type.ICE     , 25 , 3800, 20   , 0.05),
	IRON_HEAD           (Type.STEEL   , 30 , 2000, 100/3, 0.05),
	LEAF_BLADE          (Type.GRASS   , 55 , 2800, 50   , 0.25),
	LOW_SWEEP           (Type.FIGHTING, 30 , 2250, 25   , 0.05),
	MAGNET_BOMB         (Type.STEEL   , 30 , 2800, 25   , 0.05),
	MEGAHORN            (Type.BUG     , 80 , 3200, 100  , 0.05),
	MEGA_DRAIN          (Type.GRASS   , 25 , 3200, 20   , 0.05),
	MOONBLAST           (Type.FAIRY   , 85 , 4100, 100  , 0.05),
	MUD_BOMB            (Type.GROUND  , 30 , 2600, 25   , 0.05),
	NIGHT_SLASH         (Type.DARK    , 30 , 2700, 25   , 0.25),
	OMINOUS_WIND        (Type.GHOST   , 30 , 3100, 25   , 0.05),
	PARABOLIC_CHARGE    (Type.ELECTRIC, 25 , 2100, 20   , 0.05),
	PETAL_BLIZZARD      (Type.GRASS   , 65 , 3200, 50   , 0.05),
	PLAY_ROUGH          (Type.FAIRY   , 55 , 2900, 50   , 0.05),
	POISON_FANG         (Type.POISON  , 25 , 2400, 20   , 0.05),
	POWER_GEM           (Type.ROCK    , 40 , 2900, 100/3, 0.05),
	POWER_WHIP          (Type.GRASS   , 70 , 2800, 100  , 0   ),
	PSYBEAM             (Type.PSYCHIC , 40 , 3800, 25   , 0.05),
	PSYCHIC             (Type.PSYCHIC , 55 , 2800, 50   , 0.05),
	PSYSHOCK            (Type.PSYCHIC , 40 , 2700, 100/3, 0.05),
	PSYSTRIKE           (Type.PSYCHIC , 100, 5100, 100  , 0.05),
	REST                (Type.NORMAL  , 35 , 3100, 100/3, 0   ),
	ROCK_SLIDE          (Type.ROCK    , 50 , 3200, 100/3, 0.05),
	ROCK_TOMB           (Type.ROCK    , 30 , 3400, 25   , 0.25),
	SCALD               (Type.WATER   , 55 , 4000, 100/3, 0.05),
	SCALD_BLASTOISE     (Type.WATER   , 55 , 4000, 100/3, 0.05),
	SEED_BOMB           (Type.GRASS   , 40 , 2400, 100/3, 0.05),
	SHADOW_BALL         (Type.GHOST   , 45 , 3080, 100/3, 0.05),
	SHADOW_PUNCH        (Type.GHOST   , 25 , 2100, 25   , 0.05),
	SHADOW_SNEAK        (Type.GHOST   , 25 , 3100, 20   , 0.05),
	SIGNAL_BEAM         (Type.BUG     , 45 , 3100, 100/3, 0.05),
	SLUDGE              (Type.POISON  , 30 , 2600, 25   , 0.05),
	SLUDGE_BOMB         (Type.POISON  , 55 , 2600, 50   , 0.05),
	SLUDGE_WAVE         (Type.POISON  , 70 , 3400, 100  , 0.05),
	SOLAR_BEAM          (Type.GRASS   , 120, 4900, 100  , 0.05),
	STOMP               (Type.NORMAL  , 30 , 2100, 25   , 0.05),
	STONE_EDGE          (Type.ROCK    , 80 , 3100, 100  , 0.5 ),
	STRUGGLE            (Type.NORMAL  , 15 , 1695, 20   , 0   ),
	SUBMISSION          (Type.FIGHTING, 30 , 2100, 100/3, 0.05),
	SWIFT               (Type.NORMAL  , 30 , 3000, 25   , 0.05),
	THUNDER             (Type.ELECTRIC, 100, 4300, 100  , 0.05),
	THUNDERBOLT         (Type.ELECTRIC, 55 , 2700, 50   , 0.05),
	THUNDER_PUNCH       (Type.ELECTRIC, 40 , 2400, 100/3, 0.05),
	TWISTER             (Type.DRAGON  , 25 , 2700, 20   , 0.05),
	VICE_GRIP           (Type.NORMAL  , 25 , 2100, 20   , 0.05),
	WATER_PULSE         (Type.WATER   , 35 , 3300, 25   , 0.05),
	WRAP                (Type.NORMAL  , 25 , 4000, 20   , 0.05),
	WRAP_GREEN          (Type.NORMAL  , 25 , 3700, 20   , 0.05),
	WRAP_PINK           (Type.NORMAL  , 25 , 3700, 20   , 0.05),
	X_SCISSOR           (Type.BUG     , 35 , 2100, 100/3, 0.05);

	private final Type type;
	private final int power;
	private final int duration;
	private final double energyCost;
	private final double criticalRate;
	
	private ChargeMove(Type type, int power, int duration, double energyCost, double cirticalRate) {
		this.type = type;
		this.power = power;
		this.duration = duration;
		this.energyCost = energyCost;
		this.criticalRate = cirticalRate;
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

	public double getEnergyCost() {
		return energyCost;
	}

	public double getCriticalRate() {
		return criticalRate;
	}

}
