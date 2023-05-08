public class Hangar {

    private int code;
    private boolean isReserved;
    private Plane occupation;

    public Hangar(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public Plane getOccupation() {
        return occupation;
    }

    public void setOccupation(Plane p) {
        occupation = p;
        if (p != null) {
            setReserved(true);
        } else {
            setReserved(false);
        }
    }

    public void setReserved(boolean newValue) {
        isReserved = newValue;
    }


    public String toString() {
        return (occupation == null) ? "Hangar " + code + " is empty." : "Hangar " + code + " is being used by " + occupation.toString();
    }
}
