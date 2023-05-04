package org.yu.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        viewHomeScreen();
    }

    public static void viewHomeScreen() {
        Scanner userInput = new Scanner(System.in);
        boolean exitApp = false;
        while (!exitApp) {
            System.out.println("""
                    ACCOUNT LEDGER
                    Please select an option:\s
                    [D] Add Deposit (Credit)
                    [P] Make Payment (Debit)
                    [L] Ledger
                    [X] Exit\s""");
            String uInput = userInput.nextLine();
            //Displays add deposit, add payment, ledger, or exit on the screen for user to see.
            switch (uInput.toUpperCase()) {
                case "D" -> Transactions.viewDeposits();
                case "P" -> Transactions.viewPayments();
                case "L" -> Ledger.viewLedger();
                case "X" -> {
                    System.out.println("Thank you!");
                    exitApp = true;
                }
                default -> invalidEntry();//For when the user enters an invalid option. Loops back to home menu.
            }
        }
        return;
    }

    public static void invalidEntry() {
        System.out.println("Invalid entry. Please try again.\n");
        viewHomeScreen();
    }

}

