package tradeMachine;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NFLManagerController {

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
	 * Method to create a team in the NFL
	 * @param salaryCap The salary cap of the team
	 * @param name The name of the team
	 * @param id The id of the team
	 * @return
	 */
	public boolean createTeam(Integer salaryCap, String name, String id){
		return this.getNFLInstance().createTeam(salaryCap, name, id);
		
	}

	/**
	 * Method to add a player to the NFL
	 * @param name The players name
	 * @param position The players position
	 * @param id The players ID
	 * @return Whether the operation was successful
	 */
	public boolean createPlayer(String name, String position, String id){
		return this.getNFLInstance().createPlayer(name, position, id);
		
	}
	
	/**
	 * 
	 * Method to set the salary cap hit of the player with the given id
	 * 
	 * @param teamId The ID of the Team to set the cap of
	 * @param cap The cap hit of the Player
	 * @return Whether the operation succeeded or not
	 */
	public boolean setCap(String teamId, Integer cap) {
		return this.getNFLInstance().setCap(teamId, cap);
		
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
	 * Method to set the Players of this instance of Team
	 * 
	 * @param players The Players to set to this Team
	 */
	public void setPlayers(ArrayList<Player> players){
		this.getNFLInstance().setPlayers(players);
	}
	
	/**
	 * 
	 * Method to get the name of the given Team
	 * 
	 * @param team The Team to get the name of
	 * @return The name of the given Team
	 */
	public String getName(Team team){
		return this.getNFLInstance().getName(team);
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
