package org.yu.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Transactions {
    public static Scanner userInput = new Scanner(System.in);
    public static void addDeposit() {
            //To autofill current date and time of the new deposit being entered.
            LocalDateTime rightNow = LocalDateTime.now();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
            String date = rightNow.format(dateFormat);
            String time = rightNow.format(timeFormat);
            //To prompt user to enter the description, payer and the amount of the new deposit.
            System.out.println("Let's add a new deposit.");
            System.out.println("Enter a description for the deposit. \nExample: Tax Refund \nEnter:");
            String description = userInput.nextLine();
            System.out.println("Enter the name of the payer. \nContinued Example: IRS \nEnter: ");
            String vendor = userInput.nextLine();
            System.out.println("Enter the amount of the deposit. \nExample: 250.00 \nEnter: ");
            double amount = userInput.nextDouble();
            userInput.nextLine();

            //To add new deposit under transactions1 csv file to later include in reports.
            try (FileWriter fWriter = new FileWriter("transactions1.csv", true)) {
                fWriter.write("\n" + date + "|" + time + "|" + description + "|" + vendor + "|" + amount + "|");
            } catch (IOException e) {
                System.out.println("Input Error: Cannot write into existing file." + e.getMessage());
            }
            System.out.println("Deposit added successfully!");
            MainMenu.viewHomeScreen();
    }
    public static void addPayment() {
        Scanner userInput = new Scanner(System.in);

        //To autofill current date and time of the new payment being entered.
        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String date = rightNow.format(dateFormat);
        String time = rightNow.format(timeFormat);

        //To prompt user to enter the description, payer and the amount of the new payment.
        System.out.println("Let's add a new payment.");
        System.out.println("Enter a description for the payment. \nExample: Rent \nEnter: ");
        String description =userInput.nextLine();
        System.out.println("Enter the name of the payee. \nContinued Example: Landlord Tom \nEnter: ");
        String vendor = userInput.nextLine();
        System.out.println("Enter the amount of the deposit. \nExample: 250.00 \nEnter: ");
        double amount = userInput.nextDouble();
        userInput.nextLine();

        //To add new payment under transactions1 csv file to later include in reports.
        try(FileWriter fWriter = new FileWriter("transactions1.csv", true)){
            fWriter.write( "\n" + date + "|" + time + "|" + description  + "|" + vendor + "|" + "-"  + amount + "|");
        } catch (IOException e){
            System.out.println("Input Error: Cannot write into existing file." + e.getMessage());
        }
        System.out.println("Payment added successfully!");
        MainMenu.viewHomeScreen();
    }

}
