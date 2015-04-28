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
            if (input.toLowerCase().equals("trade".toLowerCase())) {
            	trade();
            }
            if (input.toLowerCase().equals("getTeam".toLowerCase())) {
            	getTeam();
            }
            if(input.toLowerCase().equals("getPlayersFromTeam".toLowerCase())) {
                getPlayersFromTeam();
            }
            
            if(input.toLowerCase().equals("getPlayer".toLowerCase())){
            	getPlayer();
            }
            
            if(input.toLowerCase().equals("createPlayer".toLowerCase())){
            	createPlayer();
            }
        }
    }

    public static void trade() {
    	Player p1 = null;
    	Player p2 = null;
    	
    	while(p1 == null) {
    		System.out.println("Please enter 1st player name:");
        	String firstPlayerName = scanner.nextLine();
        	List<Player> players = nflManagerController.searchPlayersByName(firstPlayerName);
        	if(players.size() == 0) {
        		System.out.println("No player exists with that name");
        		continue;
        	}
        	
        	p1 = players.get(0);
    	}
    	
    	while(p2 == null) {
    		System.out.println("Please enter 2nd player name:");
        	String firstPlayerName = scanner.nextLine();
        	List<Player> players = nflManagerController.searchPlayersByName(firstPlayerName);
        	if(players.size() == 0) {
        		System.out.println("No player exists with that name");
        		continue;
        	}
        	
        	p2 = players.get(0);
    	}
    	
    	boolean isValidTrade = nflManagerController.evaluate(p1.getId(), p2.getId());
    	
    	if(!isValidTrade) {
    		System.out.println("Trade is not valid!");
    		if(p1.getTeam().getFreeCapSpace() + p1.getAverageCapHit() < p2.getAverageCapHit())
    			System.out.println(p1.getTeam().getName() + " do not have enough cap space for " + p2.getName());
    		if(p2.getTeam().getFreeCapSpace() + p2.getAverageCapHit() < p1.getAverageCapHit())
			System.out.println(p2.getTeam().getName() + " do not have enough cap space for " + p1.getName());
    	} 
    	
    	else {
    		Team winner = nflManagerController.evaluateWinner(p1.getId(), p2.getId());
    		System.out.println(winner.getName() + " wins the trade!");
    	}
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
    	System.out.println("Name\t\tPosition\tTeam\t\tAverage Cap Hit");
    	for(Player p: players){
    		String teamName = "";
    		Team team = p.getTeam();
    		if(team == null){
    			teamName = "N/A";
    		}
    		else{
    			teamName = p.getTeam().getName();
    		}
    		System.out.println(p.getName() + "\t" + p.getPosition() + "\t" + teamName + "\t\t" + p.getAverageCapHit());
    		
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
    
    public static void createPlayer(){
    	System.out.println("Please enter the name of the player you wish to create: ");
    	String playerName = scanner.nextLine();
    	System.out.println("Please enter the position of the player you wish to create: ");
    	String pos = scanner.nextLine();
    	boolean player = nflManagerController.createPlayer(playerName, pos);
    	if(player){
    		System.out.println("Congradulations! " + playerName + " has been successfully created");
    	}
    	else{
    		System.out.println("Unfortantely, " + playerName + "could not be crated");
    	}
    	
    	
    	
    }
}
