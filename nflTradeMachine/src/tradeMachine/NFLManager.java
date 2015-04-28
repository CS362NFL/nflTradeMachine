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
	 * @param teamID The team ID to set the salary cap
	 * @param cap
	 *            - the amount of money the cap will be set to
	 * @return - true if the salary cap was successfully set, false otherwise.
	 */
	public boolean setCap(String teamID, Integer cap)  {
		Team team = database.getTeam(teamID);
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
	private ArrayList<String> getplayerIDs(ArrayList<Player> players) {
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

    public Team evaluateWinner(String playerID1, String playerID2) {
        return null;
    }

    public boolean evaluate(String playerID1, String playerID2) {
        return false;
    }

    public boolean extendPlayerContract(String playerID, int years, int salary) {
        Player player = getPlayer(playerID);
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

    public Integer getPlayerAverageCapHit(String playerID) {
        return database.getPlayer(playerID).getAverageCapHit();
    }

    public Integer getPlayerTotalMoney(String playerID) {
        return database.getPlayer(playerID).getTotalMoney();
    }

    public Integer getPlayerYears(String playerd) {
        return database.getPlayer(playerd).getYears();
    }

    public Team getPlayerTeam(String playerID) {
        return database.getPlayer(playerID).getTeam();
    }

    public String getPlayerPosition(String playerID) {
        return database.getPlayer(playerID).getPosition();
    }

    public String getPlayerName(String playerID) {
        return database.getPlayer(playerID).getName();
    }

    public Integer getNumberOfPlayers(String teamID) {
        return database.getTeam(teamID).getPlayers().size();
    }

    public Integer getFreeCapSapce(String teamID) {
        return database.getTeam(teamID).getFreeCapSpace();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public String getTeamName(String teamID) {
        return database.getTeam(teamID).getName();
    }

    public boolean addPlayer(String teamID, String playerID) {
        return false;
    }

    public Player getPlayer(String playerID) {
        return database.getPlayer(playerID);
    }
}
