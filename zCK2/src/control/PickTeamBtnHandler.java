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

public class PickTeamBtnHandler implements ActionListener{
	private PickTeamView ptv;
	
	public PickTeamBtnHandler(PickTeamView ptv) {
		super();
		this.ptv = ptv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(ptv.getTeamName().equals("")) {
			JOptionPane.showMessageDialog(null, "Player name must be none NULL!", "Error", JOptionPane.ERROR_MESSAGE);
		} else { 
			
			int result = JOptionPane.showConfirmDialog(
				null,
				"Do you want to proceed?",
				"Confirmation",
				JOptionPane.YES_NO_OPTION
			);
			
			if(result == JOptionPane.YES_OPTION) {
				writeJsonToFile();
				this.ptv.dispose();
				new CombatView(ptv.getTeamName());	
				
			}
		}
		
	}
		
	public void writeJsonToFile() {
        try (FileWriter fileWriter = new FileWriter("team_data\\"+this.ptv.getTeamName()+".json")) {
            fileWriter.write(ptv.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
