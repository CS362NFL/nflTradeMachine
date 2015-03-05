package tradeMachine;

import java.util.ArrayList;

public class NFLController {

	/*
	 * Stores an instance of NFL that is used to call the NFL methods
	 */
	private NFL nfl = null; 
	
	/**
	 * 
	 * Method to get a list of all teams in the NFL
	 * 
	 * @return A list of all teams in the NFL
	 */
	public ArrayList<Team> getTeams() {
		return this.getNFLInstance().getTeams();
	}

	
	/**
	 * 
	 * Method to set all the teams in the NFL
	 * 
	 * @param teams A list of Teams to add
	 */
	public void setTeams(ArrayList<Team> teams) {
		this.getNFLInstance().setTeams(teams);
	}
	
	/**
	 * 
	 * Method to get a list of all players marked as Free Agents
	 * 
	 * @return The list of Free Agents
	 */
	public ArrayList<Player> getFreeAgents(){
		return this.getNFLInstance().getFreeAgents();
	}
	
	/**
	 * 
	 * Method to set a given list of players as Free Agents
	 * 
	 * @param freeAgents The players to mark as Free Agents
	 */
	public void setFreeAgents(ArrayList<Player> freeAgents){
		this.getNFLInstance().setFreeAgents(freeAgents);
	}
	
	
	/**
	 * 
	 * Method to add a new team to the NFL 
	 * 
	 * @param id The team's new ID
	 * @param name The team's name
	 * @return Whether the operation succeeded or not
	 */
	public boolean addTeam(String id, String name){
		return this.getNFLInstance().addTeam(id, name);
		
	}
	
	/**
	 * 
	 * Method to add a player to the NFL
	 * 
	 * @param ids The players new ID
	 * @param names The players name
	 * @return Whether the operation succeeded or not
	 */
	public boolean addPlayers(ArrayList<String> ids, ArrayList<String> names){
		return this.getNFLInstance().addPlayers(ids, names);
		
	}
	
	/**
	 * 
	 * Method to set the salary cap hit of the player with the given id
	 * 
	 * @param id The players ID
	 * @param cap The cap hit of the Player
	 * @return Whether the operation succeeded or not
	 */
	public boolean setCap(String id, Integer cap){
		return this.getNFLInstance().setCap(id, cap);
		
	}
	
	/**
	 * 
	 * Method to get a list of all players in the NFL
	 * 
	 * @return a list of all players
	 */
	public ArrayList<Player> getPlayers(){
		return this.getNFLInstance().getPlayers();
	}
	
	/**
	 * 
	 * Method to define one instance of the class NFL to use in calling NFL methods
	 * 
	 * @return the instance of NFL being used
	 */
	private NFL getNFLInstance(){
		if(nfl == null) nfl = new NFL();
		return nfl;
	}
}
