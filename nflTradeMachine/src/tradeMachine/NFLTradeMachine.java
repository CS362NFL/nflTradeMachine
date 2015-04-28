package tradeMachine;

import java.util.List;
import java.util.Scanner;

public class NFLTradeMachine {
    static private Scanner scanner;
    static private NFLManagerController nflManagerController;

    public static void main(String[] args) {
        nflManagerController = new NFLManagerController();
        String input = "";
        scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to the NFL Trade Machine!");
        System.out.println("--------------------------------------------\n");
        while (!input.equals("Exit") && !input.equals("exit")) {
            System.out.println("Please enter one of the following commands: trade, getTeam, getPlayer, getPlayersFromTeam, exit");
            input = scanner.nextLine();
            if (input.equals("getTeam")) {
            	getTeam();
            }
            if(input.toLowerCase().equals("getPlayersFromTeam".toLowerCase())) {
                getPlayersFromTeam();
            }
            
            if(input.toLowerCase().equals("getPlayer".toLowerCase())){
            	getPlayer();
            }
        }
    }

    public void trade() {

    }

    public static void getTeam() {
    	System.out.println("Please enter a team name to get the players from:");
        String teamName = scanner.nextLine();
        System.out.println("Name\t\tSalary Cap\tFree Cap Space");
    	for(Team t: nflManagerController.getTeams()) {
    		if(t.getName().toLowerCase().contains(teamName.toLowerCase())) {
    			System.out.println(t.getName() + "\t" + t.getSalaryCap() + "\t" + t.getFreeCapSpace());
    		}
    	}
    }

    public static void getPlayer() {
    	System.out.println("Please enter the name of the player you wish to view: ");
    	String playerName = scanner.nextLine();
    	List<Player> players = nflManagerController.searchPlayersByName(playerName);
    	System.out.println("Name\t\tPosition\tTeam\t\t\tAverage Cap Hit");
    	for(Player p: players){
    		System.out.println(p.getName() + "\t" + p.getPosition() + "\t" + p.getTeam().getName() + "\t\t" + p.getAverageCapHit());
    	}
    }

    public static void getPlayersFromTeam() {
        System.out.println("Please enter a team name to get the players from:");
        String teamName = scanner.nextLine();
        List<Team> teams = nflManagerController.getTeams();
        for(Team t : teams) {
            if(t.getName().toLowerCase().contains(teamName.toLowerCase())) {
                System.out.println("Players for " + t.getName() + ":");
                System.out.println("Name\t\tPosition\tAverage Cap Hit");
                for(Player p : t.getPlayers()) {
                    System.out.println(p.getName() + "\t" + p.getPosition() + "\t" + p.getAverageCapHit());
                }
            }
        }
    }
}
