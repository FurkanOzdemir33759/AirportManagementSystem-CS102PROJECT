import javax.swing.*;

public class Model {

    private PassengerManagementSystem passengerManagementSystem;
    private PlaneManagementSystem planeManagementSystem;

    private int whichSystemToShow;

    public Model() {
        passengerManagementSystem = new PassengerManagementSystem();
        planeManagementSystem = new PlaneManagementSystem();
        whichSystemToShow = 0;
    }

    public PassengerManagementSystem getPassengerManagementSystem() {
        return passengerManagementSystem;
    }

    public PlaneManagementSystem getPlaneManagementSystem() {return planeManagementSystem;}

    public void setWhichSystemToShow(int systemID) {
        whichSystemToShow = systemID;
    }

    public int getWhichSystemToShow() {
        return whichSystemToShow;
    }

}
