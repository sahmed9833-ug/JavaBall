package com.saeed;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class RefereeSingleFrame extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel qualificationLabel;
    private JLabel allocationsLabel;
    private JLabel homeLabel;
    private JLabel localitiesLabel;

    //labels for non-editable information
    private JLabel idData;
    private JLabel nameData;
    private JLabel allocationsData;

    //labels
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;

    //textfields for non-editable information, entered when adding referee
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField allocationsField;

    //textfields for editable information
    private JTextField qualificationField;
    private JTextField homeField;
    private JTextField localitiesField;

    //buttons
    private JButton backButton;
    private JButton updateButton;
    private JButton deleteButton;

    private JButton addButton;

    //other variables
    private String idForm = "";


    public RefereeSingleFrame(){
        setTitle("Add new Referee");
        setSize(400, 500);
        setLocation(600, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 5, 10));

        firstNameLabel = new JLabel("First name: ", SwingConstants.CENTER);
        firstNameField = new JTextField("");
        lastNameLabel = new JLabel("Last name: ", SwingConstants.CENTER);
        lastNameField = new JTextField("");
        qualificationLabel = new JLabel("Qualification: ", SwingConstants.CENTER);
        qualificationField = new JTextField("");
        allocationsLabel = new JLabel("Allocations: ", SwingConstants.CENTER);
        allocationsField = new JTextField("");
        homeLabel = new JLabel("Home: ", SwingConstants.CENTER);
        homeField = new JTextField("");
        localitiesLabel = new JLabel("Localities: ", SwingConstants.CENTER);
        localitiesField = new JTextField("");

        backButton = new JButton("Go Back");
        backButton.addActionListener(this);
        addButton = new JButton("Add");
        addButton.addActionListener(this);

        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameField);
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameField);
        mainPanel.add(qualificationLabel);
        mainPanel.add(qualificationField);
        mainPanel.add(allocationsLabel);
        mainPanel.add(allocationsField);
        mainPanel.add(homeLabel);
        mainPanel.add(homeField);
        mainPanel.add(localitiesLabel);
        mainPanel.add(localitiesField);
        mainPanel.add(backButton);
        mainPanel.add(addButton);

        add(mainPanel,"Center");

        setVisible(true);
    }

    public RefereeSingleFrame(String id, String name, String qualification, int allocations, String home, String localities){

        idForm = id;
        setTitle("View Referee");
        setSize(400, 500);
        setLocation(600, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 5, 10));

        idLabel = new JLabel("ID: ", SwingConstants.CENTER);
        idData = new JLabel(id);
        nameLabel = new JLabel("Name: ", SwingConstants.CENTER);
        nameData = new JLabel(name);
        qualificationLabel = new JLabel("Qualification: ", SwingConstants.CENTER);
        qualificationField = new JTextField(qualification);
        allocationsLabel = new JLabel("Allocations: ", SwingConstants.CENTER);
        allocationsData = new JLabel(Integer.toString(allocations));
        homeLabel = new JLabel("Home: ", SwingConstants.CENTER);
        homeField = new JTextField(home);
        localitiesLabel = new JLabel("Localities: ", SwingConstants.CENTER);
        localitiesField = new JTextField(localities);

        backButton = new JButton("Go Back");
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        mainPanel.add(idLabel);
        mainPanel.add(idData);
        mainPanel.add(nameLabel);
        mainPanel.add(nameData);
        mainPanel.add(qualificationLabel);
        mainPanel.add(qualificationField);
        mainPanel.add(allocationsLabel);
        mainPanel.add(allocationsData);
        mainPanel.add(homeLabel);
        mainPanel.add(homeField);
        mainPanel.add(localitiesLabel);
        mainPanel.add(localitiesField);
        mainPanel.add(backButton);
        mainPanel.add(updateButton);
        mainPanel.add(deleteButton);

        add(mainPanel,"Center");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == backButton){
            dispose();
        }
        else if (e.getSource() == addButton){

            if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || qualificationField.getText().isEmpty() || allocationsField.getText().isEmpty() || homeField.getText().isEmpty() || localitiesField.getText().isEmpty()){

                JOptionPane.showMessageDialog(new JFrame(), "One or more fields are empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Test.addNewRef(firstNameField.getText(), lastNameField.getText(), qualificationField.getText(), Integer.parseInt(allocationsField.getText()), homeField.getText(), localitiesField.getText());
                dispose();
            }

        }
        else if (e.getSource() == updateButton){

            if (qualificationField.getText().isEmpty() || homeField.getText().isEmpty() || localitiesField.getText().isEmpty()){

                JOptionPane.showMessageDialog(new JFrame(), "One or more fields are empty.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Test.updateRef(idForm, qualificationField.getText(), homeField.getText(), localitiesField.getText());
                dispose();
            }
        }
        else if (e.getSource() == deleteButton){
            Test.deleteRef(idForm);
            dispose();
        }
    }

}
