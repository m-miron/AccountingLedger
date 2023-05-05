package org.yu.practice;

import java.util.Scanner;

public class MainMenu {//For program entry point

    public static void main(String[] args) {
        viewHomeScreen();//Calls on method that will display home screen to user.
    }

    public static void viewHomeScreen() {

        Scanner userInput = new Scanner(System.in);
        //Initialized to control loop for application's exit
        boolean exitApp = false;
        while (!exitApp) {//To loop through menu options until user wishes to exit,
            System.out.println("""
                            
                            ACCOUNT MENU
                            
                    [D] Add Deposit (Credit)
                    [P] Make Payment (Debit)
                    [L] Ledger
                    [X] Exit
                                        
                    Please enter a bracket [] option (letter only).
                    Option: \s""");
            String uInput = userInput.nextLine();//To read user's input

            /* To perform users input from main menu
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
                default ->
                        System.out.println("Invalid entry. Please try again.\n");//For when the user enters an invalid option. Loops back to home menu.
            }
        }
    }


}

