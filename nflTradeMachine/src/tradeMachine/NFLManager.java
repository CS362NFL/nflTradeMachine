package tradeMachine;

import java.util.ArrayList;
import java.util.List;

public class NFLManager {

    public DatabaseSupport database;
    private final Integer MAXIMUM_CAP = new Integer(143280000);

    public NFLManager() {
        this.database = new DatabaseSupport();
    }

    /**
     * Creates a team
     *
     * @param name      The name of the team
     * @param salaryCap The salary cap of the team
     * @return Whether or not the operation succeeded
     */
    public boolean createTeam(String name, Integer salaryCap) {
        Team team = new Team(name, salaryCap);
        if (getTeams().contains(team)) {
            return false;
        } else {
            getTeams().add(team);
            return true;
        }

    }


    public boolean createPlayer(String name, String position) {
        Player player = new Player(name, position);
        if (getPlayers().contains(player)) {
            return false;
        } else {
            getPlayers().add(player);
            return true;
        }
    }

    /**
     * Sets the salaryCap for an NFL team
     *
     * @param teamID The team ID to set the salary cap
     * @param cap    - the amount of money the cap will be set to
     * @return - true if the salary cap was successfully set, false otherwise.
     */
    public boolean setCap(String teamID, Integer cap) {
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
     * @param players - the list of players to get IDs from
     * @return the IDs of all the players as an array list of strings.
     */
    private ArrayList<String> getPlayerIDs(ArrayList<Player> players) {
        ArrayList<String> playerIDs = new ArrayList<String>();
        for (int i = 0; i < players.size(); i++) {
            playerIDs.add(players.get(i).getId());
        }
        return playerIDs;
    }

	
	/**
	 * Private function for returning the IDs of all the teams
	 * 
	 * @param teams
	 *            - the list of teams to get IDs from
	 * @return the IDs of all the teams as an array list of strings.
	 */
	private ArrayList<String> getTeamIDs(ArrayList<Team> teams) {
		ArrayList<String> teamIDs = new ArrayList<String>();
		for (int i = 0; i < teams.size(); i++) {
			teamIDs.add(teams.get(i).getTeamID());
		}

		return teamIDs;
	}

    public boolean reset() {
        this.database = new DatabaseSupport();
        return true;
    }

    public List<Player> searchPlayersByAverageCapHit(Integer low, Integer high) {
        List<Player> players = database.getPlayers();
        for (Player p : players) {
            Integer capHit = p.getAverageCapHit();
            if (capHit < low || capHit > high)
                players.remove(p);
        }
        return players;
    }

    public List<Player> searchPlayersByName(String name) {
        List<Player> players = new ArrayList<Player>();
        for (Player p : getPlayers()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase()))
                players.add(p);
        }
        return players;
    }

    public List<Player> searchPlayersByPosition(String position) {
        List<Player> players = database.getPlayers();
        for (Player p : players) {
            if (!p.getPosition().contains(position))
                players.remove(p);
        }
        return players;
    }

    public List<Team> searchTeamsByCapSpace(Integer capSpace) {
        List<Team> teams = database.getTeams();
        for (Team t : teams) {
            if (t.getFreeCapSpace() < capSpace)
                teams.remove(t);
        }
        return teams;
    }

    public boolean removePlayer(String playerID) {
    	return database.removePlayer(playerID);
    }

    public boolean removeTeam(String teamID) {
    	return database.removePlayer(teamID);
    }

    public Team evaluateWinner(String playerID1, String playerID2) {
        Player player1 = getPlayer(playerID1);
        Player player2 = getPlayer(playerID2);
        if (player1.getAverageCapHit() > player2.getAverageCapHit())
            return player1.getTeam();
        return player2.getTeam();
    }

    public boolean evaluate(String playerID1, String playerID2) {
        Player player1 = getPlayer(playerID1);
        Player player2 = getPlayer(playerID2);
        return player1.getTeam().getFreeCapSpace() >= player2.getAverageCapHit()
                && player2.getTeam().getFreeCapSpace() >= player1.getAverageCapHit();
    }

    public boolean extendPlayerContract(String playerID, int years, int salary) {
        Player player = getPlayer(playerID);
        Integer playerSalary = player.getTotalMoney();
        Integer playerYears = player.getYears();
        if (salary < 0 || years < 0) return false;
        Integer newTotalMoney = playerSalary + salary;
        Integer newYears = playerYears + years;
        player.setTotalMoney(newTotalMoney);
        player.setYears(newYears);
        player.setAverageCapHit(newTotalMoney / newYears);
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

    public Integer getFreeCapSpace(String teamID) {
        return database.getTeam(teamID).getFreeCapSpace();
    }

    public ArrayList<Player> getPlayers() {
        return database.getPlayers();
    }

    public ArrayList<Team> getTeams() {
        return database.getTeams();
    }

    public String getTeamName(String teamID) {
        return database.getTeam(teamID).getName();
    }

    public boolean addPlayer(String teamID, String playerID) {
    	Player player = database.getPlayer(playerID);
    	Team team = database.getTeam(teamID);
    	if(player != null && team != null){
	    	team.addPlayer(player);
	    	player.addTeam(team);
	    	database.putPlayer(player);
	    	database.putTeam(team);
	        return true;
    	}
    	return false;
    }

    public Player getPlayer(String playerID) {
        return database.getPlayer(playerID);
    }
}
