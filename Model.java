import javax.swing.*;

public class Model {

    private PassengerManagementSystem passengerManagementSystem;
    private PlaneManagementSystem planeManagementSystem;

    private FlightManagementSystem flightManagementSystem;

    private Plane selectedPlane;

    private double ticketPrice;

    private int whichSystemToShow;

    public Model() {
        passengerManagementSystem = new PassengerManagementSystem();
        planeManagementSystem = new PlaneManagementSystem();
        flightManagementSystem = new FlightManagementSystem();
        selectedPlane = null;
        ticketPrice = 0.0;
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

    public void setSelectedPlane(Plane p) {
        selectedPlane = p;
    }

    public Plane getSelectedPlane() {
        return selectedPlane;
    }

    public void setTicketPrice(double d) {
        ticketPrice = d;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getWhichSystemToShow() {
        return whichSystemToShow;
    }

}
