package org.yu.practice;

import java.util.Scanner;

public class Reports {

    public static void viewReports() {
//        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=====Select a report:=====\n");
        System.out.println("[1] Month To Date");
        System.out.println("[2] Previous Month");
        System.out.println("[3] Year To Date");
        System.out.println("[4] Previous Year");
        System.out.println("[5] Search by Vendor");
        System.out.println("[6] Custom Search");
        System.out.println("[0] Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: // Month To Date report
//                getMonthToDate();
                break;
            case 2:
                // Display Previous Month report
//                getPreviousMonth();

                break;
            case 3:
                // Display Year To Date report
//                getYearToDate();
                break;
            case 4:
                // Display Previous Year report
                break;
            case 5:
                // Prompt user for vendor name and display vendor transactions
                break;
            case 6:
                // Call customSearch method

                break;
            case 0:
                // Return to previous screen
//                ApplicationInterface.showLedgerScreen();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

//    public static void getMonthToDate() {
//        transactions = readTransactions();
//        Collections.sort(transactions, new Comparator<Transaction>() {
//            public int compare(Transaction t1, Transaction t2) {
//                return t2.getDate().compareTo(t1.getDate());
//            }
//        });
//        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
//
//        // this includes transactions from the past 30 days
//        List<Transaction> monthToDateTransactions = new ArrayList<>();
//        for (Transaction transaction : transactions) {
//            if (!transaction.getDate().isBefore(thirtyDaysAgo)) {
//                monthToDateTransactions.add(transaction);
//            }
//        }
//
//        // Print the results
//        System.out.printf("%-15s %-15s %-25s %-15s %-10s\n", "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
//        System.out.println("------------------------------------------------------------------------------");
//        for (Transaction t : monthToDateTransactions) {
//            System.out.printf("%-15s %-15s %-25s %-15s %-10.2f\n", t.getDate(), t.getTime(), t.getDescription(),
//                    t.getVendor(), t.getAmount());
//        }
//    }

//    public static void getPreviousMonth() {
//        transactions = readTransactions();
//        Collections.sort(transactions, new Comparator<Transaction>() {
//            public int compare(Transaction t1, Transaction t2) {
//                return t2.getDate().compareTo(t1.getDate());
//            }
//        });
//        LocalDate today = LocalDate.now();
//        LocalDate prevMonth = today.minusMonths(1);
//
//        List<Transaction prevMonthTransactions = new ArrayList<>();
//        for (Transaction transaction : transactions) {
//            LocalDate transactionDate = transaction.getDate();
//            if (transactionDate.isAfter(prevMonth.withDayOfMonth(1).minusDays(1))
//                    && transactionDate.isBefore(today.withDayOfMonth(1))) {
//                prevMonthTransactions.add(transaction);
//            }
//        }
//
//        System.out.printf("%-15s %-15s %-25s %-15s %-10s\n", "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
//        System.out.println("------------------------------------------------------------------------------");
//        for (Transaction t : prevMonthTransactions) {
//            System.out.printf("%-15s %-15s %-25s %-15s %-10.2f\n", t.getDate(), t.getTime(), t.getDescription(),
//                    t.getVendor(), t.getAmount());
//        }
//    }

//    public static void getYearToDate() {
//        transactions = readTransactions();
//        Collections.sort(transactions, new Comparator<Transaction>() {
//            public int compare(Transaction t1, Transaction t2) {
//                return t2.getDate().compareTo(t1.getDate());
//            }
//        });
//        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(365);
//
//        List<Transaction> monthToDateTransactions = new ArrayList<>();
//        for (Transaction transaction : transactions) {
//            if (!transaction.getDate().isBefore(thirtyDaysAgo)) {
//                monthToDateTransactions.add(transaction);
//            }
//        }
//
//        System.out.println("\n================================Year to Date================================");
//        System.out.printf("%-15s %-15s %-25s %-15s %-10s\n", "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
//        System.out.println("------------------------------------------------------------------------------");
//        for (Transaction t : monthToDateTransactions) {
//            System.out.printf("%-15s %-15s %-25s %-15s %-10.2f\n", t.getDate(), t.getTime(), t.getDescription(),
//                    t.getVendor(), t.getAmount());
//        }
//    }
}
