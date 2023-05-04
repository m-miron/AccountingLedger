package org.yu.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    //Initializing an arraylist named "transactionList" that will hold transaction objects.
    //All transaction objects are being pulled with getTransactions
    public static ArrayList<Transaction> transactionList = getTransactions();

   //Declaring the getTransaction as a static method
    public static ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> transactionList = new ArrayList<>();
        //Initialize File Reader and Buffer Reader
        try {
            FileReader fReader = new FileReader("transactions.csv");
            BufferedReader bReader = new BufferedReader(fReader);

            String fInput;//Declaring a String variable named fInput
            //while Loop where String Variable fInput is assigned the buffer reader that will keep reading a line
            //from the csv file until it reaches an empty(null) line in the file.
            while ((fInput = bReader.readLine()) != null) {
                //Assigned String array variable, tDetail to the result of fInput being split by the pipe character (|)
                String[] tDetails = fInput.split("\\|");
                //Starting with String array tDetails at index 0 and continuing to index 4
                //Assign corresponding indexes to convert to LocalDate, LocalTime, String, String and double
                LocalDate date = LocalDate.parse(tDetails[0]);
                LocalTime time = LocalTime.parse(tDetails[1]);
                String description = tDetails[2];
                String vendor = tDetails[3];
                double amount = Double.parseDouble(tDetails[4]);

                Transaction nTransaction = new Transaction(date, time, description, vendor, amount);
                transactionList.add(nTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transactionList;
    }

    public static void viewLedger() { //To view ledger.
        Scanner userInput = new Scanner(System.in);
        //Ledger ledger = new Ledger();
        //
        //Loop until user chooses to go back to home screen
        //while (true) {}
        System.out.println("""
                Please enter an option below:
                [A] All Entries
                [D] Deposits
                [P] Payments
                [R] Reports
                [H] Home
                """);

        String uInput = userInput.nextLine();
        switch (uInput.toUpperCase()) {
            case "A":
                viewAll();
            case "D":
                Transactions.viewDeposits();
            case "P":
                Transactions.viewPayments();
            case "R":
                Reports.viewReports();
            case "H":
                MainMenu.viewHomeScreen();
            default:
                System.out.println("Please enter a valid option.");
                break;
        }
    }
    public static void viewAll() {
        System.out.println("All Transactions: ");
        for (Transaction entry : transactionList) {
            System.out.println(
                    entry.getDate() + " " +
                            entry.getTime() + " " +
                            entry.getDescription() + " " +
                            entry.getVendor() + " " +
                            entry.getAmount()
            );
        }
    }



}
