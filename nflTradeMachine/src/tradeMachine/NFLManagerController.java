package tradeMachine;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class NFLManagerController {
    boolean createPlayer(String name, String position) {
        return false;
    }

    boolean createTeam(Integer salaryCap, String name) {
        return false;
    }

    boolean setCap(String teamId, Integer cap) {
        return false;
    }

    Player getPlayer(String playerid) {
        return null;
    }

    boolean addPlayer(String teamid, String playerid) {
        return false;
    }

    String getTeamName(String teamid) {
        return null;
    }

    List<Team> getTeams() {
        return null;
    }

    List<Player> getPlayers() {
        return null;
    }

    Integer getFreeCapSapce(String teamid) {
        return null;
    }

    Integer getNumberOfPlayers(String teamid) {
        return null;
    }

    String getPlayerName(String playerid) {
        return null;
    }

    String getPlayerPosition(String playerid) {
        return null;
    }

    Team getPlayerTeam(String playerid) {
        return null;
    }

    Integer getPlayerYears(String playerd) {
        return null;
    }

    Integer getPlayerTotalMoney(String playerid) {
        return null;
    }

    Integer getPlayerAverageCapHit(String playerid) {
        return null;
    }

    boolean extendPlayerContract(String playerid, int years) {
        return false;
    }

    boolean evaluate(String playerid1, String playerid2) {
        return false;
    }

    Team evaluateWinner(String playerid1, String playerid2) {
        return null;
    }

    boolean removeTeam(String teamID) {
        return false;
    }

    boolean removePlayer(String playerID) {
        return false;
    }

    List<Team> searchTeamsByCapSpace(Integer capSpace) {
        return null;
    }

    List<Player> searchPlayersByPosition(String position) {
        return null;
    }

    List<Player> searchPlayersByName(String name) {
        return null;
    }

    List<Player> searchPlayersByAverageCapHit(Integer low, Integer high) {
        return null;
    }

    boolean reset() {
        return false;
    }
}
