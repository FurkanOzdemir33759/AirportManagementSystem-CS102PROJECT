public class Runway {

    private int code;
    private boolean isUsed;
    private Plane occupation;

    public Runway(int code) {
        this.code = code;
    }

    public void setOccupation(Plane occupation) {
        this.occupation = occupation;
        if (occupation != null) {
            setUsed(true);
        } else {
            setUsed(false);
        }
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public Plane getOccupation() {
        return occupation;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public int getCode() {
        return code;
    }

    public String toString() {
        return (occupation == null) ? "Runway " + code + " is empty." : "Runway " + code + " is reserved by " + occupation.toString();
    }
}
