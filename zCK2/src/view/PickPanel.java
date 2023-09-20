package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PickPanel extends JPanel{
	JComboBox<String> choosedPkm;
	private JComboBox<String> move1, move2, move3, move4;
	private GroupLayout panelLayout;
	private JLabel spriteLabel = null;
	public PickPanel(String pkmID, JComboBox<String> choosedPkm) {
		super();
		this.choosedPkm = choosedPkm;
    	Border panelBorder = BorderFactory.createLineBorder(Color.BLACK);
    	setBorder(panelBorder);

		spriteLabel = creSprite(((String)this.choosedPkm.getSelectedItem()).substring(0,3));
		
		this.choosedPkm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the selection label text
                String selected = (String) choosedPkm.getSelectedItem();
                String pkmIDSelected = selected.substring(0,3);
                changeImage(spriteLabel, pkmIDSelected);

        		createMoveCB(pkmIDSelected);
        		setSelectedMove();
            }
        });
		
		move1 = new JComboBox<>();
		move2 = new JComboBox<>();
		move3 = new JComboBox<>();
		move4 = new JComboBox<>();

		createMoveCB(((String) choosedPkm.getSelectedItem()).substring(0,3));
		setSelectedMove();
		
        panelLayout = new GroupLayout(this);
		this.setLayout(panelLayout);
		
//		panelLayout.setAutoCreateGaps(true);
		panelLayout.setAutoCreateContainerGaps(true);
		
        int moveX = 316;
        int moveY = 40;
		panelLayout.setHorizontalGroup(
				panelLayout.createSequentialGroup()
					.addComponent(spriteLabel)
					.addGroup(panelLayout.createParallelGroup()
							.addComponent(choosedPkm, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE)
							.addComponent(move1, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE)
							.addComponent(move2, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE)
							.addComponent(move3, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE)
							.addComponent(move4, GroupLayout.PREFERRED_SIZE, moveX, GroupLayout.PREFERRED_SIZE))
				
		);
		
		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
					.addGroup(panelLayout.createParallelGroup()
							.addComponent(spriteLabel)
							.addGroup(panelLayout.createSequentialGroup()
									.addComponent(choosedPkm, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(move1, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE)
									.addComponent(move2, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE)
									.addComponent(move3, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE)
									.addComponent(move4, GroupLayout.PREFERRED_SIZE, moveY, GroupLayout.PREFERRED_SIZE)))
		);
	}

	//create pokemon's sprite and resize to 270x270
	public JLabel creSprite(String spriteID) {
		ImageIcon originalImageIcon = new ImageIcon("pokemon_sprite\\"+spriteID+".png");
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(scaledImage);
        JLabel spriteLabel = new JLabel(resizedImageIcon);
        return spriteLabel;
	}
	
	//create pokemon's sprite
	public void changeImage(JLabel label, String spriteID) {
        ImageIcon originalImageIcon = new ImageIcon("pokemon_sprite\\" + spriteID + ".png");
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(scaledImage);
        label.setIcon(resizedImageIcon);
    }
	
	public void  createMoveCB(String pkmID) {
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader jsonString= new FileReader("pokemon_data\\"+pkmID+".json");
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
	        JSONArray availableMove = (JSONArray) jsonObject.get("availableMove");
	        this.move1.removeAllItems();
	        this.move2.removeAllItems();
	        this.move3.removeAllItems();
	        this.move4.removeAllItems();
	        for(Object move : availableMove) {
	    		this.move1.addItem((String) move);
	    		this.move2.addItem((String) move);
	    		this.move3.addItem((String) move);
	    		this.move4.addItem((String) move);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void setSelectedMove() {
		this.move1.setSelectedIndex(0);
		this.move2.setSelectedIndex(1);
		this.move3.setSelectedIndex(2);
		this.move4.setSelectedIndex(3);		
	}

	@Override
	public String toString() {
		return "{\"pkmID\": \""+this.choosedPkm.getSelectedItem()+"\","
				+ "\"nature\": \""+ "none" +"\","
				+ "\"moveID1\": \""+this.move1.getSelectedItem()+"\","
				+ "\"moveID2\": \""+this.move2.getSelectedItem()+"\","
				+ "\"moveID3\": \""+this.move3.getSelectedItem()+"\","
				+ "\"moveID4\": \""+this.move4.getSelectedItem()+"\""
				+ "}";
	}
	
	
	
}