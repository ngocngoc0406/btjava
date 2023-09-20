package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.json.simple.JSONObject;

import model.Move;
import model.Pokemon;
import view.CombatView;
import view.MovePanel;

public class AttackPressHandler implements MouseListener {
	private CombatView cbView;
	private MovePanel move;

	public AttackPressHandler(CombatView cbView, MovePanel move) {
		super();
		this.cbView = cbView;
		this.move = move;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(move.getMove().getName());
		JSONObject obj = new JSONObject();
		Move m = move.getMove();
		Pokemon p = cbView.getActivePokemon();
		obj.put("type", m.getType());
		obj.put("dmg", m.getDmg());
		obj.put("target", m.getTarget());
		obj.put("category", m.getCategory());
		obj.put("name", m.getName());
		obj.put("pkmName", p.getName());
		obj.put("pkmTypes1", p.getType(0));
		obj.put("pkmTypes2", p.getType(1));
		obj.put("HP", p.getHP());
		obj.put("ATK", p.getATK());
		obj.put("SPATK", p.getSPATK());
		obj.put("DEF", p.getDEF());
		obj.put("SPDEF", p.getSPDEF());
		obj.put("SPD", p.getSPD());
		System.out.println(obj.toString());
		cbView.sendAttackCommand(obj.toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
