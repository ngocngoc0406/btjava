package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Pokemon;

public class FightsPanel extends JPanel{
	private SpritePanel mySprite, foeSprite;
	private GroupLayout panelLayout;
	public FightsPanel(Pokemon myPkm, Pokemon foePkm) {
		this.mySprite =  new SpritePanel(myPkm);
		this.foeSprite = new SpritePanel(foePkm);
    	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		init();
	}
	public void init() {
		panelLayout = new GroupLayout(this);
		this.setLayout(panelLayout);

//		panelLayout.setAutoCreateGaps(true);
		panelLayout.setAutoCreateContainerGaps(true);

		panelLayout.setHorizontalGroup(
				panelLayout.createSequentialGroup()
						.addComponent(mySprite)
						.addGap(180)
						.addComponent(foeSprite)
		);
		panelLayout.setVerticalGroup(
				panelLayout.createSequentialGroup()
						.addGroup(panelLayout.createParallelGroup()
								.addGroup(panelLayout.createSequentialGroup()
										.addGap(125)
										.addComponent(mySprite))
								.addComponent(foeSprite))
		);
	}
	public void setMyHP(long HP) {
		this.mySprite.setSrpiteHP((int)HP);
	}
	public void setFoeHP(long HP) {
		this.foeSprite.setSrpiteHP((int)HP);
	}
	public void setMyMaxHP(long maxHP) {
		this.mySprite.setSrpiteMaxHP((int)maxHP);
	}
	public void setFoeMaxHP(long maxHP) {
		this.foeSprite.setSrpiteMaxHP((int)maxHP);
	}
}
