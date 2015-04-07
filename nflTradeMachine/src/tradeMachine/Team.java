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
	private String id;
	private Integer freeCapSpace;

	protected Team() {
	}

	/**
	 * Constructor to create a Team instance.
	 */
	public Team(ArrayList<Player> players, Integer salaryCap, String name,
			String id) {
		this.players = players;
		this.salaryCap = salaryCap;
		this.name = name;
		this.id = id;
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
		this.id = team.name;
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
	
	/**
	 * Get the player name from the given player.
	 * 
	 * @param playerid - Id of the player
	 * @return The player name (String)
	 */
	public String getPlayerName(String playerid){
		return getPlayer(playerid).getName();
	}
	
	/**
	 * Get the player position from the given player.
	 * 
	 * @param playerid
	 * @return The player position (String)
	 */
	public String getPlayerPosition(String playerid){
		return getPlayer(playerid).getPosition();
	}
	
	/**
	 * Get the total money from the given player.
	 * 
	 * @param playerid - Id of the player
	 * @return
	 */
	public Integer getPlayerTotalMoney(String playerid){
		return getPlayer(playerid).getTotalMoney();
	}
	
	/**
	 * Get the average cap hit of the given player
	 * 
	 * @param playerid - Id of the given player
	 * @return The average cap hit of the player (Integer)
	 */
	public Integer getPlayerAverageCapHit(String playerid){
		return getPlayer(playerid).getAverageCapHit();
	}
	
	/**
	 * Extends the players contract by extending the years, and salary of the given player
	 * 
	 * @param playerid - Id of the player to extend
	 * @param years - The amount of years to extend the player
	 * @param salary - The amount of money to give to the extended player
	 * @return True of the operation was a success, false otherwise
	 */
	public boolean extendPlayerContract(String playerid, int years, int salary){
		Player player = getPlayer(playerid);
		Integer playerSalary = player.getTotalMoney();
		Integer playerYears = player.getYears();
		if(salary < 0 || years < 0)return false;
		Integer newTotalMoney = playerSalary + salary;
		Integer newYears = playerYears + years;
		player.setTotalMoney(newTotalMoney);
		player.setYears(newYears);
		player.setAverageCapHit(newTotalMoney/newYears);
		return true;
		
	}

}
