public class VIPTicket extends Ticket{

    private BusinessPassenger businessPassenger;

    public VIPTicket(Plane p, int sN) {
        super(p,sN);
    }

    @Override
    public double getPrice() {
        return getBaseRate()*(1.25)*(super.getPlane().getCapacity() + 1)/(super.getPlane().getCapacity());
    }

    public void setPassenger(Passenger p) {
        businessPassenger = (BusinessPassenger) p;
    }

    public Passenger getPassenger() {
        return businessPassenger;
    }

    public String toString() {
        return (businessPassenger == null) ? "VIP Seat: " + super.getSeatNumber() + "   " + "Empty"  : "VIP Seat: " + super.getSeatNumber() + "   " + businessPassenger.getFirstName() + " " + businessPassenger.getLastName();
    }
}
