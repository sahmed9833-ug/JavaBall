package com.saeed;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RefereeListFrame extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;

    //Close function
    WindowListener exitListener = new WindowListener(){

        @Override
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(
                    null, "Are you sure  you would like to exit?\n Referee list will be saved.",
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
                Main.closeProgram();
                System.exit(0);
            }
        }

        @Override
        public void windowActivated(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowClosed(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowDeactivated(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowDeiconified(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowIconified(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowOpened(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }
    };

    //highPanel containing search fields
    private JPanel highPanel;
    private JLabel searchLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton searchButton;

    //table
    private JTable refTable;

    //lowPanel containing buttons for CRUD functions
    private JPanel lowPanel;
    private JButton addButton;
    private JButton allocateButton;

    //constructor
    public RefereeListFrame(){

        //frame
        setTitle("Referees");
        setSize(900, 500);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(exitListener);

        //higher panel
        highPanel = new JPanel();
        highPanel.setLayout(new GridLayout(0, 4, 5, 10));

        searchLabel = new JLabel("Search: ", SwingConstants.CENTER);
        firstNameField = new JTextField("First Name");
        lastNameField = new JTextField("Last Name");
        searchButton = new JButton("Search");

        add(highPanel, "North");
        highPanel.add(searchLabel);
        highPanel.add(firstNameField);
        highPanel.add(lastNameField);
        highPanel.add(searchButton);
        searchButton.addActionListener(this);

        //table
        refTable = new JTable(Main.refereesTable);
        refTable.setRowSelectionAllowed(true);
        refTable.setDefaultEditor(Object.class, null);

        add(new JScrollPane(refTable), "Center");

        //lower panel
        lowPanel = new JPanel();
        lowPanel.setLayout(new GridLayout(0, 4, 5, 10));

        addButton = new JButton("Add new referee");
        allocateButton = new JButton("Allocate a referee to a match");

        add(lowPanel, "South");

        lowPanel.add(addButton);
        addButton.addActionListener(this);
        lowPanel.add(allocateButton);
        allocateButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        //String selectedRef = String.valueOf(Test.refereesTable.getDataVector().elementAt(refTable.getSelectedRow()));

        if (e.getSource() == addButton){
            System.err.println("Opening add form..");
            new RefereeSingleFrame();
        }
        else if (e.getSource() == allocateButton){
            System.err.println("Opening allocate form..");
            new AllocateFrame();
        }
        else if (e.getSource() == searchButton){

            String fN = firstNameField.getText();
            String lN = lastNameField.getText();

            Main.searchRef(fN, lN);
        }
    }
}
