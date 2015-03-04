package tradeMachine;

import java.util.ArrayList;

public class NFL {
	
	ArrayList<Team> teams = new ArrayList<Team>();
	ArrayList<Player> freeAgents = new ArrayList<Player>();
	
	public NFL(){
		this.teams = teams;
		this.freeAgents = freeAgents;
		
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	public ArrayList<Player> getFreeAgents(){
		return freeAgents;
	}
	
	public void setFreeAgents(ArrayList<Player> freeAgents){
		this.freeAgents = freeAgents;
	}
	
	
	public boolean addTeam(String id, String name){
		return false;
		
	}
	
	public boolean addPlayers(ArrayList<String> ids, ArrayList<String> names){
		return false;
		
	}
	
	public boolean setCap(String id, Integer cap){
		return false;
		
	}
	
	public ArrayList<Player> getPlayers(){
		ArrayList<Player> playersToReturn = new ArrayList<Player>();
		
		for(int i = 0; i < teams.size(); i++){
			playersToReturn.addAll(teams.get(i).getPlayers());
		}
		
		return playersToReturn;
	}

}
