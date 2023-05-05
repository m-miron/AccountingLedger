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

    public static void viewLedger() { //To view ledger.
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

            String uInput = userInput.nextLine();
            switch (uInput.toUpperCase()) {
                case "A" -> viewAll();
                case "D" -> Ledger.viewDeposits();
                case "P" -> Ledger.viewPayments();
                case "R" -> Reports.viewReports();
                case "H" -> {
                    return;
                }
                default -> invalidEntry();
            }
        }
    }

    //    public static ArrayList<Transaction> transactionList = getTransactions();
    public static ArrayList<Transaction> transactionList = readTransactions();

    public static ArrayList<Transaction> readTransactions() {
//    public static ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> transactionList = new ArrayList<>();

        try {
            FileReader fReader = new FileReader("transactions1.csv");
            BufferedReader bReader = new BufferedReader(fReader);

            String fInput;
            while ((fInput = bReader.readLine()) != null) {
                if (!fInput.isEmpty()) {
                    String[] tDetails = fInput.split("\\|");
                    LocalDate date = LocalDate.parse(tDetails[0]);
                    LocalTime time = LocalTime.parse(tDetails[1]);
                    String description = tDetails[2];
                    String vendor = tDetails[3];
                    double amount = Double.parseDouble(tDetails[4]);

                    Transaction nTransaction = new Transaction(date, time, description, vendor, amount);
                    transactionList.add(nTransaction);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        transactionList.sort(Comparator.comparing(Transaction::getDate)
                .thenComparing(Transaction::getTime)
                .reversed());
        return transactionList;
    }

    public static void viewAll() {
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                ALL TRANSACTIONS
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------     \s
                """);
        for (Transaction entry : transactionList) {

            System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",
                    entry.getDate(),
                    entry.getTime(),
                    entry.getDescription(),
                    entry.getVendor(),
                    entry.getAmount());
        }
    }

    public static void viewDeposits() {
        System.out.print("\n        DEPOSITS       \n");
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                DEPOSITS
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------\s
                """);
        for (Transaction entry : transactionList) {
            if (entry.getAmount() > 0) {
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",
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
                """);
        for (Transaction entry : transactionList) {
            if (entry.getAmount() < 0) {
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",
                        entry.getDate(),
                        entry.getTime(),
                        entry.getDescription(),
                        entry.getVendor(),
                        entry.getAmount());
            }
        }
    }

    public static void invalidEntry() {
        System.out.println("Invalid entry. Please try again.\n");
        viewLedger();
    }

}
