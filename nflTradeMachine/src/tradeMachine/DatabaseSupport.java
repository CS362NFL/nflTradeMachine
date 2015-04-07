package tradeMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class DatabaseSupport {
	private Gson gson = new Gson();
	public NFL nfl;
	
	/**
	 * Turns nfl.json file into an NFL class with Teams and Players
	 * @throws FileNotFoundException
	 */
	public DatabaseSupport() {
		String file = "";
		try {
			file = new Scanner(new File("nflTradeMachine/src/tradeMachine/nfl.json")).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NFLData nfldata = gson.fromJson(file, NFLData.class);
		nfl = new NFL(nfldata);
	}
	
	/**
	 * @return array list of Teams
	 */
	public ArrayList<Team> getTeams() {
		return nfl.getTeams();
	}
	
	/**
	 * @return array list of Players
	 */
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		for(Team t: getTeams()) {
			allPlayers.addAll(t.getPlayers());
		}
		
		return allPlayers;
	}
	
	public Team getTeam(String id) {
		for(Team t: nfl.getTeams()) {
			if(t.getId().equals(id))
				return t;
		}
		
		return null;
	}
	
	public Player getPlayer(String id) {
		for(Player p: nfl.getPlayers()) {
			if(p.getId().equals(id))
				return p;
		}
		
		return null;
	}
	
	/**
	 * @param p Player to add to database
	 * @return true if add was successful, false otherwise
	 */
	public boolean putPlayer(Player p) {
		ArrayList<Player> toAdd = new ArrayList<Player>();
		toAdd.add(p);
		return nfl.createPlayer(p.getName(), p.getPosition(), p.getId());
	}
	
	/**
	 * @param t Team to add to database
	 * @return true if add was successful, false otherwise
	 */
	public boolean putTeam(Team t) {
		return nfl.createTeam(t.getSalaryCap(), t.getName(), t.getId());
	}
	
}
