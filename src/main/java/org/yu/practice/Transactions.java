package org.yu.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Transactions {
    public static ArrayList<Transaction> transactionList = getTransactions();
    public static ArrayList<Transaction> getTransactions(){
        ArrayList<Transaction> transactionList = new ArrayList<>();
        try{
            FileReader fReader = new FileReader("transactions.csv");
            BufferedReader bReader = new BufferedReader(fReader);

            String fInput;
            while ((fInput = bReader.readLine()) !=null){
                String[] tDetails = fInput.split("\\|");
                LocalDate date = LocalDate.parse(tDetails[0]);
                LocalTime time = LocalTime.parse(tDetails[1]);
                String description = tDetails[2];
                String vendor = tDetails[3];
                double amount = Double.parseDouble(tDetails[4]);

                Transaction nTransaction = new Transaction(date, time, description, vendor, amount);
                transactionList.add(nTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transactionList;
    }
}
