package tradeMachine;

import java.util.List;

/**
 * Controller pattern class for NFLManager
 */
public class NFLManagerController {

    /**
     * Attribute that represents an NFLManager object
     */
    private NFLManager nflManager;

    /**
     * Method to call the createPlayer method of NFLManager
     *
     * @param name     The name of the Player to be added
     * @param position The position of the Player to be added
     * @return Whether or not the operation was successful
     */
    boolean createPlayer(String name, String position) {
        return this.getNFLManagerInstance().createPlayer(name, position);
    }

    /**
     * Method to call the createTeam method of NFLManager
     *
     * @param name      The name of the Team to be added
     * @param salaryCap The salary cap of the team to be added
     * @return Whether or not the operation was successful
     */
    boolean createTeam(String name, Integer salaryCap) {
        return this.getNFLManagerInstance().createTeam(name, salaryCap);
    }

    /**
     * Method to call the setCap method of NFLManager
     *
     * @param teamID The ID of the team to set the cap of
     * @param cap    The new cap of the team
     * @return Whether or not the operation was successful
     */
    boolean setCap(String teamID, Integer cap) {
        return this.getNFLManagerInstance().setCap(teamID, cap);
    }

    /**
     * Method to call the getPlayer method of NFLManager
     *
     * @param playerID The ID of the Player to get
     * @return The requested Player
     */
    Player getPlayer(String playerID) {
        return this.getNFLManagerInstance().getPlayer(playerID);
    }

    /**
     * Method to call the addPlayer method of NFLManager
     *
     * @param teamID   The ID of the Team to add the Player to
     * @param playerID The ID of the player to add
     * @return Whether or not the operation was successful
     */
    boolean addPlayer(String teamID, String playerID) {
        return this.getNFLManagerInstance().addPlayer(teamID, playerID);
    }

    /**
     * Method to call the getTeamName method of NFLManager
     *
     * @param teamID The ID of the Team to get the name of
     * @return The name of the Team
     */
    String getTeamName(String teamID) {
        return this.getNFLManagerInstance().getTeamName(teamID);
    }

    /**
     * Method to call the getTeams method of NFLManager
     *
     * @return The list of all Teams
     */
    List<Team> getTeams() {
        return this.getNFLManagerInstance().getTeams();
    }

    /**
     * Method to call the getPlayers method of NFLManager
     *
     * @return The list of all Players
     */
    List<Player> getPlayers() {
        return this.getNFLManagerInstance().getPlayers();
    }

    /**
     * Method to call the getFreeCapSpace method of NFLManager
     *
     * @param teamID The ID of the Team to get the Free Cap Space of
     * @return The Free Cap Space of the Team
     */
    Integer getFreeCapSpace(String teamID) {
        return this.getNFLManagerInstance().getFreeCapSpace(teamID);
    }

    /**
     * Method to call the getNumberOfPlayers method of NFLManager
     *
     * @param teamID The ID of the Team to get the number of Players for
     * @return The number of Players on the Team
     */
    Integer getNumberOfPlayers(String teamID) {
        return this.getNFLManagerInstance().getNumberOfPlayers(teamID);
    }

    /**
     * Method to call the getPlayerName method of NFLManager
     *
     * @param playerID The ID of the Player to get the ID of
     * @return The name of the Player
     */
    String getPlayerName(String playerID) {
        return this.getNFLManagerInstance().getPlayerName(playerID);
    }

    /**
     * Method to call the getPlayerPosition method of NFLManager
     *
     * @param playerID The ID of the Player to get the position of
     * @return The position of the Player
     */
    String getPlayerPosition(String playerID) {
        return this.getNFLManagerInstance().getPlayerPosition(playerID);
    }

    /**
     * Method to call the getPlayerTeam method of NFLManager
     *
     * @param playerID The ID of the Player to get the Team of
     * @return The Team of the Player
     */
    Team getPlayerTeam(String playerID) {
        return this.getNFLManagerInstance().getPlayerTeam(playerID);
    }

    /**
     * Method to call the getPlayerYears method of NFLManager
     *
     * @param playerID The ID of the Player to get the years of
     * @return The years of the Player
     */
    Integer getPlayerYears(String playerID) {
        return this.getNFLManagerInstance().getPlayerYears(playerID);
    }

