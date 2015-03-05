package tradeMachine;

import java.util.ArrayList;

/**
 * Team class representing a team in the NFL.
 * 
 * 
 */
public class Team {
	private ArrayList<Player> players = new ArrayList<Player>();
	private int salaryCap;
	private String name;
	private String id;
	private int freeCapSpace;

	/**
	 * Constructor to create a Team instance.
	 */
	public Team(ArrayList<Player> players, int salaryCap, String name, String id, int freeCapSpace) {
		this.players = players;
		this.salaryCap = salaryCap;
		this.name = name;
		this.id = id;
		this.freeCapSpace = freeCapSpace;
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
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of a team
	 * 
	 * @param id
	 *            - the id to set for the team
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Adds a player to the team.
	 * 
	 * @param player
	 *            - the player to add to the team
	 * @return true if the player was successfully added, false otherwise.
	 */
	public boolean addPlayer(Player player) {
		if (players.contains(player)) {
			return false;
		} else {

			players.add(player);
			return true;

		}

	}

	/**
	 * Gets the number of players on the team
	 * 
	 * @param teamID
	 *            - the id of the team as a string
	 * @return the number of players on the team, null if team does not exist.
	 */
	public int getNumberOfPlayers(String teamID) {
		if (teamID == id) {
			return players.size();
		}

		else
			return (Integer) null;
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
