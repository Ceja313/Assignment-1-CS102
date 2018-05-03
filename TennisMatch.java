import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TennisMatch implements TennisMatchInterface {

    private String firstPlayerId;

    private String secondPlayerId;

    private String tennisMatchDate;

    private String locationOfMatch;

    private String winner;

    private String score;

    private TennisMatchSetScore scores;

    /*
    Desc.: Processes the match score and returns the set score.
    Input: The match score as a String, and a set score (Output variable).
    Output: The validity of the input match score. (Returns true of the score is valid)
    worry about validity after valid scores work
     */
    private boolean processMatchScore( String score, TennisMatchSetScore scores) {
        if (score.length() == 0) {
            return true;
        } else {
            Scanner scoreScanner = new Scanner(score).useDelimiter(",");
            String set1Score = scoreScanner.next();
            Scanner set1Scanner = new Scanner(set1Score).useDelimiter("-");
            int gamesPlayer1 = set1Scanner.nextInt();
            int gamesPlayer2 = set1Scanner.nextInt();
            if (gamesPlayer1 > gamesPlayer2) {
                scores.setsPlayer1++;
            } else if (gamesPlayer1 < gamesPlayer2) {
                scores.setsPlayer2++;
            } else {
                return false;
            }

            if (set1Score.length() == score.length()) {
                return true;
            } else {
                String restScore = score.substring(set1Score.length() + 1);
                return processMatchScore(restScore, scores);
            }
        }
    }
    //A tennis match when inserted should have a reference from the tennismatchescontainer, tennismatcheslist
    // of the first player of the match,
    // tennismatcheslist of the second player of the match
    public TennisMatch(String firstPlayerId, String secondPlayerId, String tennisMatchDate
            , String locationOfMatch, String score) throws TennisDatabaseException {
        if(firstPlayerId == null) {
            throw new TennisDatabaseException("firstPlayer Id is not a valid Id");
        } else if (secondPlayerId == null) {
            throw new TennisDatabaseException("Second player Id is not a valid Id");
        } else if (tennisMatchDate == null) {
            throw new TennisDatabaseException("tennisMatchDate is not a valid date");
        } else if (locationOfMatch == null) {
            throw new TennisDatabaseException("locationOfMatch is not valid");
        } else if (score == null) {
            throw new TennisDatabaseException("scores is not valid");
        } else {
            setFirstPlayerId(firstPlayerId);
            setSecondPlayerId(secondPlayerId);
            setTennisMatchDate(tennisMatchDate);
            setLocationOfMatch(locationOfMatch);
            setScore(score);
            this.scores = new TennisMatchSetScore();

            boolean scoreValid = processMatchScore(score, scores);
            if (!scoreValid) {
                throw new TennisDatabaseException("Tennis match score not valid");
            }
            if (scores.setsPlayer1 > scores.setsPlayer2) {
                winner = firstPlayerId;
            } else if (scores.setsPlayer1 < scores.setsPlayer2) {
                winner = secondPlayerId;
            } else {
                throw new TennisDatabaseException("Tennis match score not valid");
            }
        }
    }

    private void setFirstPlayerId(String firstPlayerId) {
        this.firstPlayerId = firstPlayerId;
    }

    private void setSecondPlayerId(String secondPlayerId) {
        this.secondPlayerId = secondPlayerId;
    }

    public String getTennisMatchDate() {
        return this.tennisMatchDate;
    }

    private void setTennisMatchDate(String tennisMatchDate) {
        this.tennisMatchDate = tennisMatchDate;
    }


    private void setLocationOfMatch(String locationOfMatch) {
        this.locationOfMatch = locationOfMatch;
    }

    private void setScore(String score) {
        this.score = score;
    }

    public String getPlayer1Id() {
        return this.firstPlayerId;
    }

    public String getPlayer2Id() {
        return this.secondPlayerId;
    }

    public int getDateMonth() {
        return parseInt(getTennisMatchDate().substring(4,6));
    }

    public int getDateYear() {
        return parseInt(getTennisMatchDate().substring(0,4));
    }

    public int getDateDay() {
        return parseInt(getTennisMatchDate().substring(6,8));
    }

    public String getTournament() {
        return this.locationOfMatch;
    }

    public String getScore() { return scores.setsPlayer1 + "-" + scores.setsPlayer2;}

    public String getWinner() {
        return winner;
    }
    public void print() {
        System.out.print( firstPlayerId + ", " );
        System.out.print( secondPlayerId + ", ");
        System.out.print(getDateYear() + "-" + getDateMonth() + "-" + getDateDay() + ", ");
        System.out.print( getTournament() + ", ");
        System.out.print(score + ", ");
        System.out.print("Winner: " + winner);
        System.out.println();
    }


    @Override
    public int compareTo(TennisMatch match) {
        if(getDateYear() < match.getDateYear()) {
            return 1;
        } else if(getDateYear() == match.getDateYear()
                && getDateMonth() < match.getDateMonth()) {
            return 1;
        } else if(getDateYear() == match.getDateYear()
                && getDateMonth() == match.getDateMonth()
                && getDateDay() < match.getDateDay()) {
            return 1;
        } else {
            return 0;
        }
    }
}
