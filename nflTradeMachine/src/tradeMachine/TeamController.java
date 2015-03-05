package tradeMachine;

import java.util.ArrayList;

public class TeamController {

	/*
	 * Stores an instance of Team that is used to call the Team methods
	 */
	private Team team = null;
	
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
	 * @param id The ID of the player to add
	 * @param name The name of the player to add
	 * @return Whether the operation was successful
	 */
	public boolean addPlayer(String id, String name){
		return this.getTeamInstance().addPlayer(id, name);
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
