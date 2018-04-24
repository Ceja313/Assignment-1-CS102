import static java.lang.Integer.parseInt;

public class TennisMatch implements TennisMatchInterface {

    private String firstPlayerId;

    private String secondPlayerId;

    private String tennisMatchDate;

    private String locationOfMatch;

    private String scores;

    private String winner;

    private TennisMatchSetScore score = new TennisMatchSetScore();

    /*
    Desc.: Processes the match score and returns the set score.
    Input: The match score as a String, and a set score (Output variable).
    Output: The validity of the input match score. (Returns true of the score is valid)
    worry about validity after valid scores work
     */
    private boolean processMatchScore( String score, TennisMatchSetScore setScore) {

        return false;
    }

    public TennisMatch(String firstPlayerId, String secondPlayerId, String tennisMatchDate
            , String locationOfMatch, String scores) {
        setFirstPlayerId(firstPlayerId);
        setSecondPlayerId(secondPlayerId);
        setTennisMatchDate(tennisMatchDate);
        setLocationOfMatch(locationOfMatch);
        setScores(scores);
    }

    public String getPlayer1Id() {
        return this.firstPlayerId;
    }

    private void setFirstPlayerId(String firstPlayerId) {
        this.firstPlayerId = firstPlayerId;
    }

    public String getPlayer2Id() {
        return this.secondPlayerId;
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

    public String getTournament() {
        return this.locationOfMatch;
    }

    private void setLocationOfMatch(String locationOfMatch) {
        this.locationOfMatch = locationOfMatch;
    }

    public String getScore() {
        return this.scores;
    }

    private void setScores(String scores) {
        this.scores = scores;
    }

    public String getWinner() {


        return winner;
    }

    public int findWinner(String scores) {
        if (parseInt(scores.substring(0,1)) > parseInt(scores.substring(2,2))) {
            score.setsPlayer1++;
            findWinner(scores.substring(4, scores.length()));
        } else if (parseInt(scores.substring(0,1)) < parseInt(scores.substring(2,2))) {
            score.setsPlayer2++;
            findWinner(scores.substring(4, scores.length()));
        }

        return 0;
    }

    public void setWinner(String winner) {
        score.setsPlayer2 = 0;
        score.setsPlayer1 = 0;
        if (findWinner(getScore()) > 1) {
            this.winner = this.firstPlayerId;
        } else {
            this.winner = this.secondPlayerId;
        }
    }

    public int getDateMonth() {
        return parseInt(getTennisMatchDate().substring(0,2));
    }

    public int getDateYear() {
        return parseInt(getTennisMatchDate().substring(6,8));
    }

    public int getDateDay() {
        return parseInt(getTennisMatchDate().substring(3,5));
    }

    public void print() {

    }


    @Override
    public int compareTo(TennisMatch o) {
        return 0;
    }
}