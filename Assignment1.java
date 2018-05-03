
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Assignment1 {

    private static final Assignment1 assignment = new Assignment1();

    public static void main(String[] args) {
        TennisDatabase database = new TennisDatabase();
        database.loadFromFile(args);
        assignment.displayUserOptions(database);


    }

    private void displayUserOptions(TennisDatabase database) {
        System.out.println("Welcome to the CS-102 Tennis Manager, my name is Jeff Ceja");
        int selection;
        do {
            System.out.println(); System.out.println();
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
                    printAllTennisPlayers(database);
                    break;
                case 2:
                    printAllTennisMatchesOfAPlayer(userInput, database);
                    break;
                case 3:
                    printAllTennisMatches(database);
                    break;
                case 4:
                    System.out.println("What is the Id, firstName, lastName, year, and country of the player? ");
                    System.out.println("For example a response could be: Jeff313,Jeffery,Ceja,2012,America");
                    String playerInformation = userInput.next();
                    String [] playerInfo = playerInformation.split(",");
                    TennisPlayer player = new TennisPlayer(playerInfo[0], playerInfo[1], playerInfo[2],
                            parseInt(playerInfo[3]), playerInfo[4]);
                    insertNewPlayer(database, player);
                    break;
                case 5:
                    System.out.println("What is the firstPlayerId, secondPlayerId, date, location, and scores " +
                            "of the match?");
                    System.out.println("For example a response could be: FED81/DJO87/20150817/CINCINNATI/7-6, 6-4");
                    String matchInformation = userInput.next();
                    String [] matchInfo = matchInformation.split("/");
                    try {
                        TennisMatch match = new TennisMatch(matchInfo[0], matchInfo[1], matchInfo[2], matchInfo[3],
                                matchInfo[4]);
                        insertNewMatch(database, match);
                    } catch (TennisDatabaseException ex) {
                        System.out.println("Unable to insert tennisMatch, invalid input");
                        System.out.println("Information supplied:");
                        for(int index = 0; index < matchInfo.length; index++) {
                            System.out.println(matchInfo[index]);
                        }
                }
                    break;
                case 8:
                    System.out.print("I hope you had fun!");
                    break;
                default:
                    System.out.println("Input is not a valid option.");
            }

        } while (selection != 8);

    }

    private void printAllTennisPlayers(TennisDatabase database) {
        database.printAllTennisPlayers();
    }

    private void printAllTennisMatchesOfAPlayer(Scanner userInput, TennisDatabase database) {
        System.out.print("Enter Tennis Players Id : ");
        String playerId = userInput.next();
        database.printTennisMatchesOfPlayer(playerId);

    }

    private void printAllTennisMatches(TennisDatabase database) {
        database.printAllMatches();
    }

    private void insertNewPlayer(TennisDatabase database, TennisPlayer player) {

        try {
            database.userCreatePlayer(player);
        } catch (TennisDatabaseRuntimeException ex) {
            System.out.println("Tennis player is already within the container.");
            player.print();
        }
    }

    private void insertNewMatch(TennisDatabase database, TennisMatch match) {
        database.userCreateMatch(match);
    }


}
