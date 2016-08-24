package org.alviino.pokesim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class MatrixGenerator {

	public static void main(String[] args) {
//		if (args.length < 1) {
//			System.err.println("Please specify the file name of output");
//			return;
//		}
		String pathname = "C:/Users/aguo/Documents/pokemon_battle_matrix.csv";
		int level = 30;
		
		TreeMap<String, TreeMap<String, Integer>> matrix = new TreeMap<>();
		ArrayList<Pokemon> attackerList = new ArrayList<>();
		ArrayList<Pokemon> defenderList = new ArrayList<>();
		
//		Species[] species = Species.values();
		Species[] species = new Species[] {
//				Species.MEWTWO,
//				Species.MEW,
//				Species.ARTICUNO,
//				Species.MOLTRES,
//				Species.ZAPDOS,
				Species.SNORLAX,
				Species.DRAGONITE,
				Species.LAPRAS,
				Species.VAPOREON,
				Species.ARCANINE,
				Species.EXEGGUTOR,
				Species.BLASTOISE,
				Species.SLOWBRO,
				Species.GYARADOS,
				Species.MUK,
				Species.VENUSAUR,
				Species.CHARIZARD,
				Species.POLIWRATH,
				Species.NIDOQUEEN,
				Species.WIGGLYTUFF,
//				Species.GOLDUCK,
//				Species.GOLEM,
//				Species.NIDOKING,
//				Species.VILEPLUME,
				Species.CLEFABLE,
//				Species.OMASTAR,
//				Species.HYPNO,
//				Species.VICTREEBEL,
//				Species.RHYDON,
//				Species.DEWGONG,
//				Species.FLAREON	
		};
		for (int i = 0; i < species.length; i++) {
			BasicMove[] basicMoves = species[i].getBasicMoves();
			ChargeMove[] chargeMoves = species[i].getChargeMoves();
			for (int j = 0; j < basicMoves.length; j++) {
				for (int k = 0; k < chargeMoves.length; k++) {
					Pokemon attacker = new Pokemon(species[i], basicMoves[j], chargeMoves[k], 15, 15, 15, level);
					Pokemon defender = new Pokemon(species[i], basicMoves[j], chargeMoves[k], 15, 15, 15, level);
					attackerList.add(attacker);
					defenderList.add(defender);
				}
			}
		}
		for (Pokemon attacker : attackerList) {
//		attackerList.parallelStream().forEach((attacker) -> {
			TreeMap<String, Integer> row = new TreeMap<>();
			for (Pokemon defender : defenderList) {
//			defenderList.parallelStream().forEach((defender) -> {
				Battle battle = new Battle(attacker, defender, true);
				int result = battle.go();
				row.put(defender.getSpeciesMoveSetCombinationName(), result);
//			});
			}
			matrix.put(attacker.getSpeciesMoveSetCombinationName(), row);
//		});
		}
		
		try (PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(new File(pathname))))) {
			for (String name : matrix.keySet()) {
				printer.print("," + name);
			}
			printer.println();
			for (String name : matrix.keySet()) {
				printer.print(name);
				for (int result : matrix.get(name).values()) {
					printer.print("," + result);
				}
				printer.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
