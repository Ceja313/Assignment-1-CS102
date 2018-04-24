import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TennisDatabase {

    private TennisPlayersContainer tpc = null;

    private TennisMatchesContainer tmc = null;

    public void loadFromFile(String [] args) {
        if (args.length > 0) {
            String inputFileName= args[0];

            if (args.length > 2) {
                System.out.println("There is more than 1 parameter, only using the first."
                        + "The list of args is : " + args);
            }


            try (Scanner scanner = new Scanner(new File(inputFileName))) {
                readFileStoreData(scanner);
            } catch (IOException ex) {
                System.out.println("Error during reading, command line argument file may not exist.");
                throw new NullPointerException("Error during reading or writing, command line "
                        + "argument file may not exist." + args);
            }


        } else {
            System.out.println("Sorry, TennisDatabase has no argument file to read from ");
        }
    }

    private void readFileStoreData(Scanner scanner) {
        String[] recordInformation;
        while (scanner.hasNextLine()) {
            recordInformation = scanner.nextLine().split("/");

            if (recordInformation.length > 0) {
                createObjectsFromGivenInput(recordInformation);
            }
        }
    }

    private void createObjectsFromGivenInput(String[] recordInformation) {
        switch (recordInformation[0]) {
            case "PLAYER":
                createPlayer(recordInformation);
                break;
            case "MATCH":
                createMatch(recordInformation);
                break;
            default:
                System.out.println("Unexpected data type " + recordInformation[0]);
        }
    }

    private void createPlayer(String[] playerInformation) {
        final TennisPlayer player = new TennisPlayer(playerInformation[0], playerInformation[1]
                , playerInformation[2], parseInt(playerInformation[3]), playerInformation[4]);
    }

    private void createMatch(String[] matchInformation) {
        final TennisMatch match = new TennisMatch(matchInformation[0], matchInformation[1]
                , parseInt(matchInformation[2]), matchInformation[3], matchInformation[4]);
    }

    public void printAllMatches() {
        tmc.printAllMatches();
    }

}
