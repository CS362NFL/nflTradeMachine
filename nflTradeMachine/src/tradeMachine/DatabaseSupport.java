package tradeMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import tradeMachine.NFLData.TeamData;
import tradeMachine.NFLData.TeamData.PlayerData;

import com.google.gson.Gson;

public class DatabaseSupport {
	private Gson gson = new Gson();
	public ArrayList<Team> teams = new ArrayList<Team>();
	public ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * Turns nfl.json file into an NFL class with Teams and Players
	 * @throws FileNotFoundException
	 */
	public DatabaseSupport() {
		String file = "";
		try {
			file = new Scanner(new File("nflTradeMachine/src/tradeMachine/nfl.json")).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		NFLData nfldata = gson.fromJson(file, NFLData.class);
		for(TeamData t: nfldata.teams) {
			Team newTeam = new Team(t.name, 143280000);
			for(PlayerData p: t.players) {
				Player newPlayer = new Player(p.name, p.position);
				newPlayer.setYears(Integer.parseInt(p.contract_length));
				newPlayer.setTotalMoney(Integer.parseInt(p.contract_value));
				newPlayer.setTeam(newTeam);
				newPlayer.setAverageCapHit(Integer.parseInt(p.average_salary));
				newTeam.addPlayer(newPlayer);
				players.add(newPlayer);
			}
			teams.add(newTeam);
		}
	}
	
	/**
	 * @return array list of Teams
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	/**
	 * @return array list of Players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * 
	 * @param id id of team to get
	 * @return Team
	 */
	public Team getTeam(String id) {
		for(Team t: teams) {
			if(t.getTeamID().equals(id))
				return t;
		}

		return null;
	}
	
	/**
	 * @param id id of player to get
	 * @return Player
	 */
	public Player getPlayer(String id) {
		for(Player p: players) {
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
		players.add(p);
		return true;
	}
	
	/**
	 * @param t Team to add to database
	 * @return true if add was successful, false otherwise
	 */
	public boolean putTeam(Team t) {
		teams.add(t);
		return true;
	}
}
