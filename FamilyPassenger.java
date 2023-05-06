public class FamilyPassenger extends Passenger {

    private String type;

    public FamilyPassenger(String id,String firstName, String lastName, int luggageCount, int yearOfBirth) {
        super(id,firstName,lastName,luggageCount,yearOfBirth);
        type = "Family";
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Family Passenger -> " + super.toString();
    }
}
