package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import control.PressEnterHandler;

public class Name extends JFrame{
	private PlaceholderTextField playerName;
	public Name() {
		this.playerName = new PlaceholderTextField("Player name:");
		setTitle("Pick Your Team!");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
		this.add(playerName);
		playerName.requestFocusInWindow();
		playerName.addActionListener(new PressEnterHandler(this));
	}
	public static void main(String[] args) {
		new Name();
	}
	public String getPlayerNameFromTF() {
		return playerName.getText();
	}
}
