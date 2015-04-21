package tradeMachine;

import java.util.ArrayList;

public class NFLManager {
	public DatabaseSupport database;
	public ArrayList<Team> teams = new ArrayList<Team>();
	public ArrayList<Player> players = new ArrayList<Player>();
	
	public NFLManager() {
		this.database = new DatabaseSupport();
	}
	
	/**
	 * Creates a team
	 * @param salaryCap The salary cap of the team
	 * @param name The name of the team
	 * @param id The id of the team
	 * @return Whether or not the operation succeeded
	 */
	public boolean createTeam(Integer salaryCap, String name, String id) {
		Team team = new Team(new ArrayList<Player>(), salaryCap, name, id);
		if (teams.contains(team)) {
			return false;
		} else {
			teams.add(team);
			return true;
		}

	}


	public boolean createPlayer(String name, String position, String id, int years, int totalMoney) {
		ArrayList<String> playerIDs = getPlayerIDs(players);
		if(playerIDs.contains(id)) {
			return false;
		}
		Player player = new Player(id, position, name, years, totalMoney, years/totalMoney);
		players.add(player);
		return true;

	}

	/**
	 * Sets the salaryCap for an NFL team
	 * 
	 * @param teamId The team ID to set the salary cap
	 * @param cap
	 *            - the amount of money the cap will be set to
	 * @return - true if the salary cap was successfully set, false otherwise.
	 */
	public boolean setCap(String teamId, Integer cap)  {
		DatabaseSupport db = new DatabaseSupport();
		Team team = db.getTeam(teamId);
		if (cap < 0 || cap > team.getSalaryCap()) {
			return false;
		}

		team.setSalaryCap(cap);
		return true;

	}

	/**
	 * Returns the name of the team based on the given team.
	 * 
	 * @param team
	 *            - The team to get the name of.
	 * @return name of team as a string.
	 */
	public String getName(Team team) {
		return team.getName();
	}

	/**
	 * Private function for returning the IDs of all the players
	 * 
	 * @param players
	 *            - the list of players to get IDs from
	 * @return the IDs of all the players as an array list of strings.
	 */
	private ArrayList<String> getPlayerIDs(ArrayList<Player> players) {
		ArrayList<String> playerIDs = new ArrayList<String>();
		for (int i = 0; i < players.size(); i++) {
			playerIDs.add(players.get(i).getId());
		}

		return playerIDs;
	}
	
}
