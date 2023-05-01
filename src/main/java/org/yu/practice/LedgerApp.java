package org.yu.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.yu.practice.Transactions.transactionList;

public class LedgerApp {


    public static void main(String[] args) {
        viewHomeScreen();
    }

    public static void viewHomeScreen() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("""
                Welcome to your account!
                Please select an option:\s
                [D] Add Deposit
                [P] Make Payment (Debit)
                [L] Ledger
                [X] Exit\s"""
        );
        String uInput = userInput.nextLine();
        switch (uInput) {
            case "D" -> addDeposit();
            case "P" -> addPayment();
            case "L" -> viewLedger();
            case "X" -> System.out.println("Thank you!");
        }
    }

    public static void addDeposit() { //To add deposit.
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Date. YYYY-MM-DD");
        String date = userInput.nextLine();
        System.out.println("Enter Time. HH:MM:SS");
        String time = userInput.nextLine();
        System.out.println("Enter Description:");
        String description = userInput.nextLine();
        System.out.println("Enter Payer Name:");
        String vendor = userInput.nextLine();
        System.out.println("Enter Amount:");
        double amount = userInput.nextDouble();
        try {
            FileWriter fWriter = new FileWriter("transactions.csv", true);
            fWriter.write("\n" +
                    date + "|" +
                    time + "|" +
                    description + "|" +
                    vendor + "|" +
                    amount
            );
            fWriter.close();
            System.out.println("Deposit successful!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addPayment() { //To add payment
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Date. YYYY-MM-DD");
        String date = userInput.nextLine();
        System.out.println("Enter Time. HH:MM:SS");
        String time = userInput.nextLine();
        System.out.println("Enter Description:");
        String description = userInput.nextLine();
        System.out.println("Enter Payee Name:");
        String vendor = userInput.nextLine();
        System.out.println("Enter Amount:");
        double amount = userInput.nextDouble();
        try {
            FileWriter fWriter = new FileWriter("transactions.csv", true);
            fWriter.write("\n" +
                    date + "|" +
                    time + "|" +
                    description + "|" +
                    vendor + "|" +
                    amount
            );
            fWriter.close();
            System.out.println("Payment successful!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewLedger() { //To view ledger.
        Scanner userInput = new Scanner(System.in);
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
                viewDeposits();
            case "P":
                viewPayments();
            case "R":
                viewReports();
            case "H":
                LedgerApp.viewHomeScreen();
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

    public static void viewDeposits() {

    }

    public static void viewPayments() {

    }

    public static void viewReports() {

    }

}

