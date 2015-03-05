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
	public DatabaseSupport() throws FileNotFoundException {
		String file = new Scanner(new File("nflTradeMachine/src/tradeMachine/nfl.json")).useDelimiter("\\Z").next();
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
	
	/**
	 * @param p Player to add to database
	 * @return true if add was successful, false otherwise
	 */
	public boolean putPlayers(Player p) {
		ArrayList<Player> toAdd = new ArrayList<Player>();
		toAdd.add(p);
		return nfl.addPlayers(toAdd);
	}
	
	/**
	 * @param t Team to add to database
	 * @return true if add was successful, false otherwise
	 */
	public boolean putTeam(Team t) {
		return nfl.addTeam(t);
	}
	
	/**
	 * @param t Team to set into the database
	 * @return true if successfully put
	 */
	public boolean putCap(Team t) {
		ArrayList<Team> currentTeams = getTeams();
		for(int i=0; i < currentTeams.size(); i++) {
			if(currentTeams.get(i).getName().equals(t.getName())) {
				currentTeams.set(i, t);
			}
		}
		
		nfl.setTeams(currentTeams);
		return true;
	}
	
	/**
	 * @param t Team to get name of
	 * @return String representing team name
	 */
	public String getTeamName(Team t) {
		return t.getName();
	}
	
}
