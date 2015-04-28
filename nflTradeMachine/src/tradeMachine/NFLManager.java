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

    /**
     * Creates a player and add the player to the database
     * @param name - Name of the player
     * @param position - position the player plays
     * @return true if successful, false otherwise
     */
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
    
    /**
     * Searches all the players by the average cap hit 
     * @param low - floor range of the cap hit
     * @param high - ceiling of the cap hit 
     * @return list of players with the cap hit in range
     */
    public List<Player> searchPlayersByAverageCapHit(Integer low, Integer high) {
        List<Player> players = new ArrayList<Player>();
        for (Player p : getPlayers()) {
            Integer capHit = p.getAverageCapHit();
            if (capHit >= low || capHit <= high)
                players.add(p);
        }
        return players;
    }
    
    /**
     * Searches the players by their name
     * @param name - name of the player to search
     * @return the list of players with the specified name
     */
    public List<Player> searchPlayersByName(String name) {
        List<Player> players = new ArrayList<Player>();
        for (Player p : getPlayers()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase()))
                players.add(p);
        }
        return players;
    }
    
    /**
     * Searches the players by their position
     * @param position - the position to search for
     * @return - the list of players with the specified postion
     */
    public List<Player> searchPlayersByPosition(String position) {
        List<Player> players = new ArrayList<Player>();
        for (Player p : getPlayers()) {
            if (p.getPosition().toLowerCase().contains(position.toLowerCase()))
                players.add(p);
        }
        return players;
    }
    
    /**
     * Searches the teams by their available cap space
     * @param capSpace - the cap space to search by
     * @return - the teams with the specified cap space available (or greater)
     */
    public List<Team> searchTeamsByCapSpace(Integer capSpace) {
        List<Team> teams = new ArrayList<Team>();
        for (Team t : getTeams()) {
            if (t.getFreeCapSpace() >= capSpace)
                teams.add(t);
        }
        return teams;
    }
    
    /**
     * Removes a player from the system
     * @param playerID - the id of the player to remove
     * @return true if successful, false otherwise
     */
    public boolean removePlayer(String playerID) {
    	return database.removePlayer(playerID);
    }
    /**
     * Removes a team from the system
     * @param teamID - the id of the team to remove
     * @return true if successful, false otherwise
     */
    public boolean removeTeam(String teamID) {
    	return database.removePlayer(teamID);
    }
    
    /**
     * Evaluates the winner after a trade has been suggested
     * @param playerID1 - the id of the first player
     * @param playerID2 - the id of the second player
     * @return the team that has won the trade
     */
    public Team evaluateWinner(String playerID1, String playerID2) {
        Player player1 = getPlayer(playerID1);
        Player player2 = getPlayer(playerID2);
        if (player1.getAverageCapHit() > player2.getAverageCapHit())
            return player1.getTeam();
        return player2.getTeam();
    }
    
    /**
     * Evaluate whether or not a trade would be successful or not
     * @param playerID1 - the first player to be traded
     * @param playerID2 - the second player to be traded
     * @return true if the trade would be successful, false otherwise
     */
    public boolean evaluate(String playerID1, String playerID2) {
        Player player1 = getPlayer(playerID1);
        Player player2 = getPlayer(playerID2);
        return player1.getTeam().getFreeCapSpace() >= player2.getAverageCapHit()
                && player2.getTeam().getFreeCapSpace() >= player1.getAverageCapHit();
    }
    
    
    /**
     * Extends the player contract by giving them more salary and years on the contract
     * @param playerID - The id of the player to extend the contract
     * @param years - the number of years to extend 
     * @param salary - the amount of salary to give the player
     * @return true if successfully exteneded the player contract, false otherwise
     */
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
    
    /**
     * Get the player average cap hit from the database
     * @param playerID - the id of the player
     * @return the average cap hit (Integer)
     */
    public Integer getPlayerAverageCapHit(String playerID) {
        return database.getPlayer(playerID).getAverageCapHit();
    }
    
    /**
     * Get the player total money from the database
     * @param playerID - the id of the player 
     * @return the total money the player is receiving (Integer)
     */
    public Integer getPlayerTotalMoney(String playerID) {
        return database.getPlayer(playerID).getTotalMoney();
    }

    /**
     * Get the number of years the player has on the team
     * @param playerid - the id of the player 
     * @return the number of years the player has on the team (Integer)
     */
    public Integer getPlayerYears(String playerid) {
        return database.getPlayer(playerid).getYears();
    }
    
    /**
     * Get the team the player is currently on
     * @param playerID - the id of the player
     * @return the Team currently associated with the player
     */
    public Team getPlayerTeam(String playerID) {
        return database.getPlayer(playerID).getTeam();
    }
    
    /**
     * Get the position of a player
     * @param playerID - the id of the player
     * @return the position the player is currently playing
     */
    public String getPlayerPosition(String playerID) {
        return database.getPlayer(playerID).getPosition();
    }

    /**
     * Get the name of the player
     * @param playerID - the id of the player
     * @return the name of the player (String)
     */
    public String getPlayerName(String playerID) {
        return database.getPlayer(playerID).getName();
    }
    
    /**
     * Get the numbers players on the given team
     * @param teamID - the id of the team
     * @return the number of players currently on the team
     */
    public Integer getNumberOfPlayers(String teamID) {
        return database.getTeam(teamID).getPlayers().size();
    }
    
    /**
     * Gets the free cap space from the team
     * @param teamID - the id of the team
     * @return - the amount of free cap space the team currently has
     */
    public Integer getFreeCapSpace(String teamID) {
        return database.getTeam(teamID).getFreeCapSpace();
    }
    
    /**
     * Gets all the players from the system
     * @return a list of all the players
     */
    public ArrayList<Player> getPlayers() {
        return database.getPlayers();
    }
    
    /**
     * Gets the teams from the system
     * @return the list of all the teams
     */
    public ArrayList<Team> getTeams() {
        return database.getTeams();
    }
    /**
     * Get the team name from the team id
     * @param teamID - the id of the team
     * @return - the name of the team (String)
     */
    public String getTeamName(String teamID) {
        return database.getTeam(teamID).getName();
    }
    
    /**
     * Adds a player to a team
     * @param teamID - the id of the team to get the player
     * @param playerID - the id of the player to be added to a team
     * @return true if the player was successfully added, false otherwise
     */
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
    
    /**
     * Get the player from the playerid
     * @param playerID - the id of the player
     * @return the Player with the specified id
     */
    public Player getPlayer(String playerID) {
        return database.getPlayer(playerID);
    }
}
