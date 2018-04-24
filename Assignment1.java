
import java.util.Scanner;


public class Assignment1 {

    private static final Assignment1 assignment = new Assignment1();

    //private static final TennisDatabase DATABASE = new TennisDatabase();

    private static final TennisMatchesContainer TMC = new TennisMatchesContainer();

    private static final TennisPlayersContainer TPC = new TennisPlayersContainer();

    public static void main(String[] args) {
        TennisDatabase database = new TennisDatabase();
        database.loadFromFile(args);
        assignment.displayUserOptions(database);

    }

    private void displayUserOptions(TennisDatabase database) {
        System.out.println("Welcome to the CS-102 Tennis Manager");
        int selection;
        do {
            System.out.println("Available Commands:");
            System.out.println("1 -- Print all tennis players");
            System.out.println("2 -- Print all tennis matches of a player");
            System.out.println("3 -- Print all tennis matches.");
            System.out.println("4 -- Insert a new player.");
            System.out.println("5 -- Insert a new match.");
            System.out.println("8 -- Exit");
            System.out.print("Enter your selection : ");
            Scanner userInput = new Scanner(System.in);
            selection = userInput.nextInt();

            switch (selection) {
                case 1:
                    printAllTennisPlayers();
                    break;
                case 2:
                    printAllTennisMatchesOfAPlayer(userInput);
                    break;
                case 3:
                    printAllTennisMatches(database);
                case 4:
                    insertNewPlayer();
                case 5:
                    insertNewMatch();
                case 8:
                    System.out.println("I hope you had fun!");
                default:
                    System.out.println("Input is not a valid option.");
            }

        } while (selection != 8);
    }

    private void printAllTennisPlayers() {

    }

    private void printAllTennisMatchesOfAPlayer(Scanner userInput) {
        System.out.print("Enter Tennis Players Id : ");
        int selection = userInput.nextInt();
        System.out.println(selection);

    }

    private void printAllTennisMatches(TennisDatabase database) {
        database.printAllMatches();

    }

    private void insertNewPlayer() {

    }

    private void insertNewMatch() {

    }
}
