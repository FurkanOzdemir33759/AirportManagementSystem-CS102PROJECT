public class EconomyPassenger extends Passenger{

    private String type;

    public EconomyPassenger(String id,String firstName, String lastName, int luggageCount, int yearOfBirth) {
        super(id,firstName,lastName,luggageCount,yearOfBirth);
        type = "Economy";
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Economy Passenger -> " + super.toString();
    }
}
