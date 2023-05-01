package org.yu.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
            case "D":
                addDeposit();
                break;
            case "P":
                makePayment();
                break;
            case "L":
                viewLedger();
                break;
            case "X":
                System.out.println("Thank you!");
                break;

        }
    }

    public static void addDeposit() {
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

    public static void makePayment() {
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

    public static void viewLedger() {

    }
}
