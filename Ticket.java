public abstract class Ticket implements TicketInterface{

    private Plane plane;
    private int seatNumber;

    private double baseRate;

    public Ticket(Plane p, int s) {
        plane = p;
        seatNumber = s;
        baseRate = 873.75;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public Plane getPlane() {
        return plane;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public abstract Passenger getPassenger();
    public abstract void setPassenger(Passenger p);
}
