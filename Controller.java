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
    }

    private class ChangeMainPanelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton src =(JButton) e.getSource();
            String name = src.getName();
            if (name.equals("FMSButton")) {
                model.setWhichSystemToShow(2);
            } else if(name.equals("AMSButton")) {
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
                String id = "P" + random.nextInt(100000,1000000) + intUserLuggageCount + intUserYearOfBirth + userName.charAt(0) + userSurname.charAt(0);
                if (userType.equals("Business")) {
                    model.getPassengerManagementSystem().addPassenger(new BusinessPassenger(id,userName,userSurname,intUserLuggageCount,intUserYearOfBirth));
                } else if (userType.equals("Economy")) {
                    model.getPassengerManagementSystem().addPassenger(new EconomyPassenger(id,userName,userSurname,intUserLuggageCount,intUserYearOfBirth));
                } else {
                    model.getPassengerManagementSystem().addPassenger(new FamilyPassenger(id,userName,userSurname,intUserLuggageCount,intUserYearOfBirth));
                }
                view.refreshPassengerList(model.getPassengerManagementSystem().getPassengerList());
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(view,"Either luggage count or year of birth is not valid","Error",JOptionPane.ERROR_MESSAGE);
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
            view.refreshPassengerList(model.getPassengerManagementSystem().getPassengerList());
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
                model.getPassengerManagementSystem().updatePassengerByID(IDToBeUpdated,userName,userSurname,userType,intUserLuggageCount,intUserYearOfBirth);

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(view,"Either luggage count or year of birth is not valid","Error",JOptionPane.ERROR_MESSAGE);
            }
            view.refreshPassengerList(model.getPassengerManagementSystem().getPassengerList());
        }
    }

    private class AddPlaneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = view.getPlaneCode();
            int capacity = view.getCapacity();
            model.getPlaneManagementSystem().addPlane(new Plane(id,capacity));
            view.refreshPlaneList();
        }
    }

    private class RemovePlaneListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = view.getPlaneCodeForRemoval();
            System.out.println(id);
            for (int i = 0; i < model.getPlaneManagementSystem().getPlaneList().size(); i++) {
                if (model.getPlaneManagementSystem().getPlaneList().get(i).getId().equals(id)) {
                    model.getPlaneManagementSystem().removePlane(model.getPlaneManagementSystem().getPlaneList().get(i));
                }
            }
            view.refreshPlaneList();
        }
    }
}
