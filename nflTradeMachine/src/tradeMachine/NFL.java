package tradeMachine;

import java.util.ArrayList;

/**
 * 
 * NFL class that acts as the admin. Has control over all teams.
 * 
 */
public class NFL {

	private ArrayList<Team> teams = new ArrayList<Team>();
	private ArrayList<Player> players = new ArrayList<Player>();

	protected NFL(){
		
	}
	
	/**
	 * Constructor to create NFL instance
	 * 
	 */
	public NFL(ArrayList<Team> teams, ArrayList<Player> players) {
		this.teams = teams;
		this.players = players;

	}

	/**
	 * @return the teams as an array list.
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams
	 *            - teams to set.
	 */
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	/**
	 * @return the players in the NFL as an array list.
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players
	 *            - players to set.
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * Adds a team to the NFLs list of teams.
	 * 
	 * @param team
	 *            - the team to add to the list
	 * @return true if the team was successfully added, false otherwise.
	 */
	public boolean addTeam(Team team) {
		if (teams.contains(team)) {
			return false;
		} else {
			teams.add(team);
			return true;
		}

	}

	/**
	 * Adds a list of players to the NFL players list.
	 * 
	 * @param playersToAdd
	 *            - The list of players to add.
	 * @return true if the list of players was successfully added, false
	 *         otherwise.
	 */
	public boolean addPlayers(ArrayList<Player> playersToAdd) {

		ArrayList<String> playerIDs = getPlayerIDs(players);

		for (int i = 0; i < playersToAdd.size(); i++) {
			if (playerIDs.contains(players.get(i).getId())) {
				return false;
			}
		}

		players.addAll(playersToAdd);
		return true;

	}

	/**
	 * Sets the salaryCap for an NFL team
	 * 
	 * @param team
	 *            - The team to set the salary cap
	 * @param cap
	 *            - the amount of money the cap will be set to
	 * @return - true if the salary cap was successfully set, false otherwise.
	 */
	public boolean setCap(Team team, Integer cap) {
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
