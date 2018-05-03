public class TennisPlayer implements TennisPlayerInterface{

    private String Id;

    private String firstName;

    private String lastName;

    private String country;

    //private String winLossRecord;

    private boolean dummy;

    private int year;

    TennisPlayer(String playerId, String firstName, String lastName, int year, String country) {
        setId(playerId);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthYear(year);
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

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getBirthYear() {
        return this.year;
    }

    void setBirthYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return this.country;
    }

    void setCountry(String country) {
        this.country = country;
    }

//    public String getWinLossRecord() {
//        return this.winLossRecord;
//    }
//
//    // Will I want to do the logic here or within the database?
//    private void setWinLossRecord(String winLossRecord) {
//        this.winLossRecord = winLossRecord;
//    }

    public void print() {
        System.out.println("Id: " + getId());
        System.out.println("FirstName: " + getFirstName());
        System.out.println("LastName: " + getLastName());
        System.out.println("Country: " + getCountry());
        // may need to implement this
        //System.out.println("Win Loss Record " + getWinLossRecord());
    }

    boolean isDummy() {
        return dummy;
    }

    void setDummy(boolean dummy) {
        this.dummy = dummy;
    }

    @Override
    public int compareTo(TennisPlayer o) {
        return getId().compareTo(o.getId());
    }
}
