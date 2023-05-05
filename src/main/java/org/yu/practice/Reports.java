package org.yu.practice;
/**/

import java.time.LocalDate;
import java.util.Scanner;

public class Reports {

    public static Scanner userInput = new Scanner(System.in);

    public static void viewReports() {
        System.out.println("""
                        REPORTS MENU
                                
                [1] Month To Date
                [2] Previous Month
                [3] Year To Date
                [4] Previous Year
                [5] Search by Vendor
                [0] Back
                
                Please enter a bracket [] option (number only).
                    Option: \s""");

        int uInput = userInput.nextInt();
        userInput.nextLine();

        switch (uInput) {
            case 1 -> monthToDateReport();
            case 2 -> previousMonthReport();
            case 3 -> yearToDateReport();
            case 4 -> previousYearReport();
            case 5 -> searchByVendorReport();
            case 0 -> {
            }
            default -> invalidEntry();
        }
    }

    public static void monthToDateReport() {
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                MONTH TO DATE
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------\s
                """);
        LocalDate today = LocalDate.now();
        for (Transaction transaction : Ledger.transactionList) {
            LocalDate transactionsDate = transaction.getDate();
            if (transactionsDate.getMonth() == today.getMonth() && transactionsDate.getYear() == today.getYear()) {
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
            }
        }
    }

    public static void previousMonthReport() {
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                PREVIOUS MONTH
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------\s
                """);
        LocalDate today = LocalDate.now();
        int previousMonth = today.minusMonths(1).getMonthValue();
        for (Transaction transaction : Ledger.transactionList) {
            LocalDate transactionsDate = transaction.getDate();
            if (transactionsDate.getMonthValue() == previousMonth && transactionsDate.getYear() == today.getYear()) {
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
            }
        }
    }

    public static void yearToDateReport() {
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                YEAR TO DATE
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------\s
                """);
        LocalDate today = LocalDate.now();
        for (Transaction transaction : Ledger.transactionList) {
            LocalDate transactionsDate = transaction.getDate();
            if (transactionsDate.getYear() == today.getYear()) {
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
            }
        }
    }

    public static void previousYearReport() {
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------                                               \s
                                                                PREVIOUS YEAR
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------\s
                """);
        LocalDate today = LocalDate.now();
        int previousYear = today.minusYears(1).getYear();
        for (Transaction transaction : Ledger.transactionList) {
            LocalDate transactionsDate = transaction.getDate();
            if (transactionsDate.getYear() == previousYear) {
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n",
                        transaction.getDate(),
                        transaction.getTime(),
                        transaction.getDescription(),
                        transaction.getVendor(),
                        transaction.getAmount());
            }
        }
    }

    public static void searchByVendorReport() {
        System.out.print("Enter recipient name: ");
        String vendorName = userInput.nextLine();

        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------""");
        System.out.printf("%50s", "RECIPIENT:");
        System.out.printf("%15s \n", vendorName.toUpperCase());
        System.out.println("""
                -----------------------------------------------------------------------------------------------------------------
                DATE            TIME            DESCRIPTION                         NAME                                AMOUNT\s\s
                -----------------------------------------------------------------------------------------------------------------\s
                """);

        for (Transaction transaction : Ledger.transactionList) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.printf("%-15s %-15s %-35s %-35s $%-25.2f\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(),
                        transaction.getVendor(), transaction.getAmount());
            } else if (Ledger.transactionList.isEmpty()) {
                System.err.println("No transactions found for vendor: " + vendorName);
            }
        }
    }
    public static void invalidEntry() {
        System.out.println("Invalid entry. Please try again.\n");
        viewReports();
    }

}
