package org.yu.practice;

public class Transactions {
    public static void viewDeposits() {
        System.out.print("Deposits: ");
        for (Transaction entry : Ledger.transactionList) {
            if (entry.getAmount() < 0) {
                System.out.println(
                        entry.getDate() + " " +
                                entry.getTime() + " " +
                                entry.getDescription() + " " +
                                entry.getVendor() + " " +
                                entry.getAmount()
                );
            }
        }
    }

    public static void viewPayments() {
        System.out.println("Payments: ");
        for (Transaction entry : Ledger.transactionList) {
            if (entry.getAmount() > 0) {
                System.out.println(
                        entry.getDate() + " " +
                                entry.getTime() + " " +
                                entry.getDescription() + " " +
                                entry.getVendor() + " " +
                                entry.getAmount()
                );
            }
        }
    }
}
