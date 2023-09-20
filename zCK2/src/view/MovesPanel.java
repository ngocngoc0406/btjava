package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.AttackPressHandler;
import model.PlayerTeam;
import model.Pokemon;

public class MovesPanel extends JPanel{
	private CombatView cbView;
	private PlayerTeam pteam;
	private GroupLayout panelLayout;
	private Pokemon activePkm;
	private MovePanel move1P, move2P, move3P, move4P;
	private MoveDetails detail;
	private PokemonPanel pokemon1P, pokemon2P, pokemon3P, pokemon4P, pokemon5P, pokemon6P;
	
	public MovesPanel(CombatView cbView) {
		this.cbView = cbView;
		this.pteam = cbView.getPlayerTeam();
		this.activePkm = cbView.getActivePokemon();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		init();
		addMoveListener();
	}
	
	public void init() {
		JLabel labelATK = new JLabel("Attack");
		labelATK.setFont(new Font("Arial", Font.PLAIN, 20));
		labelATK.setForeground(Color.RED);
		detail = new MoveDetails();
		
		move1P = new MovePanel(activePkm.getMove1());
		move2P = new MovePanel(activePkm.getMove2());
		move3P = new MovePanel(activePkm.getMove3());
		move4P = new MovePanel(activePkm.getMove4());
		
		JLabel labelSwitch = new JLabel("Switch");
		labelSwitch.setFont(new Font("Arial", Font.PLAIN, 20));
		labelSwitch.setForeground(Color.decode("#4d3117"));
		
		pokemon1P = new PokemonPanel(pteam.getPlayerTeam(0));
		pokemon2P = new PokemonPanel(pteam.getPlayerTeam(1));
		pokemon3P = new PokemonPanel(pteam.getPlayerTeam(2));
		pokemon4P = new PokemonPanel(pteam.getPlayerTeam(3));
		pokemon5P = new PokemonPanel(pteam.getPlayerTeam(4));
		pokemon6P = new PokemonPanel(pteam.getPlayerTeam(5));
		
		panelLayout = new GroupLayout(this);
		this.setLayout(panelLayout);

//		panelLayout.setAutoCreateGaps(true);
		panelLayout.setAutoCreateContainerGaps(true);

		int moveX = 153;
		int pokemonX = 102;
		panelLayout.setHorizontalGroup(
				panelLayout.createSequentialGroup()
						.addGroup(panelLayout.createParallelGroup()
								.addGroup(panelLayout.createParallelGroup()
										.addComponent(labelATK)
										.addGroup(panelLayout.createSequentialGroup()
												.addComponent(move1P, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE)
												.addComponent(move2P, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE)
												.addComponent(move3P, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE)
												.addComponent(move4P, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE))
										.addComponent(detail, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE))
								.addGroup(panelLayout.createParallelGroup()
										.addComponent(labelSwitch))
										.addGroup(panelLayout.createSequentialGroup()
												.addComponent(pokemon1P, GroupLayout.PREFERRED_SIZE, pokemonX, GroupLayout.PREFERRED_SIZE)
												.addComponent(pokemon2P, GroupLayout.PREFERRED_SIZE, pokemonX, GroupLayout.PREFERRED_SIZE)
												.addComponent(pokemon3P, GroupLayout.PREFERRED_SIZE, pokemonX, GroupLayout.PREFERRED_SIZE)
												.addComponent(pokemon4P, GroupLayout.PREFERRED_SIZE, pokemonX, GroupLayout.PREFERRED_SIZE)
												.addComponent(pokemon5P, GroupLayout.PREFERRED_SIZE, pokemonX, GroupLayout.PREFERRED_SIZE)
												.addComponent(pokemon6P, GroupLayout.PREFERRED_SIZE, pokemonX, GroupLayout.PREFERRED_SIZE)))					
		);
		
		int moveY = 40;
		int pokemonY = 30;
		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
						.addGroup(panelLayout.createSequentialGroup()
								.addGroup(panelLayout.createParallelGroup()
										.addComponent(labelATK))
								.addGroup(panelLayout.createParallelGroup()
										.addComponent(move1P, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE)
										.addComponent(move2P, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE)
										.addComponent(move3P, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE)
										.addComponent(move4P, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE))
								.addComponent(detail, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))	
						.addGap(20)
						.addGroup(panelLayout.createSequentialGroup()
								.addComponent(labelSwitch))
								.addGroup(panelLayout.createParallelGroup()
										.addComponent(pokemon1P, GroupLayout.PREFERRED_SIZE, pokemonY, GroupLayout.PREFERRED_SIZE)
										.addComponent(pokemon2P, GroupLayout.PREFERRED_SIZE, pokemonY, GroupLayout.PREFERRED_SIZE)
										.addComponent(pokemon3P, GroupLayout.PREFERRED_SIZE, pokemonY, GroupLayout.PREFERRED_SIZE)
										.addComponent(pokemon4P, GroupLayout.PREFERRED_SIZE, pokemonY, GroupLayout.PREFERRED_SIZE)
										.addComponent(pokemon5P, GroupLayout.PREFERRED_SIZE, pokemonY, GroupLayout.PREFERRED_SIZE)
										.addComponent(pokemon6P, GroupLayout.PREFERRED_SIZE, pokemonY, GroupLayout.PREFERRED_SIZE))
		);
	}
	private void addMoveListener() {
		move1P.addMouseListener(new AttackPressHandler(cbView, move1P));
		move2P.addMouseListener(new AttackPressHandler(cbView, move2P));
		move3P.addMouseListener(new AttackPressHandler(cbView, move3P));
		move4P.addMouseListener(new AttackPressHandler(cbView, move4P));

	}
}
