package tradeMachine;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class NFLManagerController {

    private NFLManager nflManager;

    boolean createPlayer(String name, String position) {
        return this.getNFLManagerInstance().createPlayer(name, position);
    }

    boolean createTeam(Integer salaryCap, String name) {
        return this.getNFLManagerInstance().createTeam(salaryCap, name);
    }

    boolean setCap(String teamId, Integer cap) {
        return this.getNFLManagerInstance().setCap(teamId, cap);
    }

    Player getPlayer(String playerid) {
        return this.getNFLManagerInstance().getPlayer(playerid);
    }

    boolean addPlayer(String teamid, String playerid) {
        return this.getNFLManagerInstance().addPlayer(teamid, playerid);
    }

    String getTeamName(String teamid) {
        return this.getNFLManagerInstance().getTeamName(teamid);
    }

    List<Team> getTeams() {
        return this.getNFLManagerInstance().getTeams();
    }

    List<Player> getPlayers() {
        return this.getNFLManagerInstance().getPlayers();
    }

    Integer getFreeCapSapce(String teamid) {
        return this.getNFLManagerInstance().getFreeCapSapce(teamid);
    }

    Integer getNumberOfPlayers(String teamid) {
        return this.getNFLManagerInstance().getNumberOfPlayers(teamid);
    }

    String getPlayerName(String playerid) {
        return this.getNFLManagerInstance().getPlayerName(playerid);
    }

    String getPlayerPosition(String playerid) {
        return this.getNFLManagerInstance().getPlayerPosition(playerid);
    }

    Team getPlayerTeam(String playerid) {
        return this.getNFLManagerInstance().getPlayerTeam(playerid);
    }

    Integer getPlayerYears(String playerd) {
        return this.getNFLManagerInstance().getPlayerYears(playerd);
    }

    Integer getPlayerTotalMoney(String playerid) {
        return this.getNFLManagerInstance().getPlayerTotalMoney(playerid);
    }

    Integer getPlayerAverageCapHit(String playerid) {
        return this.getNFLManagerInstance().getPlayerAverageCapHit(playerid);
    }

    boolean extendPlayerContract(String playerid, int years) {
        return this.getNFLManagerInstance().extendPlayerContract(playerid, years);
    }

    boolean evaluate(String playerid1, String playerid2) {
        return this.getNFLManagerInstance().evaluate(playerid1, playerid2);
    }

    Team evaluateWinner(String playerid1, String playerid2) {
        return this.getNFLManagerInstance().evaluateWinner(playerid1, playerid2);
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
