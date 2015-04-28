package tradeMachine;

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
            input = scanner.next();
            if (input.equals("getTeam")) {

            }


        }
    }

    public void trade() {

    }

    public void getTeam() {

    }

    public void getPlayer() {

    }

    public void getPlayersFromTeam() {
        System.out.println("Please enter a team name to get the players from:");
        String teamName = scanner.next();
    }
}
