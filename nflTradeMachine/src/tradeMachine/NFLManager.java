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
     * @param name The name of the team
	 * @param salaryCap The salary cap of the team
	 * @return Whether or not the operation succeeded
	 */
	public boolean createTeam(String name, Integer salaryCap) {
		Team team = new Team(name, salaryCap);
		if (teams.contains(team)) {
			return false;
		} else {
			teams.add(team);
			return true;
		}

	}


	public boolean createPlayer(String name, String position) {
		players.add(new Player(name, position));
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
		Team team = database.getTeam(teamId);
		if (cap < 0 || cap > team.getSalaryCap()) {
			return false;
		}

		team.setSalaryCap(cap);
		return true;

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
        this.database = new DatabaseSupport();
        return true;
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

    public boolean extendPlayerContract(String playerid, int years, int salary) {
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

    public Integer getPlayerAverageCapHit(String playerid) {
        return database.getPlayer(playerid).getAverageCapHit();
    }

    public Integer getPlayerTotalMoney(String playerid) {
        return database.getPlayer(playerid).getTotalMoney();
    }

    public Integer getPlayerYears(String playerd) {
        return database.getPlayer(playerd).getYears();
    }

    public Team getPlayerTeam(String playerid) {
        return database.getPlayer(playerid).getTeam();
    }

    public String getPlayerPosition(String playerid) {
        return database.getPlayer(playerid).getPosition();
    }

    public String getPlayerName(String playerid) {
        return database.getPlayer(playerid).getName();
    }

    public Integer getNumberOfPlayers(String teamid) {
        return database.getTeam(teamid).getPlayers().size();
    }

    public Integer getFreeCapSapce(String teamid) {
        return database.getTeam(teamid).getFreeCapSpace();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public String getTeamName(String teamid) {
        return database.getTeam(teamid).getName();
    }

    public boolean addPlayer(String teamid, String playerid) {
        return false;
    }

    public Player getPlayer(String playerid) {
        return database.getPlayer(playerid);
    }
}
