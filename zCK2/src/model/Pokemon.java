package model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Pokemon {
	private String id;
	private String name;
	private ArrayList<String> type;
	private long HP;
	private long ATK;
	private long DEF;
	private long SPATK;
	private long SPDEF;
	private long SPD;
	private long status;
	private boolean faint;
	private Move move1, move2, move3, move4;
	public Pokemon(String id, Move move1, Move move2, Move move3, Move move4) {
		super();
		this.type = new ArrayList<>();
		this.id = id;
		this.status = 0;
		this.move1 = move1;
		this.move2 = move2;
		this.move3 = move3;
		this.move4 = move4;
		this.faint = false;
		parseData(id);
	}
	public void parseData(String pkmID) {
		JSONParser jsonParser = new JSONParser();
	    try {
	    	FileReader reader = new FileReader("pokemon_data\\"+pkmID+".json");
	        Object obj = jsonParser.parse(reader);
	        JSONObject jsonObject = (JSONObject) obj;
	        this.setName((String)jsonObject.get("name"));
	        for(Object type : (JSONArray) jsonObject.get("type")) {
	        	this.addType((String) type);
	        }
	        long baseHP = (long) jsonObject.get("baseHP");
	        long baseATK = (long) jsonObject.get("baseATK");
	        long baseDEF = (long) jsonObject.get("baseDEF");
	        long baseSPATK = (long) jsonObject.get("baseSPATK");
	        long baseSPDEF = (long) jsonObject.get("baseSPDEF");
	        long baseSPD = (long) jsonObject.get("baseSPD");
	        long iv = 31;
	        long lv = 50;
	        this.setHP(10+lv+((2*baseHP+iv)*lv/100));
	        this.setATK(5+((2*baseATK+iv)*lv/100));
	        this.setDEF(5+((2*baseDEF+iv)*lv/100));
	        this.setSPATK(5+((2*baseSPATK+iv)*lv/100));
	        this.setSPDEF(5+((2*baseSPDEF+iv)*lv/100));
	        this.setSPD(5+((2*baseSPD+iv)*lv/100));
	    } catch (IOException | ParseException e) {
	    	e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		Pokemon pkm = new Pokemon("637", new Move("fierydance"), null, null, null);
		System.out.println(pkm.getHP());;
		System.out.println(pkm.getATK());
		System.out.println(pkm.getDEF());
		System.out.println(pkm.getSPATK());
		System.out.println(pkm.getSPDEF());
		System.out.println(pkm.getSPD());
		System.out.println(pkm.getMove1().getName());
		System.out.println(pkm.getType(2));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getHP() {
		return HP;
	}
	public void setHP(long hP) {
		HP = hP;
	}
	public long getATK() {
		return ATK;
	}
	public void setATK(long aTK) {
		ATK = aTK;
	}
	public long getDEF() {
		return DEF;
	}
	public void setDEF(long DEF) {
		this.DEF = DEF;
	}
	public long getSPATK() {
		return SPATK;
	}
	public void setSPATK(long sPATK) {
		SPATK = sPATK;
	}
	public long getSPDEF() {
		return SPDEF;
	}
	public void setSPDEF(long sPDEF) {
		SPDEF = sPDEF;
	}
	public long getSPD() {
		return SPD;
	}
	public void setSPD(long sPD) {
		SPD = sPD;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	
	public boolean isFaint() {
		return faint;
	}
	public void setFaint(boolean faint) {
		this.faint = faint;
	}
	public Move getMove1() {
		return move1;
	}
	public void setMove1(Move move1) {
		this.move1 = move1;
	}
	public Move getMove2() {
		return move2;
	}
	public void setMove2(Move move2) {
		this.move2 = move2;
	}
	public Move getMove3() {
		return move3;
	}
	public void setMove3(Move move3) {
		this.move3 = move3;
	}
	public Move getMove4() {
		return move4;
	}
	public void setMove4(Move move4) {
		this.move4 = move4;
	}
	public String getType(int index) {
		try {
			return this.type.get(index);			
		} catch (IndexOutOfBoundsException e) {
			return "none";
		}
	}
	public ArrayList<String> getType() {
		return type;
	}
	public void addType(String type) {
		this.type.add(type);
	}
	public String getId() {
		return id;
	}
	
	
}
