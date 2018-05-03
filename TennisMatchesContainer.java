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
            int index2 = 0;
            TennisMatch matchHolder;
            TennisMatch secondMatchHolder;
            for (int index = 0; index < numberOfMatches ; index++) {
                if(index2 != 1) {
                    if (matches[index] != null && matches[index].compareTo(match) != 0) {
                        matchHolder = matches[index];
                        matches[index] = match;
                        index2++;
                        for(int index3 = index; index3 < numberOfMatches; index3++) {
                            secondMatchHolder = matches[index3];
                            matches[index3] = matchHolder;
                            if(index3 == numberOfMatches - 1) {
                                matches[numberOfMatches - 1] = secondMatchHolder;
                            }
                        }
                    }
                }
            }
        }
        numberOfMatches++;
    }

    @Override
    public void printAllMatches() {
        for(int index = 0; index < numberOfMatches; index++) {
            matches[index].print();
        }
    }
}
