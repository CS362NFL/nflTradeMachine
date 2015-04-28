package tradeMachine;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class NFLManagerController {

    private NFLManager nflManager;

    boolean createPlayer(String name, String position) {
        return this.getNFLManagerInstance().createPlayer(name, position);
    }

    boolean createTeam(String name, Integer salaryCap) {
        return this.getNFLManagerInstance().createTeam(name, salaryCap);
    }

    boolean setCap(String teamID, Integer cap) {
        return this.getNFLManagerInstance().setCap(teamID, cap);
    }

    Player getPlayer(String playerID) {
        return this.getNFLManagerInstance().getPlayer(playerID);
    }

    boolean addPlayer(String teamID, String playerID) {
        return this.getNFLManagerInstance().addPlayer(teamID, playerID);
    }

    String getTeamName(String teamID) {
        return this.getNFLManagerInstance().getTeamName(teamID);
    }

    List<Team> getTeams() {
        return this.getNFLManagerInstance().getTeams();
    }

    List<Player> getPlayers() {
        return this.getNFLManagerInstance().getPlayers();
    }

    Integer getFreeCapSapce(String teamID) {
        return this.getNFLManagerInstance().getFreeCapSapce(teamID);
    }

    Integer getNumberOfPlayers(String teamID) {
        return this.getNFLManagerInstance().getNumberOfPlayers(teamID);
    }

    String getPlayerName(String playerID) {
        return this.getNFLManagerInstance().getPlayerName(playerID);
    }

    String getPlayerPosition(String playerID) {
        return this.getNFLManagerInstance().getPlayerPosition(playerID);
    }

    Team getPlayerTeam(String playerID) {
        return this.getNFLManagerInstance().getPlayerTeam(playerID);
    }

    Integer getPlayerYears(String playerd) {
        return this.getNFLManagerInstance().getPlayerYears(playerd);
    }

    Integer getPlayerTotalMoney(String playerID) {
        return this.getNFLManagerInstance().getPlayerTotalMoney(playerID);
    }

    Integer getPlayerAverageCapHit(String playerID) {
        return this.getNFLManagerInstance().getPlayerAverageCapHit(playerID);
    }

    boolean extendPlayerContract(String playerID, int years, int salary) {
        return this.getNFLManagerInstance().extendPlayerContract(playerID, years, salary);
    }

    boolean evaluate(String playerID1, String playerID2) {
        return this.getNFLManagerInstance().evaluate(playerID1, playerID2);
    }

    Team evaluateWinner(String playerID1, String playerID2) {
        return this.getNFLManagerInstance().evaluateWinner(playerID1, playerID2);
    }

    boolean removeTeam(String teamID) {
        return this.getNFLManagerInstance().removeTeam(teamID);
    }

    boolean removePlayer(String playerID) {
        return this.getNFLManagerInstance().removePlayer(playerID);
    }

    List<Team> searchTeamsByCapSpace(Integer capSpace) {
        return this.getNFLManagerInstance().searchTeamsByCapSpace(capSpace);
    }

    List<Player> searchPlayersByPosition(String position) {
        return this.getNFLManagerInstance().searchPlayersByPosition(position);
    }

    List<Player> searchPlayersByName(String name) {
        return this.getNFLManagerInstance().searchPlayersByName(name);
    }

    List<Player> searchPlayersByAverageCapHit(Integer low, Integer high) {
        return this.getNFLManagerInstance().searchPlayersByAverageCapHit(low, high);
    }

    boolean reset() {
        return this.getNFLManagerInstance().reset();
    }

    private NFLManager getNFLManagerInstance(){
        if(nflManager == null) nflManager = new NFLManager();
        return nflManager;
    }
}
