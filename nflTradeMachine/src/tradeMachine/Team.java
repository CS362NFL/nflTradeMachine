package tradeMachine;

import java.util.ArrayList;

/**
 * Team class representing a team in the NFL.
 * 
 * 
 */
public class Team {
	private ArrayList<Player> players = new ArrayList<Player>();
	private Integer salaryCap;
	private String name;
	private String teamID;
	private Integer freeCapSpace;

	protected Team() {
	}

	/**
	 * Constructor to create a Team instance.
	 */
	public Team(String name, Integer salaryCap) {
		this.name = name;
		this.salaryCap = salaryCap;

	}

	/**
	 * Constructor to convert TeamData class into a Team
	 * 
	 * @param team
	 */
	protected Team(NFLData.TeamData team) {
		for (NFLData.TeamData.PlayerData p : team.players) {
			this.players.add(new Player(p));
		}
		this.name = team.name;
		this.teamID = team.name;
	}

	/**
	 * @return the free cap space a team has as an integer.
	 */
	public int getFreeCapSpace() {
		return freeCapSpace;
	}

	/**
	 * Sets the free cap space for a team
	 * 
	 * @param freeCapSpace
	 *            - the free cap space to set for the team
	 */
	public void setFreeCapSpace(int freeCapSpace) {
		this.freeCapSpace = freeCapSpace;
	}

	/**
	 * Gets all the players from a team
	 * 
	 * @return a list of players associated with the team
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Sets the players for a team
	 * 
	 * @param players
	 *            - players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @return the salary cap for the team as an integer.
	 */
	public int getSalaryCap() {
		return salaryCap;
	}

	/**
	 * Sets the salary cap for the team
	 * 
	 * @param salaryCap
	 *            - the salary cap for the team
	 */
	public void setSalaryCap(int salaryCap) {
		this.salaryCap = salaryCap;
	}

	/**
	 * @return the name of the team
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Team
	 * 
	 * @param name
	 *            - name of the team.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id of the team as a string.
	 */
	public String getTeamID() {
		return teamID;
	}

	/**
	 * Sets the id of a team
	 * 
	 * @param id
	 *            - the id to set for the team
	 */
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	/**
	 * Adds a player to the team.
	 * 
	 * @param player
	 *            - the player to add to the team
	 * @return true if the player was successfully added, false otherwise.
	 */
	public Team addPlayer(Player player) {
		if (players.contains(player)) {
			return null;
		} else {

			players.add(player);
			return this;

		}

	}
	
	/**
	 * Removes the player from the team
	 * @param player - the player to remove
	 * @return updated list of players
	 */
	public boolean removePlayer(Player player) {
		return players.remove(player);
	}

	/**
	 * Gets the number of players on the team - the id of the team as a string
	 * 
	 * @return the number of players on the team, null if team does not exist.
	 */
	public int getNumberOfPlayers(String teamID) {
		return players.size();
	}

	public Player getPlayer(String playerID) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getId() == playerID) {
				return players.get(i);
			}
		}

		return (Player) null;
	}

}
