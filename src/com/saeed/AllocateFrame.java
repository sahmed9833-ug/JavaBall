package com.saeed;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class AllocateFrame extends JFrame implements ActionListener {


    private static final long serialVersionUID = 1L;

    String currentLevel = "";
    String currentArea = "";

    private JPanel mainPanel;

    //labels
    private JLabel weekLabel;
    private JLabel areaLabel;
    private JLabel levelLabel;
    private JLabel referee1Label;
    private JLabel referee2Label;

    //text fields
    private JTextField weekField;

    //combo-boxes
    private JComboBox<Object> areaBox;
    private JComboBox<Object> levelBox;
    private JComboBox<Object> referee1Box;
    private JComboBox<Object> referee2Box;

    //buttons
    private JButton backButton;
    private JButton allocateButton;

    public AllocateFrame() {

        String[] areas = {"North", "Center", "South"};
        String[] levels = {"Junior", "Senior"};


        setTitle("Add new match");
        setSize(350, 250);
        setLocation(600, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 5, 10));

        weekLabel = new JLabel("Week: ", SwingConstants.CENTER);
        areaLabel = new JLabel("Area: ", SwingConstants.CENTER);
        levelLabel = new JLabel("Level: ", SwingConstants.CENTER);
        referee1Label = new JLabel("Referee 1: ", SwingConstants.CENTER);
        referee2Label = new JLabel("Referee 2: ", SwingConstants.CENTER);

        weekField = new JTextField("1-52");

        areaBox = new JComboBox<Object>(areas);
        areaBox.addActionListener(this);
        levelBox = new JComboBox<Object>(levels);
        areaBox.addActionListener(this);
        referee1Box = new JComboBox<Object>();
        referee2Box = new JComboBox<Object>();

        backButton = new JButton("Go back");
        backButton.addActionListener(this);
        allocateButton = new JButton("Add match");
        allocateButton.addActionListener(this);

        add(mainPanel, "Central");

        mainPanel.add(weekLabel);
        mainPanel.add(weekField);
        mainPanel.add(levelLabel);
        mainPanel.add(levelBox);
        mainPanel.add(areaLabel);
        mainPanel.add(areaBox);
        mainPanel.add(referee1Label);
        mainPanel.add(referee1Box);
        mainPanel.add(referee2Label);
        mainPanel.add(referee2Box);
        mainPanel.add(backButton);
        mainPanel.add(allocateButton);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == backButton) {
            dispose();
        } else if (e.getSource() == levelBox) {

            currentLevel = String.valueOf(levelBox.getSelectedItem());
            System.err.println(currentLevel);

        } else if (e.getSource() == areaBox) {

            currentArea = String.valueOf(areaBox.getSelectedItem());
            System.err.println(currentArea);

        }
    }

    /**
     * This method takes the current ArrayList of referees and currently entered level/area data to produce
     * produce new ArrayList of suggested referees
     **/
    private ArrayList<Referee> getSuggestedRefs(ArrayList<Referee> currentRefs, String selectedLevel, String selectedArea) {
        ArrayList<Referee> suggestedRefs = new ArrayList<>();

        for (Referee r : currentRefs) {
            //insert magic
        }
        return suggestedRefs;
    }

}
