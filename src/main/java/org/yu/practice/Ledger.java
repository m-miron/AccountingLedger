package org.yu.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Ledger {
    public static Scanner userInput = new Scanner(System.in);

    public static void viewLedger() { //To view ledger menu.
        //Loop until user chooses to go back to home screen
        while (true) {
            System.out.println("""
                            
                            LEDGER MENU
                                        
                    [A] All Transactions
                    [D] Deposits Only
                    [P] Payments Only
                    [R] Reports
                    [H] Home
                                        
                    Please enter a bracket [] option (letter only).
                    Option: \s
                    """);

            String usersInput = userInput.nextLine();//To read user's input

            // To perform users input from ledger menu (no matter the case that they input):
            switch (usersInput.toUpperCase()) {
                case "A" -> viewAll(); //To view all transactions
                case "D" -> viewDeposits();//To view deposits only
                case "P" -> viewPayments();//To view payments only
                case "R" -> Reports.viewReports();//To view reports menu screen
                case "H" -> {
                    return;
                }
                //For when the user enters an invalid option. Loops back to ledger menu.
                default -> System.out.println("Invalid entry. Please try again.\n");
            }
        }
    }


    public static ArrayList<Transaction> transactionList = readTransactions();

    public static ArrayList<Transaction> readTransactions() {//To read transactions from csv file then add to transaction list
        ArrayList<Transaction> transactionList = new ArrayList<>();//Note to self: To initialize empty list to store transaction objects.

        try {
            //Note to self: File Reader object is to read from transactionsFile while Buffered Reader is for efficiency of file reader 
            FileReader fReader = new FileReader(Transactions.transactionsFile);
            BufferedReader bReader = new BufferedReader(fReader);

            String fInput; //Reading each lin
            while ((fInput = bReader.readLine()) != null) {
                if (!fInput.isEmpty()) {//Parsing from String data input and splitting by pipe character to pull transaction details
                    String[] transactionDetails = fInput.split("\\|");
                    LocalDate date = LocalDate.parse(transactionDetails[0]);
                    LocalTime time = LocalTime.parse(transactionDetails[1]);
                    String description = transactionDetails[2];
                    String vendor = transactionDetails[3];
                    double amount = Double.parseDouble(transactionDetails[4]);

                    //For new Transaction object creation which will be added to transaction list.
                    Transaction newTransaction = new Transaction(date, time, description, vendor, amount);
                    transactionList.add(newTransaction);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //To sort transaction list by date and time
        transactionList.sort(Comparator.comparing(Transaction::getDate)
                .thenComparing(Transaction::getTime)
                .reversed());//To display in descending order of date and time.
        return transactionList;
    }

    public static void viewAll() {//To print out all transactions in transaction list
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                ALL TRANSACTIONS
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------     \s
                """);//Printing report header.
        for (Transaction entry : transactionList) {//Loop to print each transaction in transaction list.

            System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",//Print format for transaction.
                    entry.getDate(),
                    entry.getTime(),
                    entry.getDescription(),
                    entry.getVendor(),
                    entry.getAmount());
        }
    }

    public static void viewDeposits() {//To print deposits only.
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                DEPOSITS
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------\s
                """);//Printing report header.
        for (Transaction entry : transactionList) {//Loop to print each transaction in transaction list.
            if (entry.getAmount() > 0) { //Loop to only enter each transaction that is greater than 0
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",//Print format for transaction.
                        entry.getDate(),
                        entry.getTime(),
                        entry.getDescription(),
                        entry.getVendor(),
                        entry.getAmount());
            }
        }
    }

    public static void viewPayments() { //To print payments only.
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                PAYMENTS
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------\s
                """);//Printing report header.
        for (Transaction entry : transactionList) {//Loop to print each transaction in transaction list.
            if (entry.getAmount() < 0) { //Loop to only enter each transaction that is greater than 0
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",//Print format for transaction.
                        entry.getDate(),
                        entry.getTime(),
                        entry.getDescription(),
                        entry.getVendor(),
                        entry.getAmount());
            }
        }
    }

}
