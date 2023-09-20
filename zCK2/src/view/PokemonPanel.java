package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Pokemon;

public class PokemonPanel extends JPanel{
	private Pokemon pokemon;
	public PokemonPanel(Pokemon pokemon) {		
		this.pokemon = pokemon;
    	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	this.add(new JLabel(pokemon.getName()));
	}

}
