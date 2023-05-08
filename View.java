import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JPanel {

    private Model model;

    private JButton PMSButton, FMSButton, AMSButton;

    private JButton addUser, removeUser, updateUser;

    private JTextField nameField, surnameField, countField, birthField;

    private JList<String> passengerList;

    private JComboBox<String> typeCombo;

    private JButton addPlaneButton, removePlaneButton;

    private JTextField planeCode;

    private JSpinner capacityCount, codeSpinner;

    private JList<String> planeList;

    private JButton addHangarButton, removeHangarButton, addRunwayButton, removeRunwayButton, reserveHangarButton, resetHangarButton, reserveRunwayButton, resetRunwayButton;

    private JTextField hangarCode, runwayCode;

    private JTextArea reserveTextArea, reserveRunwayTextArea;

    private JPanel passenger, plane, flight, currentPanel;
    public View(Model model) {
        this.model = model;

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel navbar = new JPanel();
        navbar.setMaximumSize(new Dimension(1280,40));

        PMSButton = new JButton("Passenger Management System");
        PMSButton.setName("PMSButton");
        FMSButton = new JButton("Flight Management System");
        FMSButton.setName("FMSButton");
        AMSButton = new JButton("Plane Management System");
        AMSButton.setName("AMSButton");

        navbar.add(PMSButton);
        navbar.add(AMSButton);
        navbar.add(FMSButton);

        add(navbar);

        passenger = new JPanel();
        passenger.setBorder(BorderFactory.createTitledBorder("Passenger Management"));
        passenger.setMaximumSize(new Dimension(1280,680));
        passenger.setLayout(new BoxLayout(passenger,BoxLayout.Y_AXIS));

            JPanel allPassengers = new JPanel();
            allPassengers.setBorder(BorderFactory.createTitledBorder("All Passengers"));
            allPassengers.setMaximumSize(new Dimension(1280,280));
            passenger.add(allPassengers);

                passengerList = new JList<>() ;
                passengerList.setPreferredSize(new Dimension(1200,240));
                allPassengers.add(passengerList);


            JPanel createANewUser = new JPanel();
            createANewUser.setBorder(BorderFactory.createTitledBorder("Create A New User"));
            createANewUser.setMaximumSize(new Dimension(1280,200));
            passenger.add(createANewUser);

                JPanel inputAreaContainer = new JPanel();
                inputAreaContainer.setLayout(new BoxLayout(inputAreaContainer,BoxLayout.X_AXIS));
                inputAreaContainer.setMaximumSize(new Dimension(1280,200));
                createANewUser.add(inputAreaContainer);

                    JPanel namePanel = new JPanel();
                    namePanel.setPreferredSize(new Dimension(240,70));
                    namePanel.setLayout(new BorderLayout());

                        JLabel nameLabel = new JLabel("Name:");
                        nameLabel.setPreferredSize(new Dimension(240,40));
                        namePanel.add(nameLabel,BorderLayout.NORTH);
                        nameField = new JTextField();
                        nameField.setPreferredSize(new Dimension(240,30));
                        namePanel.add(nameField,BorderLayout.SOUTH);

                    inputAreaContainer.add(namePanel);

                    JPanel surnamePanel = new JPanel();
                    surnamePanel.setPreferredSize(new Dimension(240,70));
                    surnamePanel.setLayout(new BorderLayout());

                        JLabel surnameLabel = new JLabel("Surname:");
                        surnameLabel.setPreferredSize(new Dimension(240,40));
                        surnamePanel.add(surnameLabel,BorderLayout.NORTH);
                        surnameField = new JTextField();
                        surnameField.setPreferredSize(new Dimension(240,30));
                        surnamePanel.add(surnameField,BorderLayout.SOUTH);

                    inputAreaContainer.add(surnamePanel);

                    JPanel typePanel = new JPanel();
                    typePanel.setPreferredSize(new Dimension(240,70));
                    typePanel.setLayout(new BorderLayout());

                        JLabel typeLabel = new JLabel("Passenger Type:");
                        typeLabel.setPreferredSize(new Dimension(240,40));
                        typePanel.add(typeLabel,BorderLayout.NORTH);
                        String[] comboBoxOptions = {"Business","Economy","Family"};
                        typeCombo = new JComboBox<>(comboBoxOptions);
                        typeCombo.setPreferredSize(new Dimension(240,30));
                        typePanel.add(typeCombo,BorderLayout.SOUTH);

                    inputAreaContainer.add(typePanel);

                    JPanel countPanel = new JPanel();
                    countPanel.setPreferredSize(new Dimension(240,70));
                    countPanel.setLayout(new BorderLayout());

                        JLabel countLabel = new JLabel("Luggage Count:");
                        countLabel.setPreferredSize(new Dimension(240,40));
                        countPanel.add(countLabel,BorderLayout.NORTH);
                        countField = new JTextField();
                        countField.setPreferredSize(new Dimension(240,30));
                        countPanel.add(countField,BorderLayout.SOUTH);

                    inputAreaContainer.add(countPanel);

                    JPanel birthPanel = new JPanel();
                    birthPanel.setPreferredSize(new Dimension(240,70));
                    birthPanel.setLayout(new BorderLayout());

                        JLabel birthLabel = new JLabel("Year of Birth:");
                        birthLabel.setPreferredSize(new Dimension(240,40));
                        birthPanel.add(birthLabel,BorderLayout.NORTH);
                        birthField = new JTextField();
                        birthField.setPreferredSize(new Dimension(240,30));
                        birthPanel.add(birthField,BorderLayout.SOUTH);

                    inputAreaContainer.add(birthPanel);

            JPanel buttonContainer = new JPanel();
            buttonContainer.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            buttonContainer.setMaximumSize(new Dimension(1280,200));
            passenger.add(buttonContainer);

                addUser = new JButton("Add User");
                addUser.setPreferredSize(new Dimension(1240,66));
                c.gridx = 0; c.gridy = 0; c.weighty = 0.33;
                buttonContainer.add(addUser,c);
                removeUser = new JButton("Remove User");
                removeUser.setPreferredSize(new Dimension(1240,66));
                c.gridx = 0; c.gridy = 1; c.weighty = 0.33;
                buttonContainer.add(removeUser,c);
                updateUser = new JButton("Update User");
                updateUser.setPreferredSize(new Dimension(1240,66));
                c.gridx = 0; c.gridy = 2; c.weighty = 0.33;
                buttonContainer.add(updateUser,c);




        plane = new JPanel();
        plane.setBorder(BorderFactory.createTitledBorder("Plane Management"));
        plane.setMaximumSize(new Dimension(1280,680));
        BoxLayout boxLayout2 = new BoxLayout(plane,BoxLayout.Y_AXIS);
        plane.setLayout(boxLayout2);


            planeList = new JList<>();
            planeList.setMaximumSize(new Dimension(1280,230));
            planeList.setMinimumSize(new Dimension(1280,230));
            planeList.setPreferredSize(new Dimension(1280,230));
            plane.add(planeList);

            JPanel addPlaneContainer = new JPanel();
            plane.add(addPlaneContainer);

                planeCode = new JTextField();
                planeCode.setPreferredSize(new Dimension(200,30));
                addPlaneContainer.add(planeCode);
                addPlaneButton = new JButton("Add Plane");
                addPlaneButton.setPreferredSize(new Dimension(200,29));
                addPlaneContainer.add(addPlaneButton);
                JLabel capacity = new JLabel("Capacity:");
                addPlaneContainer.add(capacity);
                capacityCount = new JSpinner();
                Integer[] capacityModel = new Integer[250];
                for (int i = 1; i <= 250; i++) {
                    capacityModel[i-1] = i;
                }
                SpinnerListModel capModel = new SpinnerListModel(capacityModel);
                capacityCount.setModel(capModel);
                capacityCount.setPreferredSize(new Dimension(80,30));
                addPlaneContainer.add(capacityCount);


            JPanel removePlaneContainer = new JPanel();
            plane.add(removePlaneContainer);

                codeSpinner = new JSpinner();
                codeSpinner.setPreferredSize(new Dimension(200,30));
                removePlaneContainer.add(codeSpinner);
                removePlaneButton  = new JButton("Remove Plane");
                removePlaneButton.setPreferredSize(new Dimension(200,29));
                removePlaneContainer.add(removePlaneButton);

            JPanel airport = new JPanel();
            airport.setBorder(BorderFactory.createTitledBorder("Airport"));
            airport.setPreferredSize(new Dimension(1280,230));
            BoxLayout boxLayout1 = new BoxLayout(airport,BoxLayout.Y_AXIS);
            airport.setLayout(boxLayout1);
            plane.add(airport);

                JPanel hangarContainer = new JPanel();
                airport.add(hangarContainer);

                    hangarCode = new JTextField();
                    hangarCode.setPreferredSize(new Dimension(400,58));
                    hangarContainer.add(hangarCode);
                    addHangarButton = new JButton("Add Hangar");
                    addHangarButton.setPreferredSize(new Dimension(400,57));
                    hangarContainer.add(addHangarButton);
                    removeHangarButton = new JButton("Remove Hangar");
                    removeHangarButton.setPreferredSize(new Dimension(400,57));
                    hangarContainer.add(removeHangarButton);

                JPanel runwayContainer = new JPanel();
                airport.add(runwayContainer);

                    runwayCode = new JTextField();
                    runwayCode.setPreferredSize(new Dimension(400,58));
                    runwayContainer.add(runwayCode);
                    addRunwayButton = new JButton("Add Runway");
                    addRunwayButton.setPreferredSize(new Dimension(400,57));
                    runwayContainer.add(addRunwayButton);
                    removeRunwayButton = new JButton("Remove Runway");
                    removeRunwayButton.setPreferredSize(new Dimension(400,57));
                    runwayContainer.add(removeRunwayButton);

                JPanel reserveHangarContainer = new JPanel();
                airport.add(reserveHangarContainer);

                    reserveTextArea = new JTextArea();
                    reserveTextArea.setPreferredSize(new Dimension(400,58));
                    reserveHangarContainer.add(reserveTextArea);
                    reserveHangarButton = new JButton("Reserve Hangar");
                    reserveHangarButton.setPreferredSize(new Dimension(400,57));
                    reserveHangarContainer.add(reserveHangarButton);
                    resetHangarButton = new JButton("Reset Hangar");
                    resetHangarButton.setPreferredSize(new Dimension(400,57));
                    reserveHangarContainer.add(resetHangarButton);

                JPanel reserveRunwayContainer = new JPanel();
                airport.add(reserveRunwayContainer);

                    reserveRunwayTextArea = new JTextArea();
                    reserveRunwayTextArea.setPreferredSize(new Dimension(400,58));
                    reserveRunwayContainer.add(reserveRunwayTextArea);
                    reserveRunwayButton = new JButton("Reserve Runway");
                    reserveRunwayButton.setPreferredSize(new Dimension(400,57));
                    reserveRunwayContainer.add(reserveRunwayButton);
                    resetRunwayButton = new JButton("Reset Runway");
                    resetRunwayButton.setPreferredSize(new Dimension(400,57));
                    reserveRunwayContainer.add(resetRunwayButton);


        flight = new JPanel();
        flight.setPreferredSize(new Dimension(1280,680));
        flight.setBorder(BorderFactory.createTitledBorder("Flight Management"));
        BoxLayout boxLayout3 = new BoxLayout(flight,BoxLayout.X_AXIS);
        flight.setLayout(boxLayout3);

            JPanel generateFlight = new JPanel();
            generateFlight.setBorder(BorderFactory.createTitledBorder("Generate Flight"));
            generateFlight.setMaximumSize(new Dimension(400,240));
            generateFlight.setLayout(new BoxLayout(generateFlight,BoxLayout.Y_AXIS));
            flight.add(generateFlight);

                JPanel generateFlightLabelContainer = new JPanel();
                generateFlightLabelContainer.setMaximumSize(new Dimension(390,30));
                generateFlight.add(generateFlightLabelContainer);

                    JLabel departure = new JLabel("Departure:");
                    generateFlightLabelContainer.add(departure);
                    JLabel landing = new JLabel("Landing:");
                    generateFlightLabelContainer.add(landing);
                    JLabel departureDate = new JLabel("Departure Date:");
                    generateFlightLabelContainer.add(departureDate);
                    JLabel returnDate = new JLabel("Return Date:");
                    generateFlightLabelContainer.add(returnDate);

                JPanel generateFlightTextFieldContainer = new JPanel();
                generateFlight.add(generateFlightTextFieldContainer);

                    JTextField departureField = new JTextField();
                    departureField.setPreferredSize(new Dimension(70,30));
                    generateFlightTextFieldContainer.add(departureField);
                    JTextField landingField = new JTextField();
                    landingField.setPreferredSize(new Dimension(70,30));
                    generateFlightTextFieldContainer.add(landingField);
                    JTextField departureDateField = new JTextField();
                    departureDateField.setPreferredSize(new Dimension(70,30));
                    generateFlightTextFieldContainer.add(departureDateField);
                    JTextField landingDateField = new JTextField();
                    landingDateField.setPreferredSize(new Dimension(70,30));
                    generateFlightTextFieldContainer.add(landingDateField);

                JPanel generateFlightButtonContainer = new JPanel();
                generateFlight.add(generateFlightButtonContainer);

                    JButton addFlight = new JButton("Add Flight");
                    addFlight.setPreferredSize(new Dimension(150,30));
                    generateFlightButtonContainer.add(addFlight);
                    JButton removeFlight = new JButton("Remove Flight");
                    removeFlight.setPreferredSize(new Dimension(150,30));
                    generateFlightButtonContainer.add(removeFlight);

            JPanel currentFlights = new JPanel();
            currentFlights.setBorder(BorderFactory.createTitledBorder("Current Flights"));
            currentFlights.setMaximumSize(new Dimension(420,300));
            flight.add(currentFlights);

                JList<String> currentFlightsList = new JList<>();
                currentFlightsList.setPreferredSize(new Dimension(350,250));
                currentFlightsList.setMaximumSize(new Dimension(350,250));
                currentFlightsList.setMinimumSize(new Dimension(350,250));
                currentFlights.add(currentFlightsList);

            JPanel manageTickets = new JPanel();
            manageTickets.setBorder(BorderFactory.createTitledBorder("Manage Tickets"));
            manageTickets.setMaximumSize(new Dimension(460,600));
            flight.add(manageTickets);

                JList<String> ticketList = new JList<>();
                ticketList.setPreferredSize(new Dimension(400,250));
                manageTickets.add(ticketList);

                JPanel buyTicketPanel = new JPanel();
                buyTicketPanel.setPreferredSize(new Dimension(400,300));
                BoxLayout boxLayout4 = new BoxLayout(buyTicketPanel,BoxLayout.Y_AXIS);
                buyTicketPanel.setLayout(boxLayout4);
                manageTickets.add(buyTicketPanel);

                    JPanel buyTicketLabelContainer = new JPanel();
                    buyTicketLabelContainer.setMaximumSize(new Dimension(400,150));
                    buyTicketPanel.add(buyTicketLabelContainer);

                        JLabel passengerIDLabel = new JLabel("Passenger ID:");
                        passengerIDLabel.setVerticalAlignment(JLabel.BOTTOM);
                        passengerIDLabel.setPreferredSize(new Dimension(120,130));
                        buyTicketLabelContainer.add(passengerIDLabel);
                        JLabel emptyLabel = new JLabel();
                        emptyLabel.setPreferredSize(new Dimension(90,150));
                        buyTicketLabelContainer.add(emptyLabel);
                        JLabel ticketPriceLabel = new JLabel("Ticket Price:");
                        ticketPriceLabel.setPreferredSize(new Dimension(75,150));
                        buyTicketLabelContainer.add(ticketPriceLabel);
                        JLabel ticketPriceTag = new JLabel("15.43TL");
                        ticketPriceTag.setPreferredSize(new Dimension(75,150));
                        buyTicketLabelContainer.add(ticketPriceTag);

                    JPanel buyTicketButtonContainer = new JPanel();
                    buyTicketButtonContainer.setMaximumSize(new Dimension(400,150));
                    buyTicketPanel.add(buyTicketButtonContainer);

                        JTextField passengerIDField = new JTextField();
                        passengerIDField.setPreferredSize(new Dimension(120,30));
                        buyTicketButtonContainer.add(passengerIDField);
                        JButton buyTicketButton = new JButton("Buy Ticket");
                        buyTicketButton.setPreferredSize(new Dimension(120,30));
                        buyTicketButtonContainer.add(buyTicketButton);
                        JButton cancelTicketButton = new JButton("Cancel Ticket");
                        cancelTicketButton.setPreferredSize(new Dimension(120,30));
                        buyTicketButtonContainer.add(cancelTicketButton);

        currentPanel = pickMainPanel(model.getWhichSystemToShow());
        add(currentPanel);



        setVisible(true);
    }

    public void addChangeMainPanelButtonListener(ActionListener listener) {
        FMSButton.addActionListener(listener);
        AMSButton.addActionListener(listener);
        PMSButton.addActionListener(listener);
    }

    public void addAddUserButtonListener(ActionListener listener) {
        addUser.addActionListener(listener);
    }

    public void addRemoveUserButtonListener(ActionListener listener) {
        removeUser.addActionListener(listener);
    }

    public void addUpdateUserButtonListener(ActionListener listener) {
        updateUser.addActionListener(listener);
    }

    public void addAddPlaneButtonListener(ActionListener listener) {
        addPlaneButton.addActionListener(listener);
    }

    public void addRemovePlaneButtonListener(ActionListener listener) {
        removePlaneButton.addActionListener(listener);
    }

    public void addAddHangarButtonListener(ActionListener listener) {
        addHangarButton.addActionListener(listener);
    }

    public void addRemoveHangarButtonListener(ActionListener listener) {
        removeHangarButton.addActionListener(listener);
    }

    public void addAddRunwayButtonListener(ActionListener listener) {
        addRunwayButton.addActionListener(listener);
    }

    public void addRemoveRunwayButtonListener(ActionListener listener) {
        removeRunwayButton.addActionListener(listener);
    }

    public void addReserveHangarButtonListener(ActionListener listener) {
        reserveHangarButton.addActionListener(listener);
    }

    public void addResetHangarButtonListener(ActionListener listener) {
        resetHangarButton.addActionListener(listener);
    }

    public void addReserveRunwayButtonListener(ActionListener listener) {
        reserveRunwayButton.addActionListener(listener);
    }

    public void addResetRunwayButtonListener(ActionListener listener) {
        resetRunwayButton.addActionListener(listener);
    }

    private JPanel pickMainPanel(int SystemID) {
        if (SystemID == 0) {
            return passenger;
        } else if (SystemID == 1) {
            return plane;
        } else {
            return flight;
        }
    }

    public void refreshPassengerList() {
        String[] passengersAsStringArray = new String[model.getPassengerManagementSystem().getPassengerList().size()];
        for (int i = 0; i < model.getPassengerManagementSystem().getPassengerList().size(); i++) {
            Passenger p = model.getPassengerManagementSystem().getPassengerList().get(i);
            if (p instanceof BusinessPassenger) {
                passengersAsStringArray[i] = ((BusinessPassenger) p).toString();
            } else if (p instanceof EconomyPassenger) {
                passengersAsStringArray[i] = ((EconomyPassenger) p).toString();
            } else if (p instanceof FamilyPassenger) {
                passengersAsStringArray[i] = ((FamilyPassenger) p).toString();
            }
        }
        passengerList.setListData(passengersAsStringArray);
        revalidate();
        repaint();
    }

    public void refreshPlaneList() {
        String[] planesAsStringArray = new String[model.getPlaneManagementSystem().getPlaneList().size()];
        String[] planeNames = new String[model.getPlaneManagementSystem().getPlaneList().size()];
        for (int i = 0; i < planesAsStringArray.length; i++) {
            Plane p = model.getPlaneManagementSystem().getPlaneList().get(i);
            planesAsStringArray[i] = p.toString();
            planeNames[i] = p.getId();
        }
        if (planeNames.length == 0) {
            planeNames = new String[]{""};
        }
        codeSpinner.setModel(new SpinnerListModel(planeNames));
        planeList.setListData(planesAsStringArray);
        revalidate();
        repaint();
    }

    public void refreshHangarList() {
        ArrayList<Hangar> hangarList = model.getPlaneManagementSystem().getHangarList();
        String hangars = "";
        for (int i = 0; i < hangarList.size(); i++) {
            hangars = hangars + hangarList.get(i).toString() + "\n";
        }
        reserveTextArea.setText(hangars);
        revalidate();
        repaint();
    }

    public void refreshRunwayList() {
        ArrayList<Runway> runwayList = model.getPlaneManagementSystem().getRunwayList();
        String runways = "";
        for (int i = 0; i < runwayList.size(); i++) {
            runways = runways + runwayList.get(i).toString() + "\n";
        }
        reserveRunwayTextArea.setText(runways);
        revalidate();
        repaint();
    }

    public String getPlaneCodeForRemoval() {
        return (String) codeSpinner.getValue();
    }

    public String getIDFromPassengerList() {
        return findID(passengerList.getSelectedValue());
    }

    public int getHangarID() {
        return Integer.parseInt(hangarCode.getText());
    }

    public int getRunwayID() {
        return Integer.parseInt(runwayCode.getText());
    }

    private String findID(String s) {
        int idIndex = s.indexOf("ID: ");
        idIndex += 4;
        String ID = s.substring(idIndex);
        ID = ID.split(" ")[0];
        return ID;
    }

    public String getUserName() {
        return nameField.getText();
    }

    public String getUserSurname() {
        return surnameField.getText();
    }

    public String getUserType() {
        return typeCombo.getSelectedItem().toString();
    }

    public String getUserLuggageCount() {
        return countField.getText();
    }

    public String getUserYearOfBirth() {
        return birthField.getText();
    }

    public String getPlaneCode() {
        return planeCode.getText();
    }

    public int getCapacity() {
        return Integer.parseInt(capacityCount.getValue().toString());
    }


    public void updateMainView() {
        remove(currentPanel);
        currentPanel = pickMainPanel(model.getWhichSystemToShow());
        add(currentPanel);
        revalidate();
        repaint();
    }
}
