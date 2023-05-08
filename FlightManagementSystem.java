import java.util.ArrayList;

public class FlightManagementSystem {

    private ArrayList<Flight> flightList;

    public FlightManagementSystem() {
        flightList = new ArrayList<>();
    }

    public void addFlight(String dep, String lan, String d1, String d2) {
        flightList.add(new Flight(dep,lan,d1,d2));
        flightList.add(new Flight(lan,dep,d2,d1));
    }

    public ArrayList<Flight> getFlights() {
        return flightList;
    }

    public void removeFlight(Flight f) {
        flightList.remove(f);
    }
}
