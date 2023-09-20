package view;

import java.awt.Color;
import java.io.*;
import java.net.*;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import model.PlayerTeam;
import model.Pokemon;

public class CombatView extends JFrame {
	private String playerName, foeName;
    private JLabel messageLabel;
    private JTextField messageField;
    private JButton sendButton;
    private JPanel fight, info, skill;
	private GroupLayout combat;
    private PrintWriter output;
	private BufferedReader input;
	private PlayerTeam playerTeam;
	private Pokemon activePkm, foePkm;
	private Socket socket;
    
//, DataOutputStream output ,BufferedReader input
    public CombatView(String teamName) {
    	this.playerName = teamName;
    	this.playerTeam = new PlayerTeam(this.playerName);
    	this.activePkm = new Pokemon(
    			playerTeam.getPlayerTeam(0).getId(),
    			playerTeam.getPlayerTeam(0).getMove1(),
    			playerTeam.getPlayerTeam(0).getMove2(),
    			playerTeam.getPlayerTeam(0).getMove3(),
    			playerTeam.getPlayerTeam(0).getMove4()
    	);
    	this.foePkm = new Pokemon("673", null, null, null, null);
    	
        setTitle(this.playerName);
        setVisible(true);
        setSize(1200+16-200, 900+40-150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

		init();
    	connectToServer();
    }

    //initialize component
    public void init() {
    	Border panelBorder = BorderFactory.createLineBorder(Color.BLACK);
    	fight = new FightsPanel(activePkm, foePkm);
    	
        info = new InfomationPanel(this);
    	
        skill = new MovesPanel(this);
        
        combat = new GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(combat);		
        
        combat.setHorizontalGroup(
				combat.createSequentialGroup()
						.addGroup(combat.createParallelGroup()
								.addComponent(fight, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE)
								.addComponent(skill, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE))
						.addComponent(info, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
		);
		
		combat.setVerticalGroup(
				combat.createSequentialGroup()
						.addGroup(combat.createParallelGroup()
								.addGroup(combat.createSequentialGroup()
										.addComponent(fight, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
										.addComponent(skill, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
								.addComponent(info, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE))
						
		);
        
    }
    public void connectToServer() {
        String host = "127.0.0.1";
        int port = 3000;

        try {
            // Create a socket and connect to the server
            socket = new Socket(host, port); 

            // Create output stream for communication
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Start a new thread for receiving messages from the server
            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
//                	if((message = input.readLine()) != null) {
//                		System.out.print(message);
//                        this.teamName = message;                		
//                	}
                    while ((message = input.readLine()) != null) {
                    	JSONObject obj2 = (JSONObject)JSONValue.parse(message);
                    	if(obj2.containsKey("reduceHP")) {
                    		String temp = (String) obj2.get("reduceHP");
                    		JSONObject obj3 = (JSONObject)JSONValue.parse(temp);
                    		if(obj3.containsKey("self")) {
//                    			String valueS = (String) obj3.get("self");
//                    			int valueN = Integer.parseInt(valueS);
                    			((FightsPanel) fight).setMyHP((long)obj3.get("self"));
                    		} else if(obj3.containsKey("foe")) {
//                    			String valueS = (String) obj3.get("foe");
//                    			int valueN = Integer.parseInt(valueS);
                    			((FightsPanel) fight).setFoeHP((long)obj3.get("foe"));
                    		}
                    	} else if (obj2.containsKey("id")) {
                    		String idFoe = (String) obj2.get("id");
//                    		this.foePkm = new Pokemon(idFoe, null, null, null, null);
                    	} else
                    		this.showMessage((String)obj2.get("message"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

        } catch (IOException e) {
//            e.printStackTrace();
        	System.out.println("No server is found at port: 3000");
        }
    }
    
    
    public void sendMessage(String message) {
        this.showMessage(message);
        JSONObject jO = new JSONObject();
        jO.put("message", message);
		output.println(jO.toString());
    }
    public void sendAttackCommand(String message) {
        JSONObject jO = new JSONObject();
        jO.put("attack", message);
		output.println(jO.toString());
    }public void sendMyPkmToFoe(String pkmID) {
    	JSONObject jO = new JSONObject();
        jO.put("id", pkmID);
		output.println(jO.toString());
    }
    public void showMessage(String message) {
        ((InfomationPanel) info).getShowArea().append(message + "\n");;
    }

    public String getFoeName() {
    	return this.foeName;
    }
    

	public PlayerTeam getPlayerTeam() {
		return playerTeam;
	}

	public Pokemon getActivePokemon() {
		return activePkm;
	}

    public PrintWriter getOutput() {
		return output;
	}

	public BufferedReader getInput() {
		return input;
	}

	public String getPlayerName() {
		return playerName;
	}

	public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
            CombatView pick = new CombatView("team1");
        });
	}
}


