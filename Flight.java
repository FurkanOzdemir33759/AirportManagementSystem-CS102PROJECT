public class Flight {

    private String departure;
    private String landing;
    private String depDate;
    private String landDate;

    public Flight(String dep, String lan, String depD, String land) {
        departure = dep;
        landing = lan;
        depDate = depD;
        landDate = land;
    }

    public void setLandDate(String landDate) {
        this.landDate = landDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public void setLanding(String landing) {
        this.landing = landing;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getLandDate() {
        return landDate;
    }

    public String getDepDate() {
        return depDate;
    }

    public String getLanding() {
        return landing;
    }

    public String getDeparture() {
        return departure;
    }

    public String toString() {
        return "FLight " + departure + " to " + landing + " on date " + depDate;
    }
}
