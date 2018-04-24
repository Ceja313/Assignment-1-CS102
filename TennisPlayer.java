public class TennisPlayer {

    private String Id;

    private String firstName;

    private String lastName;

    private String country;

    private String winLossRecord;

    private int year;

    public TennisPlayer(String playerId, String firstName, String lastName, int year, String country) {
        setId(playerId);
        setFirstName(firstName);
        setLastName(lastName);
        setYear(year);
        setCountry(country);
    }

    public String getId() {
        return this.Id;
    }

    private void setId(String Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return this.year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return this.country;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    public String getWinLossRecord() {
        return this.winLossRecord;
    }

    // Will I want to do the logic here or within the database?
    private void setWinLossRecord(String winLossRecord) {
        this.winLossRecord = winLossRecord;
    }

    public String print() {
        return "What to put";
    }
}