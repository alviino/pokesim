package org.alviino.pokesim;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Simulator implements ActionListener {

	private static final Double[] LEVEL = new Double[] {1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5, 6.0, 6.5, 7.0, 7.5, 8.0, 8.5, 9.0, 9.5, 10.0, 10.5, 11.0, 11.5, 12.0, 12.5, 13.0, 13.5, 14.0, 14.5, 15.0, 15.5, 16.0, 16.5, 17.0, 17.5, 18.0, 18.5, 19.0, 19.5, 20.0, 20.5, 21.0, 21.5, 22.0, 22.5, 23.0, 23.5, 24.0, 24.5, 25.0, 25.5, 26.0, 26.5, 27.0, 27.5, 28.0, 28.5, 29.0, 29.5, 30.0, 30.5, 31.0, 31.5, 32.0, 32.5, 33.0, 33.5, 34.0, 34.5, 35.0, 35.5, 36.0, 36.5, 37.0, 37.5, 38.0, 38.5, 39.0, 39.5, 40.0};
	private static final Integer[] IV = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	
	private final JTextArea textArea;
	private final JComboBox<Species> attackerSpecies;
	private final JComboBox<BasicMove> attackerBasicMove;
	private final JComboBox<ChargeMove> attackerChargeMove;
	private final JComboBox<Double> attackerLevel;
	private final JComboBox<Integer> attackerAttackIv;
	private final JComboBox<Integer> attackerDefenseIv;
	private final JComboBox<Integer> attackerStaminaIv;
	private final JComboBox<Species> defenderSpecies;
	private final JComboBox<BasicMove> defenderBasicMove;
	private final JComboBox<ChargeMove> defenderChargeMove;
	private final JComboBox<Double> defenderLevel;
	private final JComboBox<Integer> defenderAttackIv;
	private final JComboBox<Integer> defenderDefenseIv;
	private final JComboBox<Integer> defenderStaminaIv;
	
	public static void main(String[] args) {
		new Simulator();
	}
	
	private Simulator() {
		JFrame frame = new JFrame("Gym Battle Simulator");
//		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.attackerSpecies = new JComboBox<>(Species.values());
		this.attackerSpecies.addActionListener(this);
		this.attackerBasicMove = new JComboBox<>();
		this.attackerChargeMove = new JComboBox<>();
		this.attackerLevel = new JComboBox<>(Simulator.LEVEL);
		this.attackerAttackIv = new JComboBox<>(Simulator.IV);
		this.attackerDefenseIv = new JComboBox<>(Simulator.IV);
		this.attackerStaminaIv = new JComboBox<>(Simulator.IV);
		this.defenderSpecies = new JComboBox<>(Species.values());
		this.defenderSpecies.addActionListener(this);
		this.defenderBasicMove = new JComboBox<>();
		this.defenderChargeMove = new JComboBox<>();
		this.defenderLevel = new JComboBox<>(Simulator.LEVEL);
		this.defenderAttackIv = new JComboBox<>(Simulator.IV);
		this.defenderDefenseIv = new JComboBox<>(Simulator.IV);
		this.defenderStaminaIv = new JComboBox<>(Simulator.IV);
		
		GridLayout gridLayout = new GridLayout(3, 7);
		JPanel panel = new JPanel();
		panel.setLayout(gridLayout);
		
		panel.add(new JLabel("", SwingConstants.CENTER));
		panel.add(new JLabel("Species", SwingConstants.CENTER));
		panel.add(new JLabel("Basic Move", SwingConstants.CENTER));
		panel.add(new JLabel("Charge Move", SwingConstants.CENTER));
		panel.add(new JLabel("Attack IV", SwingConstants.CENTER));
		panel.add(new JLabel("Defense IV", SwingConstants.CENTER));
		panel.add(new JLabel("Stamina IV", SwingConstants.CENTER));
		panel.add(new JLabel("Level", SwingConstants.CENTER));
		panel.add(new JLabel("Attacker", SwingConstants.CENTER));
		panel.add(this.attackerSpecies);
		panel.add(this.attackerBasicMove);
		panel.add(this.attackerChargeMove);
		panel.add(this.attackerAttackIv);
		panel.add(this.attackerDefenseIv);
		panel.add(this.attackerStaminaIv);
		panel.add(this.attackerLevel);
		panel.add(new JLabel("Defender", SwingConstants.CENTER));
		panel.add(this.defenderSpecies);
		panel.add(this.defenderBasicMove);
		panel.add(this.defenderChargeMove);
		panel.add(this.defenderAttackIv);
		panel.add(this.defenderDefenseIv);
		panel.add(this.defenderStaminaIv);
		panel.add(this.defenderLevel);
		
//		for (int i = 0; i < panel.getComponents().length; i++) {
//			if (panel.getComponents()[i] instanceof JComboBox) {
//				((JComboBox) panel.getComponents()[i]).getRenderer().
//			}
//		}
		
		JButton goButton = new JButton("GO!");
		goButton.addActionListener(this);
		
		this.textArea = new JTextArea(40, 0);
		this.textArea.setLineWrap(true);
		this.textArea.setEditable(false);
		this.textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		PrintStream printStream = new PrintStream(new OutputStream() {

			@Override
			public void write(int b) throws IOException {
				Simulator.this.textArea.append(String.valueOf((char) b));
			}
			
		});
		System.setOut(printStream);
		System.setErr(printStream);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.add(goButton, BorderLayout.EAST);
		frame.add(new JScrollPane(textArea), BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			this.textArea.setText("");
			Pokemon attacker = new Pokemon(
					(Species) this.attackerSpecies.getSelectedItem(), 
					(BasicMove) this.attackerBasicMove.getSelectedItem(), 
					(ChargeMove) this.attackerChargeMove.getSelectedItem(), 
					(int) this.attackerAttackIv.getSelectedItem(), 
					(int) this.attackerDefenseIv.getSelectedItem(), 
					(int) this.attackerStaminaIv.getSelectedItem(), 
					(double) this.attackerLevel.getSelectedItem());
			Pokemon defender = new Pokemon(
					(Species) this.defenderSpecies.getSelectedItem(), 
					(BasicMove) this.defenderBasicMove.getSelectedItem(), 
					(ChargeMove) this.defenderChargeMove.getSelectedItem(), 
					(int) this.defenderAttackIv.getSelectedItem(), 
					(int) this.defenderDefenseIv.getSelectedItem(), 
					(int) this.defenderStaminaIv.getSelectedItem(), 
					(double) this.defenderLevel.getSelectedItem());
			Battle battle = new Battle(attacker, defender);
			battle.go();
		} else if (e.getSource() == this.attackerSpecies) {
			Species species = (Species) this.attackerSpecies.getSelectedItem();
			this.attackerBasicMove.removeAllItems();
			BasicMove[] basicMoves = species.getBasicMoves();
			for (int i = 0; i < basicMoves.length; i++) {
				this.attackerBasicMove.addItem(basicMoves[i]);
			}
			this.attackerChargeMove.removeAllItems();
			ChargeMove[] chargeMoves = species.getChargeMoves();
			for (int i = 0; i < chargeMoves.length; i++) {
				this.attackerChargeMove.addItem(chargeMoves[i]);
			}
		} else if (e.getSource() == this.defenderSpecies) {
			Species species = (Species) this.defenderSpecies.getSelectedItem();
			this.defenderBasicMove.removeAllItems();
			BasicMove[] basicMoves = species.getBasicMoves();
			for (int i = 0; i < basicMoves.length; i++) {
				this.defenderBasicMove.addItem(basicMoves[i]);
			}
			this.defenderChargeMove.removeAllItems();
			ChargeMove[] chargeMoves = species.getChargeMoves();
			for (int i = 0; i < chargeMoves.length; i++) {
				this.defenderChargeMove.addItem(chargeMoves[i]);
			}
		}
	}

}
