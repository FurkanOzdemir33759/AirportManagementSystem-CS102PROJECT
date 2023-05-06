public class Plane {

    private String id;
    private boolean available;
    private int capacity;
    private Hangar hangar;
    private Runway runway;

    public Plane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        available = true;
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

    public String toString() {
        return "Plane: " + id + " Availability: " + available + " Capacity: " + capacity;
    }
}
