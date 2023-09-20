package view;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Move;

public class MovePanel extends JPanel{
	private Move move;
	private GroupLayout panelLayout;

	public MovePanel(Move move) {
		super();
		this.move = move;
    	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	this.setBackground(getColor());
    	init();
	}
	
	public void init() {
		JLabel name = new JLabel(move.getName());
		JLabel type = new JLabel(move.getType());
		JLabel category = new JLabel(move.getCategory());
		
		panelLayout = new GroupLayout(this);
		this.setLayout(panelLayout);
		
//		panelLayout.setAutoCreateGaps(true);
//		panelLayout.setAutoCreateContainerGaps(true);
		
		panelLayout.setHorizontalGroup(
				panelLayout.createSequentialGroup()
				.addGap(10)
						.addGroup(panelLayout.createParallelGroup()
								.addGroup(panelLayout.createSequentialGroup()
										.addGap(32)
										.addComponent(name))
								.addGroup(panelLayout.createSequentialGroup()
										.addComponent(type)
										.addGap(52)
										.addComponent(category)))
					
		);
		
		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
						.addGap(3)
						.addComponent(name)
						.addGroup(panelLayout.createParallelGroup()
								.addComponent(type)
								.addComponent(category))
		);
	}
	
	public Color getColor() {
		if(this.move.getType().equalsIgnoreCase("normal")) {
			return Color.decode("#a8a878");
		}
		else if(this.move.getType().equalsIgnoreCase("fire")) {
			return Color.decode("#f08030");
		}
		else if(this.move.getType().equalsIgnoreCase("water")) {
			return Color.decode("#6890f0");
		}
		else if(this.move.getType().equalsIgnoreCase("grass")) {
			return Color.decode("#78c850");
		}
		else if(this.move.getType().equalsIgnoreCase("poison")) {
			return Color.decode("#a040a0");
		}
		else if(this.move.getType().equalsIgnoreCase("electric")) {
			return Color.decode("#f8d030");
		}
		else if(this.move.getType().equalsIgnoreCase("ground")) {
			return Color.decode("#e0c068");
		}
		else if(this.move.getType().equalsIgnoreCase("psychic")) {
			return Color.decode("#f85888");
		}
		else if(this.move.getType().equalsIgnoreCase("rock")) {
			return Color.decode("#b8a038");
		}
		else if(this.move.getType().equalsIgnoreCase("ice")) {
			return Color.decode("#98d8d8");
		}
		else if(this.move.getType().equalsIgnoreCase("bug")) {
			return Color.decode("#a8b820");
		}
		else if(this.move.getType().equalsIgnoreCase("dragon")) {
			return Color.decode("#7038f8");
		}
		else if(this.move.getType().equalsIgnoreCase("ghost")) {
			return Color.decode("#705898");
		}
		else if(this.move.getType().equalsIgnoreCase("steel")) {
			return Color.decode("#b8b8d0");
		}
		else if(this.move.getType().equalsIgnoreCase("fairy")) {
			return Color.decode("#ee99ac");
		}
		else if(this.move.getType().equalsIgnoreCase("dark")) {
			return Color.decode("#705848");
		}
		else if(this.move.getType().equalsIgnoreCase("flying")) {
			return Color.decode("#a890f0");
		}
		else if(this.move.getType().equalsIgnoreCase("fighting")) {
			return Color.decode("#c02038");
		}
		else
			return null;
		
	}

	public Move getMove() {
		return move;
	}
	
}
