import java.util.ArrayList;

public class PassengerManagementSystem {

    private ArrayList<Passenger> passengerList;

    public PassengerManagementSystem() {
        passengerList = new ArrayList<>();
    }

    public void addPassenger(Passenger p) {
        passengerList.add(p);
    }

    public void removePassenger(Passenger p) {
        passengerList.remove(p);
    }

    public void removePassenger(int index) {
        passengerList.remove(index);
    }

    public void updatePassengerByID(String id,String name, String surname, String type, int luggageCount, int birthYear) {
        for (int i = 0; i< passengerList.size(); i++) {
            if (id.equals(findID(passengerList.get(i).toString()))) {
                Passenger p = passengerList.get(i);
                if (p.getType().equals(type)) {
                    p.setFirstName(name);
                    p.setLastName(surname);
                    p.setLuggageCount(luggageCount);
                    p.setYearOfBirth(birthYear);
                } else {
                    this.removePassenger(p);
                    if (type.equals("Business")) {
                        p = new BusinessPassenger(id,name,surname,luggageCount,birthYear);
                    } else if (type.equals("Economy")) {
                        p = new EconomyPassenger(id,name,surname,luggageCount,birthYear);
                    } else {
                        p = new FamilyPassenger(id,name,surname,luggageCount,birthYear);
                    }
                    this.addPassenger(p);
                }
            }
        }
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    private String findID(String s) {
        int idIndex = s.indexOf("ID: ");
        idIndex += 4;
        String ID = s.substring(idIndex);
        ID = ID.split(" ")[0];
        return ID;
    }
}
