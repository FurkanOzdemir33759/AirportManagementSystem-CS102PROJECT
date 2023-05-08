import javax.swing.*;

public class Model {

    private PassengerManagementSystem passengerManagementSystem;
    private PlaneManagementSystem planeManagementSystem;

    private FlightManagementSystem flightManagementSystem;

    private int whichSystemToShow;

    public Model() {
        passengerManagementSystem = new PassengerManagementSystem();
        planeManagementSystem = new PlaneManagementSystem();
        flightManagementSystem = new FlightManagementSystem();
        whichSystemToShow = 0;
    }

    public PassengerManagementSystem getPassengerManagementSystem() {
        return passengerManagementSystem;
    }

    public PlaneManagementSystem getPlaneManagementSystem() {return planeManagementSystem;}

    public FlightManagementSystem getFlightManagementSystem() {return flightManagementSystem;}

    public void setWhichSystemToShow(int systemID) {
        whichSystemToShow = systemID;
    }

    public int getWhichSystemToShow() {
        return whichSystemToShow;
    }

}
