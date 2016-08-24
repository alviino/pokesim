package org.alviino.pokesim;

import junit.framework.TestCase;

public class BattleTest extends TestCase {
	
	private Battle battle;

	public BattleTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Pokemon snorlax = new Pokemon(Species.SNORLAX, BasicMove.ZEN_HEADBUTT, ChargeMove.HYPER_BEAM, 15, 15, 15, 40);
		Pokemon lapras = new Pokemon(Species.LAPRAS, BasicMove.FROST_BREATH, ChargeMove.BLIZZARD, 15, 15, 15, 40);
		this.battle = new Battle(snorlax, lapras, true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGo() {
//		fail("Not yet implemented");
		this.battle.go();
	}

}