    /**
     * Method to call the getPlayerTotalMoney method of NFLManager
     *
     * @param playerID The ID of the Player to get the total money of
     * @return The total money of the Player
     */
    Integer getPlayerTotalMoney(String playerID) {
        return this.getNFLManagerInstance().getPlayerTotalMoney(playerID);
    }

    /**
     * Method to call the getPlayerAverageCapHit method of NFLManager
     *
     * @param playerID The ID of the Player to get the average cap hit of
     * @return The average cap hit of the Player
     */
    Integer getPlayerAverageCapHit(String playerID) {
        return this.getNFLManagerInstance().getPlayerAverageCapHit(playerID);
    }

    /**
     * Method to call the extendPlayerContract method of NFLManager
     *
     * @param playerID The ID of the Player to extend the contract of
     * @param years    The number of years to add to the players contract
     * @param salary   The amount of money to add to the players contract
     * @return Whether the operation was successful
     */
    boolean extendPlayerContract(String playerID, int years, int salary) {
        return this.getNFLManagerInstance().extendPlayerContract(playerID, years, salary);
    }

    /**
     * Method to call the evaluate method of NFLManager
     *
     * @param playerID1 The ID of the first Player to trade
     * @param playerID2 The ID of the second Player to trade
     * @return Whether the operation was successful
     */
    boolean evaluate(String playerID1, String playerID2) {
        return this.getNFLManagerInstance().evaluate(playerID1, playerID2);
    }

    /**
     * Method to call the evaluateWinner method of NFLManager
     *
     * @param playerID1 The ID of the first Player to trade
     * @param playerID2 The ID of the second Player to trade
     * @return The winning Team of the trade
     */
    Team evaluateWinner(String playerID1, String playerID2) {
        return this.getNFLManagerInstance().evaluateWinner(playerID1, playerID2);
    }

    /**
     * Method to call the removeTeam method of NFLManager
     *
     * @param teamID The ID of the Team to remove
     * @return Whether the operation was successful
     */
    boolean removeTeam(String teamID) {
        return this.getNFLManagerInstance().removeTeam(teamID);
    }

    /**
     * Method to call the removePlayer method of NFLManager
     *
     * @param playerID The ID of the Player to remove
     * @return Whether the operation was successful
     */
    boolean removePlayer(String playerID) {
        return this.getNFLManagerInstance().removePlayer(playerID);
    }

    /**
     * Method to call the searchTeamsByCapSpace method of NFLManager
     *
     * @param capSpace The low bound of the cap space to look for
     * @return A list of Teams that have at least the given cap space
     */
    List<Team> searchTeamsByCapSpace(Integer capSpace) {
        return this.getNFLManagerInstance().searchTeamsByCapSpace(capSpace);
    }

    /**
     * Method to call the searchPlayersByPosition method of NFLManager
     *
     * @param position The position to search for
     * @return A list of Players that match the given position
     */
    List<Player> searchPlayersByPosition(String position) {
        return this.getNFLManagerInstance().searchPlayersByPosition(position);
    }

    /**
     * Method to call the searchPlayersByName method of NFLManager
     *
     * @param name The name to search for
     * @return A list of Players that match the given name
     */
    List<Player> searchPlayersByName(String name) {
        return this.getNFLManagerInstance().searchPlayersByName(name);
    }

    /**
     * Method to call the searchPlayersByAverageCapHit method of NFLManager
     *
     * @param low  The low average cap hit to search for
     * @param high The high average cap hit to search for
     * @return A list of Players that have an average cap hit between the given high and low
     */
    List<Player> searchPlayersByAverageCapHit(Integer low, Integer high) {
        return this.getNFLManagerInstance().searchPlayersByAverageCapHit(low, high);
    }

    /**
     * Method to call the reset method of NFLManager
     *
     * @return Whether the operation was successful
     */
    boolean reset() {
        return this.getNFLManagerInstance().reset();
    }

    /**
     * Method to get an instance of NFLManager to use
     *
     * @return An instance of NFLManager
     */
    private NFLManager getNFLManagerInstance() {
        if (nflManager == null) nflManager = new NFLManager();
        return nflManager;
    }
}
