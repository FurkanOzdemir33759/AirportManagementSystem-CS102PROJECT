public class BusinessPassenger extends Passenger {

    private String type;

    public BusinessPassenger(String id, String firstName, String lastName, int luggageCount, int yearOfBirth) {
        super(id,firstName,lastName,luggageCount,yearOfBirth);
        type = "Business";
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "Business Passenger -> " + super.toString();
    }
}
