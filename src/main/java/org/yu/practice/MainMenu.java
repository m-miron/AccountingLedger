package org.yu.practice;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {//Personal note:To define the main method.
        viewHomeScreen();
    }
    public static void viewHomeScreen() {//This is the home page for the user
        Scanner userInput = new Scanner(System.in);
        boolean exitApp = false;
        while (!exitApp) {
            System.out.println("""
                            
                            ACCOUNT MENU
                            
                    [D] Add Deposit (Credit)
                    [P] Make Payment (Debit)
                    [L] Ledger
                    [X] Exit
                    
                    Please enter a bracket [] option (letter only).
                    Option: \s""");
            String uInput = userInput.nextLine();
            /* To switch from main menu to users selection from main menu
            (no matter the case that they input):
            */
            switch (uInput.toUpperCase()) {
                case "D" -> Transactions.addDeposit();
                case "P" -> Transactions.addPayment();
                case "L" -> Ledger.viewLedger();
                case "X" -> {
                    System.out.println("Thank you!");
                    exitApp = true;
                }
                default -> invalidEntry();//For when the user enters an invalid option. Loops back to home menu.
            }
        }
        System.exit(0);
    }

    public static void invalidEntry() {
        System.out.println("Invalid entry. Please try again.\n");
        viewHomeScreen();
    }

}

