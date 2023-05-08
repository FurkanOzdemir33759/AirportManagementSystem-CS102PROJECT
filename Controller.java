import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.addChangeMainPanelButtonListener(new ChangeMainPanelListener());
        view.addAddUserButtonListener(new AddUserListener());
        view.addRemoveUserButtonListener(new RemoveUserListener());
        view.addUpdateUserButtonListener(new UpdateUserListener());
        view.addAddPlaneButtonListener(new AddPlaneListener());
        view.addRemovePlaneButtonListener(new RemovePlaneListener());
        view.addAddHangarButtonListener(new AddHangarListener());
        view.addRemoveHangarButtonListener(new RemoveHangarListener());
        view.addAddRunwayButtonListener(new AddRunwayListener());
        view.addRemoveRunwayButtonListener(new RemoveRunwayListener());
        view.addReserveHangarButtonListener(new ReserveHangarListener());
        view.addResetHangarButtonListener(new ResetHangarListener());
        view.addReserveRunwayButtonListener(new ReserveRunwayListener());
        view.addResetRunwayButtonListener(new ResetRunwayListener());
        view.addAddFlightButtonListener(new AddFlightListener());
        view.addRemoveFlightButtonListener(new RemoveFlightListener());
    }

    private class ChangeMainPanelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            String name = src.getName();
            if (name.equals("FMSButton")) {
                model.setWhichSystemToShow(2);
            } else if (name.equals("AMSButton")) {
                model.setWhichSystemToShow(1);
            } else {
                model.setWhichSystemToShow(0);
            }
            view.updateMainView();
        }
    }

    private class AddUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userName = view.getUserName();
            String userSurname = view.getUserSurname();
            String userType = view.getUserType();
            int intUserLuggageCount = -1;
            int intUserYearOfBirth = -1;
            try {
                intUserLuggageCount = Integer.parseInt(view.getUserLuggageCount());
                intUserYearOfBirth = Integer.parseInt(view.getUserYearOfBirth());
                Random random = new Random();
                String id = "P" + random.nextInt(100000, 1000000) + intUserLuggageCount + intUserYearOfBirth + userName.charAt(0) + userSurname.charAt(0);
                if (userType.equals("Business")) {
                    model.getPassengerManagementSystem().addPassenger(new BusinessPassenger(id, userName, userSurname, intUserLuggageCount, intUserYearOfBirth));
                } else if (userType.equals("Economy")) {
                    model.getPassengerManagementSystem().addPassenger(new EconomyPassenger(id, userName, userSurname, intUserLuggageCount, intUserYearOfBirth));
                } else {
                    model.getPassengerManagementSystem().addPassenger(new FamilyPassenger(id, userName, userSurname, intUserLuggageCount, intUserYearOfBirth));
                }
                view.refreshPassengerList();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(view, "Either luggage count or year of birth is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class RemoveUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String IDToBeRemoved = view.getIDFromPassengerList();
            for (int i = 0; i < model.getPassengerManagementSystem().getPassengerList().size(); i++) {
                if (model.getPassengerManagementSystem().getPassengerList().get(i).getID().equals(IDToBeRemoved)) {
                    model.getPassengerManagementSystem().removePassenger(i);
                }
            }
            view.refreshPassengerList();
        }
    }

    private class UpdateUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String IDToBeUpdated = view.getIDFromPassengerList();
            String userName = view.getUserName();
            String userSurname = view.getUserSurname();
            String userType = view.getUserType();
            int intUserLuggageCount = -1;
            int intUserYearOfBirth = -1;
            try {
                intUserLuggageCount = Integer.parseInt(view.getUserLuggageCount());
                intUserYearOfBirth = Integer.parseInt(view.getUserYearOfBirth());
                model.getPassengerManagementSystem().updatePassengerByID(IDToBeUpdated, userName, userSurname, userType, intUserLuggageCount, intUserYearOfBirth);

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(view, "Either luggage count or year of birth is not valid", "Error", JOptionPane.ERROR_MESSAGE);
            }
            view.refreshPassengerList();
        }
    }

    private class AddPlaneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = view.getPlaneCode();
            int capacity = view.getCapacity();
            model.getPlaneManagementSystem().addPlane(new Plane(id, capacity));
            view.refreshPlaneList();
        }
    }

    private class RemovePlaneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = view.getPlaneCodeForRemoval();
            for (int i = 0; i < model.getPlaneManagementSystem().getPlaneList().size(); i++) {
                if (model.getPlaneManagementSystem().getPlaneList().get(i).getId().equals(id)) {
                    model.getPlaneManagementSystem().removePlane(model.getPlaneManagementSystem().getPlaneList().get(i));
                    break;
                }
            }
            for (int i = 0; i < model.getPlaneManagementSystem().getHangarList().size(); i++) {
                if (model.getPlaneManagementSystem().getHangarList().get(i).getOccupation() != null && model.getPlaneManagementSystem().getHangarList().get(i).getOccupation().getId().equals(id)) {
                    model.getPlaneManagementSystem().getHangarList().get(i).setOccupation(null);
                    break;
                }
            }
            for (int i = 0; i < model.getPlaneManagementSystem().getRunwayList().size(); i++) {
                if (model.getPlaneManagementSystem().getRunwayList().get(i).getOccupation() != null && model.getPlaneManagementSystem().getRunwayList().get(i).getOccupation().getId().equals(id)) {
                    model.getPlaneManagementSystem().getRunwayList().get(i).setOccupation(null);
                    break;
                }
            }
            view.refreshPlaneList();
            view.refreshHangarList();
            view.refreshRunwayList();
        }
    }

    private class AddHangarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getHangarID();
            model.getPlaneManagementSystem().addHangar(new Hangar(id));
            view.refreshHangarList();
        }
    }

    private class RemoveHangarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getHangarID();
            model.getPlaneManagementSystem().removeHangarById(id);
            view.refreshHangarList();
        }
    }

    private class AddRunwayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getRunwayID();
            model.getPlaneManagementSystem().addRunway(new Runway(id));
            view.refreshRunwayList();
        }
    }

    private class RemoveRunwayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getRunwayID();
            model.getPlaneManagementSystem().removeRunwayById(id);
            view.refreshRunwayList();
        }
    }

    private class ReserveHangarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getHangarID();
            String planeID = view.getPlaneCodeForRemoval();
            for (int i = 0; i < model.getPlaneManagementSystem().getPlaneList().size(); i++) {
                if (model.getPlaneManagementSystem().getPlaneList().get(i).getId().equals(planeID)) {
                    for (int j = 0; j < model.getPlaneManagementSystem().getHangarList().size(); j++) {
                        if (model.getPlaneManagementSystem().getHangarList().get(j).getCode() == id) {
                            model.getPlaneManagementSystem().getPlaneList().get(i).setHangar(model.getPlaneManagementSystem().getHangarList().get(j));
                            model.getPlaneManagementSystem().getHangarList().get(j).setOccupation(model.getPlaneManagementSystem().getPlaneList().get(i));
                            view.refreshHangarList();
                        }
                    }
                }
            }
        }
    }

    private class ResetHangarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getHangarID();
            for (int i = 0; i < model.getPlaneManagementSystem().getHangarList().size(); i++) {
                if (id == model.getPlaneManagementSystem().getHangarList().get(i).getCode()) {
                    model.getPlaneManagementSystem().getHangarList().get(i).setOccupation(null);
                    view.refreshHangarList();
                    break;
                }
            }
        }
    }

    private class ReserveRunwayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getRunwayID();
            String planeID = view.getPlaneCodeForRemoval();
            for (int i = 0; i < model.getPlaneManagementSystem().getRunwayList().size(); i++) {
                if (id == model.getPlaneManagementSystem().getRunwayList().get(i).getCode()) {
                    for (int j = 0; j < model.getPlaneManagementSystem().getPlaneList().size(); j++) {
                        if (model.getPlaneManagementSystem().getPlaneList().get(j).getId().equals(planeID)) {
                            model.getPlaneManagementSystem().getPlaneList().get(j).setRunway(model.getPlaneManagementSystem().getRunwayList().get(i));
                            model.getPlaneManagementSystem().getRunwayList().get(i).setOccupation(model.getPlaneManagementSystem().getPlaneList().get(j));
                            view.refreshRunwayList();
                        }
                    }
                }
            }
        }
    }

    private class ResetRunwayListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = view.getRunwayID();
            for (int i = 0; i < model.getPlaneManagementSystem().getRunwayList().size(); i++) {
                if (model.getPlaneManagementSystem().getRunwayList().get(i).getCode() == id) {
                    model.getPlaneManagementSystem().getRunwayList().get(i).setOccupation(null);
                    view.refreshRunwayList();
                }
            }
        }
    }

    private class AddFlightListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String dep = view.getDeparture();
            String depD = view.getDepDate();
            String lan = view.getLanding();
            String lanD = view.getLanDate();
            model.getFlightManagementSystem().addFlight(dep,lan,depD,lanD);
            view.refreshFlights();
        }
    }

    private class RemoveFlightListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selected = view.getSelectedFlight();
            String dep = selected.split(" ")[1];
            String lan = selected.split(" ")[3];
            String depD = selected.split(" ")[6];
            ArrayList<Flight> flights = model.getFlightManagementSystem().getFlights();
            for (int i = 0; i < flights.size(); i++) {
                Flight f = flights.get(i);
                if (dep.equals(f.getDeparture()) && lan.equals(f.getLanding()) && depD.equals(f.getDepDate())) {
                    model.getFlightManagementSystem().removeFlight(f);
                }
            }
            view.refreshFlights();
        }
    }
}


