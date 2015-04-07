package tradeMachine;

import java.util.ArrayList;

public class TeamController {

	/*
	 * Stores an instance of Team that is used to call the Team methods
	 */
	private Team team = null;
	
	/**
	 * 
	 * Method to get the Free Cap space of this Team
	 * 
	 * @return The Free Cap space of this Team
	 */
	public int getFreeCapSpace() {
		return this.getTeamInstance().getFreeCapSpace();
	}
	
	/**
	 * 
	 * Method to sset the Free Cap space of this Team
	 * 
	 * @param freeCapSpace The new Free Cap space of this Team
	 */
	public void setFreeCapSpace(int freeCapSpace) {
		this.getTeamInstance().setFreeCapSpace(freeCapSpace);
	}
	
	/**
	 * 
	 * Method to get a list of all players on this Team
	 * 
	 * @return A list of players on this Team
	 */
	public ArrayList<Player> getPlayers() {
		return this.getTeamInstance().getPlayers();
	}

	/**
	 * 
	 * Method to set the players of this instance of Team
	 * 
	 * @param players A list of players to set to this Team
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.getTeamInstance().setPlayers(players);
	}
	
	/**
	 * 
	 * Method to get the salary cap of this instance of Team
	 * 
	 * @return The salary cap of this instance of Team
	 */
	public int getSalaryCap() {
		return this.getTeamInstance().getSalaryCap();
	}
	
	/**
	 * 
	 * Method to set the salary cap of this instance of Team
	 * 
	 * @param salaryCap The new salary cap
	 */
	public void setSalaryCap(int salaryCap) {
		this.getTeamInstance().setSalaryCap(salaryCap);
	}
	
	/**
	 * 
	 * Method to get the name of this instance of Team
	 * 
	 * @return The name of the Team
	 */
	public String getName() {
		return this.getTeamInstance().getName();
	}
	
	/**
	 * Method to set the name of this instance of Team
	 * 
	 * @param name The new name of the Team
	 */
	public void setName(String name) {
		this.getTeamInstance().setName(name);
	}
	
	/**
	 * 
	 * Method to get the ID of this instance of Team
	 * 
	 * @return The ID of the Team
	 */
	public String getId() {
		return this.getTeamInstance().getId();
	}
	
	/**
	 * 
	 * Method to set the ID of this instance of Team
	 * 
	 * @param id The new ID of the Team
	 */
	public void setId(String id) {
		this.getTeamInstance().setId(id);
	}
		
	/**
	 * 
	 * Method to add a player to this Team
	 * 
	 * @param player The Player to add
	 * @return Whether the operation was successful
	 */
	public boolean addPlayer(Player player){
		return this.getTeamInstance().addPlayer(player);
	}


	/**
	 * Method to get the name of a player
	 * @param playerID The ID of the player to get the name of
	 * @return The name of the player
	 */
	private String getPlayerName(String playerID) {
		return this.getTeamInstance().getPlayerName(playerID);
	}

	/**
	 * Method to get the players position
	 * @param playerID The ID of the player to ge the position for
	 * @return The position of the player
	 */
	private String getPlayerPosition(String playerID) {
		return this.getTeamInstance().getPlayerPosition(playerID);
	}

	/**
	 * Method to get the years left on a players contract
	 * @param playerID The ID of the player to get the years for
	 * @return The number of years left on the players contract
	 */
	private Integer getPlayerYears(String playerID) {
		return this.getTeamInstance().getPlayerYears(playerID);
	}

	/**
	 * Method to get the total money of a players contract
	 * @param playerID The ID of the player to get the total money for
	 * @return The total money for the player
	 */
	private Integer getPlayerTotalMoney(String playerID) {
		return this.getTeamInstance().getPlayerTotalMoney(playerID);
	}

	/**
	 * Method to get the average cap hit of a player
	 * @param playerID The ID of the player to get the average cap hit for
	 * @return The average cap hit
	 */
	private Integer getPlayerAverageCapHit(String playerID) {
		return this.getTeamInstance().getPlayerAverageCapHit(playerID);
	}

	/**
	 * Method to extend the contract of a player
	 * @param playerID The id of the player to extend
	 * @param years The years to add to the players contract
	 * @param salary The money to add to the players contract
	 * @return Whether or not the operation was successful
	 */
	private Boolean extendPlayerContract(String playerID, Integer years, Integer salary) {
		return this.getTeamInstance().extendPlayerContract(playerID, years, salary);
	}

	/**
	 * 
	 * Method to define one instance of the class Team to use in calling Team methods
	 * 
	 * @return the instance of Team being used
	 */
	private Team getTeamInstance(){
		if(team == null) team = new Team();
		return team;
	}

}
