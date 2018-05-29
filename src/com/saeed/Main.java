package com.saeed;

import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main {

    public static ArrayList<Referee> referees = new ArrayList<Referee>();

    public static String columns[] = {"ID", "Name", "Qualification", "Allocations", "Home", "Localities"};
    public static DefaultTableModel refereesTable = new DefaultTableModel(columns, 0);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.err.println("Hello World");

        FileReader reader;
        try{
            reader = new FileReader("RefereesIn.txt");
            System.err.println("File opened");

            Scanner in = new Scanner(reader);

            while(in.hasNextLine()){
                String[] string = in.nextLine().trim().split("\\s+");
                referees.add(new Referee(string[0],string[1] + " "+ string[2], string[3], Integer.parseInt(string[4]), string[5], string[6]));
            }
            in.close();

        }
        catch(IOException e){
            System.err.println("Problem with file.");
        }

        populateRefTable();

        new RefereeListFrame();
    }

    public static void populateRefTable(){

        refereesTable.setRowCount(0);
        System.err.println("Populating table..");
        for (Referee r : referees){

            Object[] refData  = {r.getId(), r.getName(), r.getQualification(), r.getAllocations(), r.getHome(), r.getLocalities()};

            refereesTable.addRow(refData);
        }
    }

    public static void searchRef(String fN, String lN){

        System.err.println("Searching..");
        boolean refFound = false;

        for (Referee r: referees){
            if (r.getName().contentEquals(fN + " " + lN)){
                System.err.println("Referee found!");
                refFound = true;
                new RefereeSingleFrame(r.getId(), r.getName(), r.getQualification(), r.getAllocations(), r.getHome(), r.getLocalities());
            }
        }
        if (!refFound){
            System.err.println("Referee not found.");
            JOptionPane.showMessageDialog(new JFrame(), "A referee with that name could not be found.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void addNewRef(String firstName, String lastName, String qualification, int allocations, String home, String localities){

        System.err.println("Adding referee..");
        if (!(referees.size() < 12)){
            JOptionPane.showMessageDialog(new JFrame(), "Referee list is full.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("ArrayList full");
        }

        String id = firstName.substring(0, 1) + lastName.substring(0, 1);

        //check that id doesn't match any others
        int i = 1;
        boolean idMatch = false;
        boolean inputValid = true;
        String errorType = "";
        for (Referee r : referees){
            while ((id + i).contentEquals(r.getId())){
                idMatch = true;
                i++;
            }
        }
        idMatch = false;

        if (!idMatch){
            id = id + i;
        }

        //validation
        if (firstName.matches(".*\\d+.*") || lastName.matches(".*\\d+.*")){
            inputValid = false;
            errorType = errorType + "Name, ";
        }
        if (!qualification.contains("IJB") && !qualification.contains("NJB")){
            inputValid = false;
            errorType = errorType + "Qualification, ";
        }
        if (!home.contains("North") && !home.contains("Central") && !home.contains("South")){
            inputValid = false;
            errorType = errorType + "Home, ";
        }
        if (!localities.contains("Y") && !localities.contains("N")){
            inputValid = false;
            errorType = errorType + "Localities, ";
        }

        //validation actions
        if (inputValid){
            referees.add(new Referee(id, firstName + " " + lastName, qualification, allocations, home, localities));
            populateRefTable();
            System.err.println("New referee added!");
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Could not add referee. \nFollwing field(s) invalid: " + errorType, "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error in the following fields: " + errorType);
        }

    }

    public static void updateRef(String id, String qualification, String home, String localities){

        System.err.println("Updating referee..");
        boolean refFound = false;
        boolean inputValid = true;
        String errorType = "";
        for (Referee r : referees){

            if (id.contentEquals(r.getId())){

                //validation
                if (!qualification.contains("IJB") && !qualification.contains("NJB")){
                    inputValid = false;
                    errorType = errorType + "Qualification, ";
                }
                if (!home.contains("North") && !home.contains("Central") && !home.contains("South")){
                    inputValid = false;
                    errorType = errorType + "Home, ";
                }
                if (!localities.contains("Y") && !localities.contains("N")){
                    inputValid = false;
                    errorType = errorType + "Localities, ";
                }

                //validation actions
                if (inputValid){
                    r.setQualification(qualification);
                    r.setHome(home);
                    r.setLocalities(localities);
                    refFound = true;
                    System.err.println("Referee updated!");
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Could not update referee. \nFollowing field(s) invalid: " + errorType, "Error", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Error in the following fields: " + errorType);
                }

            }
        }
        if (!refFound){
            System.err.println("There was an error updating");
        }

        populateRefTable();
    }

    public static void deleteRef(String id){

        System.err.println("Deleting referee..");
        boolean refFound = false;
        int refIndex = 0;
        for (Referee r : referees){

            if (id.contentEquals(r.getId())){
                refFound = true;
                refIndex = referees.indexOf(r);
                System.err.println("Referee deleted!");
            }
        }
        if (!refFound){
            System.err.println("There was an error deleting");
        }
        else{
            referees.remove(refIndex);
        }
        populateRefTable();
    }

    public static void closeProgram(){


        System.err.println("Closing..");
        try {
            PrintWriter writer = new PrintWriter("RefereesOut.txt");

            for (Referee r : referees){
                writer.println(r.getId() + " " + r.getName() + " " + r.getQualification() + " " + r.getAllocations() + " " + r.getHome() + " " + r.getLocalities());

            }
            writer.close();
        }
        catch(FileNotFoundException x){
            System.err.println("File not found");
        }
    }
}
