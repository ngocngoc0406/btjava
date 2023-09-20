package model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Move {
	private String id;
	private String type;
	private String target;
	private String category;
	private String name;
	private long dmg;
	private long hitChance;
	private long critChance;
	private ArrayList<Long> subEffect;
//	subEffect id
//	 0 - confuse	
//	 1 - paralysis 
//	 2 - poison
//	 3 - B_poison
//	 4 - sleep
//	 5 - burn
//	 6 - freeze
//	 7 - flinch
//	 8 - raise ATK
//	 9 - raise DEF
//	10 - raise SPATK
//	11 - raise SPDEF
//	12 - raise SPD
//	13 - lower ATK
//	14 - lower DEF
//	15 - lower SPATK
//	16 - lower SPDEF
//	17 - lower SPD
	
	public Move(String moveID) {
		super();
		this.id = moveID;
		this.subEffect = new ArrayList<Long>();
		parseData(moveID);
	}
	
	public void parseData(String moveID) {
		JSONParser jsonParser = new JSONParser();
	    try {
	    	FileReader reader = new FileReader("move_data\\"+moveID+".json");
	        Object obj = jsonParser.parse(reader);
	        JSONObject jsonObject = (JSONObject) obj;
	        this.setName((String)jsonObject.get("name"));
	        this.setType((String)jsonObject.get("type"));
	        this.setDmg((long)jsonObject.get("dmg"));
	        this.setTarget((String)jsonObject.get("target"));
	        this.setCategory((String)jsonObject.get("category"));
	        this.setHitChance((long)jsonObject.get("hitChance"));
	        this.setCritChance((long)jsonObject.get("critChance"));
	        for(Object effect : (JSONArray)jsonObject.get("subEffect")) {
	        	this.addSubEffect((long)effect);
	        }
	    } catch (IOException | ParseException e) {
	    	e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		Move move = new Move("fierydance");
		System.out.println(move.getType());
		System.out.println(move.getName());
		System.out.println(move.getTarget());
		System.out.println(move.getCritChance());
		System.out.println(move.getDmg());
		System.out.println(move.getHitChance());
		System.out.println(move.getSubEffect());
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDmg() {
		return dmg;
	}

	public void setDmg(long dmg) {
		this.dmg = dmg;
	}

	public long getHitChance() {
		return hitChance;
	}

	public void setHitChance(long hitChance) {
		this.hitChance = hitChance;
	}

	public long getCritChance() {
		return critChance;
	}

	public void setCritChance(long critChance) {
		this.critChance = critChance;
	}

	public long getSubEffect(int index) {
		return subEffect.get(index -1);
	}
	public ArrayList<Long> getSubEffect() {
		return subEffect;
	}

	public void addSubEffect(long subEffect) {
		this.subEffect.add(subEffect);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
