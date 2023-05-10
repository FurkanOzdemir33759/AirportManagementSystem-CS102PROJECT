import javax.swing.*;

public class RegularTicket extends Ticket {

    private Passenger passenger;

    public RegularTicket(Plane plane, int sN) {
        super(plane,sN);

    }

    public double getPrice() {
        if (passenger instanceof EconomyPassenger || passenger instanceof BusinessPassenger || passenger == null) {
            return super.getBaseRate();
        } else {
            return super.getBaseRate()*(0.8);
        }
    }

    public void setPassenger(Passenger p) {
        passenger = p;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String toString() {
        return (passenger == null) ? "Seat: " + super.getSeatNumber() + "   " + "Empty"  : "Seat: " + super.getSeatNumber() + "   " + passenger.getFirstName() + " " + passenger.getLastName();
    }
}
