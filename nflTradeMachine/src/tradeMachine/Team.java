package tradeMachine;

import java.util.ArrayList;

public class Team {
	private ArrayList<Player> players = new ArrayList<Player>();
	private int salaryCap;
	private String name;
	private String id;
	
	public Team(){
		this.players = players;
		this.salaryCap = salaryCap;
		this.name = name;
		this.id = id;		
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public int getSalaryCap() {
		return salaryCap;
	}

	public void setSalaryCap(int salaryCap) {
		this.salaryCap = salaryCap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public boolean addPlayer(String id, String name){
		return false;

	}

}
