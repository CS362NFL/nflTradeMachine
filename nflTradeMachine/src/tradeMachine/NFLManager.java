package tradeMachine;

import java.util.ArrayList;
import java.util.List;

public class NFLManager {
	public DatabaseSupport database;
	public ArrayList<Team> teams = new ArrayList<Team>();
	public ArrayList<Player> players = new ArrayList<Player>();
	
	public NFLManager() {
		this.database = new DatabaseSupport();
	}
	
	/**
	 * Creates a team
	 * @param salaryCap The salary cap of the team
	 * @param name The name of the team
	 * @return Whether or not the operation succeeded
	 */
	public boolean createTeam(String name, Integer salaryCap) {
        //todo - create a real ID

		Team team = new Team(name, salaryCap);
		if (teams.contains(team)) {
			return false;
		} else {
			teams.add(team);
			return true;
		}

	}


	public boolean createPlayer(String name, String position) {
		ArrayList<String> playerIDs = getPlayerIDs(players);
		Player player = new Player(name, position);
		players.add(player);
		return true;

	}

	/**
	 * Sets the salaryCap for an NFL team
	 * 
	 * @param teamId The team ID to set the salary cap
	 * @param cap
	 *            - the amount of money the cap will be set to
	 * @return - true if the salary cap was successfully set, false otherwise.
	 */
	public boolean setCap(String teamId, Integer cap)  {
		DatabaseSupport db = new DatabaseSupport();
		Team team = db.getTeam(teamId);
		if (cap < 0 || cap > team.getSalaryCap()) {
			return false;
		}

		team.setSalaryCap(cap);
		return true;

	}

	/**
	 * Returns the name of the team based on the given team.
	 * 
	 * @param team
	 *            - The team to get the name of.
	 * @return name of team as a string.
	 */
	public String getName(Team team) {
		return team.getName();
	}

	/**
	 * Private function for returning the IDs of all the players
	 * 
	 * @param players
	 *            - the list of players to get IDs from
	 * @return the IDs of all the players as an array list of strings.
	 */
	private ArrayList<String> getPlayerIDs(ArrayList<Player> players) {
		ArrayList<String> playerIDs = new ArrayList<String>();
		for (int i = 0; i < players.size(); i++) {
			playerIDs.add(players.get(i).getId());
		}

		return playerIDs;
	}

    public boolean reset() {
        return false;
    }

    public List<Player> searchPlayersByAverageCapHit(Integer low, Integer high) {
        return null;
    }

    public List<Player> searchPlayersByName(String name) {
        return null;
    }

    public List<Player> searchPlayersByPosition(String position) {
        return null;
    }

    public List<Team> searchTeamsByCapSpace(Integer capSpace) {
        return null;
    }

    public boolean removePlayer(String playerID) {
        return false;
    }

    public boolean removeTeam(String teamID) {
        return false;
    }

    public Team evaluateWinner(String playerid1, String playerid2) {
        return null;
    }

    public boolean evaluate(String playerid1, String playerid2) {
        return false;
    }

    public boolean extendPlayerContract(String playerid, int years) {
        return false;
    }

    public Integer getPlayerAverageCapHit(String playerid) {
        return null;
    }

    public Integer getPlayerTotalMoney(String playerid) {
        return null;
    }

    public Integer getPlayerYears(String playerd) {
        return null;
    }

    public Team getPlayerTeam(String playerid) {
        return null;
    }

    public String getPlayerPosition(String playerid) {
        return null;
    }

    public String getPlayerName(String playerid) {
        return null;
    }

    public Integer getNumberOfPlayers(String teamid) {
        return null;
    }

    public Integer getFreeCapSapce(String teamid) {
        return null;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public String getTeamName(String teamid) {
        return null;
    }

    public boolean addPlayer(String teamid, String playerid) {
        return false;
    }

    public Player getPlayer(String playerid) {
        return null;
    }
}
