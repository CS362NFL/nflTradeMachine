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

	/**
	 * Constructor to create NFL instance
	 * 
	 */
	public NFL(ArrayList<Team> teams, ArrayList<Player> players) {
		this.teams = teams;
		this.players = players;

	}
	
	/**
	 * Constructor to convert an NFLData class into an NFL
	 * @param nfl
	 */
	protected NFL(NFLData nfl) {
		for(NFLData.TeamData t: nfl.teams) {
			this.teams.add(new Team(t));
		}
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


}
