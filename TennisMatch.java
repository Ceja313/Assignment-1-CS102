public class TennisMatch {

    private String firstPlayerId;

    private String secondPlayerId;

    private int tennisMatchDate;

    private String locationOfMatch;

    private String scores;

    private String winner;

    public TennisMatch(String firstPlayerId, String secondPlayerId, int tennisMatchDate
            , String locationOfMatch, String scores) {
        setFirstPlayerId(firstPlayerId);
        setSecondPlayerId(secondPlayerId);
        setTennisMatchDate(tennisMatchDate);
        setLocationOfMatch(locationOfMatch);
        setScores(scores);
    }

    public String getFirstPlayerId() {
        return this.firstPlayerId;
    }

    private void setFirstPlayerId(String firstPlayerId) {
        this.firstPlayerId = firstPlayerId;
    }

    public String getSecondPlayerId() {
        return this.secondPlayerId;
    }

    private void setSecondPlayerId(String secondPlayerId) {
        this.secondPlayerId = secondPlayerId;
    }

    public int getTennisMatchDate() {
        return this.tennisMatchDate;
    }

    private void setTennisMatchDate(int tennisMatchDate) {
        this.tennisMatchDate = tennisMatchDate;
    }

    public String getLocationOfMatch() {
        return this.locationOfMatch;
    }

    private void setLocationOfMatch(String locationOfMatch) {
        this.locationOfMatch = locationOfMatch;
    }

    public String getScores() {
        return this.scores;
    }

    private void setScores(String scores) {
        this.scores = scores;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

}