public abstract class Passenger {
    private String ID;

    private String firstName;
    private String lastName;
    private int luggageCount;
    private int yearOfBirth;

    public Passenger(String ID, String firstName, String lastName, int luggageCount, int yearOfBirth) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.luggageCount = luggageCount;
        this.yearOfBirth = yearOfBirth;
    }

    public void setID(String id) {
        ID = id;
    }

    public String getID() {
        return ID;
    }

    public void setFirstName(String newName) {
        firstName = newName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLuggageCount(int newLuggageCount) {
        luggageCount = newLuggageCount;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public void setYearOfBirth(int newYearOfBirth) {
        yearOfBirth = newYearOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public abstract String getType();

    public String toString() {
        return "ID: " + ID + " " + firstName + " " + lastName + " " + yearOfBirth;
    }
}
