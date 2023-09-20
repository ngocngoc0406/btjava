package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import org.json.simple.JSONObject;

import view.CombatView;
import view.PickTeamView;
import view.Name;

public class PressEnterHandler implements ActionListener{
	private Name frame;
	
	public PressEnterHandler(Name frame) {
		super();
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(frame.getPlayerNameFromTF().equals("")) {
			JOptionPane.showMessageDialog(null, "Player name must be none NULL!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			new PickTeamView(frame.getPlayerNameFromTF());
			frame.dispose();
		}
	}
		
	

}
