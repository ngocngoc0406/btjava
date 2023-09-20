package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import control.PickTeamBtnHandler;
import model.Pokemon;

public class PickTeamView extends JFrame {
	private String teamName;
//	private JComboBox<String> pkm1CB, pkm2CB, pkm3CB, pkm4CB, pkm5CB, pkm6CB;
	private GroupLayout pick;
//	private PickPanel pkm1, pkm2, pkm3, pkm4, pkm5, pkm6;
	private ArrayList<PickPanel> pkmList;
	private ArrayList<JComboBox> pkmPickCB;
	private JButton okButton;
	private DataOutputStream output;
	private BufferedReader input;
	private Socket socket;   

    public PickTeamView(String teamName) {
    	this.teamName = teamName;
    	pkmList = new ArrayList<>(6);
    	pkmPickCB = new ArrayList<>(6);
    	
        setTitle("Pick Your Team!");
        setSize(1200+15, 900+40);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

		init();
		
		addActionListener();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PickTeamView pick = new PickTeamView("team1");
        });
    }

    
    //initialize component
    public void init() {        
        pick = new GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(pick);
		
		addPokemonCBData();
		pkmList.add(new PickPanel("blank", pkmPickCB.get(0)));
		pkmList.add(new PickPanel("blank", pkmPickCB.get(1)));
		pkmList.add(new PickPanel("blank", pkmPickCB.get(2)));
		pkmList.add(new PickPanel("blank", pkmPickCB.get(3)));
		pkmList.add(new PickPanel("blank", pkmPickCB.get(4)));
		pkmList.add(new PickPanel("blank", pkmPickCB.get(5)));
		
		
		okButton = new JButton("OK");
		
		pick.setHorizontalGroup(
				pick.createSequentialGroup()
					.addGroup(pick.createParallelGroup()
							.addGroup(pick.createSequentialGroup()
									.addComponent(pkmList.get(0))
									.addComponent(pkmList.get(1)))
							.addGroup(pick.createSequentialGroup()
									.addComponent(pkmList.get(2))
									.addComponent(pkmList.get(3)))
							.addGroup(pick.createSequentialGroup()
									.addComponent(pkmList.get(4))
									.addComponent(pkmList.get(5)))
							.addGroup(pick.createSequentialGroup()
									.addGap(980)
									.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))		
		);
		
		pick.setVerticalGroup(
				pick.createSequentialGroup()
					.addGroup(pick.createParallelGroup()
							.addComponent(pkmList.get(0))
							.addComponent(pkmList.get(1)))
					.addGroup(pick.createParallelGroup()
							.addComponent(pkmList.get(2))
							.addComponent(pkmList.get(3)))
					.addGroup(pick.createParallelGroup()
							.addComponent(pkmList.get(4))
							.addComponent(pkmList.get(5)))
					.addGroup(pick.createParallelGroup()
							.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					
		);
        
    }
    
    public void addPokemonCBData() {
		this.pkmPickCB.add(new JComboBox<String>());
		this.pkmPickCB.add(new JComboBox<String>());
		this.pkmPickCB.add(new JComboBox<String>());
		this.pkmPickCB.add(new JComboBox<String>());
		this.pkmPickCB.add(new JComboBox<String>());
		this.pkmPickCB.add(new JComboBox<String>());
		
    	JSONParser jsonParser = new JSONParser();
		try {
			FileReader jsonString= new FileReader("pokemon_data\\all_pokemon.json");
	        JSONArray jsonObject = (JSONArray) jsonParser.parse(jsonString);
	        for(Object o : jsonObject)
	        {
	        	pkmPickCB.get(0).addItem((String) o);
	        	pkmPickCB.get(1).addItem((String) o);
	        	pkmPickCB.get(2).addItem((String) o);
	        	pkmPickCB.get(3).addItem((String) o);
	        	pkmPickCB.get(4).addItem((String) o);
	        	pkmPickCB.get(5).addItem((String) o);
	        }
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		setSelectedTeam();
    }
    
    public void setSelectedTeam() {
    	JSONParser jsonParser = new JSONParser();
		try {
			FileReader jsonString= new FileReader("team_data\\"+this.teamName+".json");
	        JSONArray jsonObject = (JSONArray) jsonParser.parse(jsonString);
	        int i = 0;
	        for(Object o : jsonObject)
	        {
	        	JSONObject p = (JSONObject) o;
	        	pkmPickCB.get(i).setSelectedItem(p.get("pkmID"));
	        	i++;
	        }
		} catch (IOException e) {
			System.out.println("Player name not found");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
    
    public void addActionListener() {
    	this.okButton.addActionListener(new PickTeamBtnHandler(this));
    }
    
	@Override
	public String toString() {
		return "["+pkmList.get(0).toString()+","
				+pkmList.get(1).toString()+","
				+pkmList.get(2).toString()+","
				+pkmList.get(3).toString()+","
				+pkmList.get(4).toString()+","
				+pkmList.get(5).toString()+"]";
	}
	public String getTeamName() {
		return this.teamName;
	}
	
}





