public class TennisMatchesContainer implements TennisMatchesContainerInterface{
    private TennisMatch[] matches;
    private int numberOfMatches;

    public TennisMatchesContainer() {
        matches = new TennisMatch[10];
        numberOfMatches = 0;
    }

    // Add a person to the List of Persons in the last position
    @Override
    public void insertMatch(TennisMatch match) throws TennisDatabaseRuntimeException {
        if (numberOfMatches == matches.length) {
            // The array is full!!!
            // We have to create a new, bigger array and copy all elements
            TennisMatch[] temporaryMatchHolder = new TennisMatch[matches.length * 2];
            for (int index = 0; index < matches.length; index++)
                temporaryMatchHolder[index] = matches[index];
            matches = temporaryMatchHolder;
        }
        // Now we are sure that numberOfMatches < matches.length
        if (matches[0] == null) {
            matches[0] = match;
        } else {
            int indexToPutDate;
            for (int index = 0; index < numberOfMatches; index++) {
                if (matches[index].compareTo(match) != 0) {
                    indexToPutDate = index;
                }
            }
            for (int index = 1; index < numberOfMatches; index++) {
                if (matches[(index - 1)].getDateYear() == matches[index].getDateYear()) {

                }
            }
        }
        matches[numberOfMatches] = match;
        numberOfMatches++;
    }

    @Override
    public void printAllMatches() {
        for(int index = 0; index < numberOfMatches; index++) {
            matches[index].print();
        }
    }
}
