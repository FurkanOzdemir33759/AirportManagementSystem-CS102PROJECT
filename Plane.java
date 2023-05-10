import java.util.ArrayList;

public class Plane {

    private String id;
    private boolean available;
    private int capacity;
    private Hangar hangar;
    private Runway runway;

    private ArrayList<Ticket> tickets;

    public Plane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        available = true;
        tickets = allocateTicket(capacity);
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean newValue) {
        available = newValue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int cap) {
        capacity = cap;
    }

    public Hangar getHangar() {
        return hangar;
    }

    public void setHangar(Hangar h) {
        hangar = h;
    }

    public Runway getRunway() {
        return runway;
    }

    public void setRunway(Runway r) {
        runway = r;
    }

    private ArrayList<Ticket> allocateTicket(int x) {
        ArrayList<Ticket> ticketArrayList = new ArrayList<>();
        int counter = 0;
        while ((counter * 100)/x <= 20) {
            ticketArrayList.add(new VIPTicket(this, counter));
            counter++;
        }
        while ((counter * 100)/x <= 80) {
            ticketArrayList.add(new RegularTicket(this, counter));
            counter++;
        }
        while (counter < x) {
            ticketArrayList.add(new RegularTicket(this, counter));
            counter++;
        }
        return ticketArrayList;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public String toString() {
        return "Plane: " + id + " Availability: " + available + " Capacity: " + capacity;
    }
}
