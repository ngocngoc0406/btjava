package model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PlayerTeam {
	ArrayList<Pokemon> playerTeam;
	public PlayerTeam(String teamID) {
		super();
		playerTeam = new ArrayList<>();
		JSONParser jsonParser = new JSONParser();
	    try {
	    	FileReader reader = new FileReader("team_data\\"+teamID+".json");
	        JSONArray obj = (JSONArray) jsonParser.parse(reader);
            for (Object eachPkm : obj) {
                JSONObject pokemon = (JSONObject) eachPkm;                
                Move move1 = new Move(((String) pokemon.get("moveID1")).toLowerCase().replaceAll("\\s+", ""));
    			Move move2 = new Move(((String) pokemon.get("moveID2")).toLowerCase().replaceAll("\\s+", ""));
    			Move move3 = new Move(((String) pokemon.get("moveID3")).toLowerCase().replaceAll("\\s+", ""));
    			Move move4 = new Move(((String) pokemon.get("moveID4")).toLowerCase().replaceAll("\\s+", ""));
    			
    			playerTeam.add(new Pokemon(((String) pokemon.get("pkmID")).substring(0,3), move1, move2, move3, move4));
            }
	    } catch (IOException | ParseException e) {
	    	e.printStackTrace();
	    }
	}
	public Pokemon getPlayerTeam(int index) {
		return playerTeam.get(index);
	}

	public static void main(String[] args) {
		PlayerTeam playerTeam =  new PlayerTeam("team1");
		System.out.println(playerTeam.getPlayerTeam(0).getName() +" "+ playerTeam.getPlayerTeam(0).getMove1().getName());
		System.out.println(playerTeam.getPlayerTeam(0).getName() +" "+ playerTeam.getPlayerTeam(0).getMove2().getName());
		System.out.println(playerTeam.getPlayerTeam(0).getName() +" "+ playerTeam.getPlayerTeam(0).getMove3().getName());
		System.out.println(playerTeam.getPlayerTeam(0).getName() +" "+ playerTeam.getPlayerTeam(0).getMove4().getName());	}
}
