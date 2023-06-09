import java.util.ArrayList;

public class PlaneManagementSystem {

    private ArrayList<Plane> planeList;

    private ArrayList<Hangar> hangarList;

    private ArrayList<Runway> runwayList;

    public PlaneManagementSystem() {
        planeList = new ArrayList<>();
        hangarList = new ArrayList<>();
        runwayList = new ArrayList<>();
    }

    public void addPlane(Plane p) {
        planeList.add(p);
    }

    public void removePlane(Plane p) {
        planeList.remove(p);
    }

    public ArrayList<Plane> getPlaneList() {
        return planeList;
    }

    public void addHangar(Hangar h) {
        hangarList.add(h);
    }


    public void removeHangarById(int id) {
        for (int i = 0; i < hangarList.size(); i++) {
            if (hangarList.get(i).getCode() == id) {
                hangarList.remove(i);
            }
        }
    }

    public ArrayList<Hangar> getHangarList() {
        return hangarList;
    }

    public void addRunway(Runway r) {
        runwayList.add(r);
    }

    public void removeRunwayById(int id) {
        for (int i = 0; i < runwayList.size(); i++) {
            if (runwayList.get(i).getCode() == id) {
                runwayList.remove(i);
            }
        }
    }

    public ArrayList<Runway> getRunwayList() {
        return runwayList;
    }
}
