package tradeMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class DatabaseSupport {
	private Gson gson = new Gson();
	public NFL nfl;
	
	public DatabaseSupport() throws FileNotFoundException {
		String file = new Scanner(new File("nflTradeMachine/src/tradeMachine/nfl.json")).useDelimiter("\\Z").next();
		NFLData nfldata = gson.fromJson(file, NFLData.class);
		nfl = new NFL(nfldata);
	}
	
	public ArrayList<Team> getTeams() {
		return nfl.getTeams();
	}
	
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		for(Team t: getTeams()) {
			allPlayers.addAll(t.getPlayers());
		}
		
		return allPlayers;
	}
	
	public boolean putPlayers(Player p) {
		ArrayList<Player> toAdd = new ArrayList<Player>();
		toAdd.add(p);
		return nfl.addPlayers(toAdd);
	}
	
	public boolean putTeam(Team t) {
		return nfl.addTeam(t);
	}
	
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
	
	public String getTeamName(Team t) {
		return t.getName();
	}
	
}
