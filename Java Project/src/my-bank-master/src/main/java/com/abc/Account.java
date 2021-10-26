package com.abc;

import java.util.ArrayList;
import java.util.List;

//for checking whether there have been withdrawals in the past 10 days
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private final int accountType;
    public List<Transaction> transactions;

    public static void main(String[] args) {

    }

    public Account(int accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(-amount));
        }
    }

    //used to calculate the daily compounding interest
    public double getDailyCompoundingInterest(int amount) {
        return (((amount / 365) + 1) ^ 365) - 1;
    }

    public double interestEarned() {
        double amount = sumTransactions();
        double interest = 0;
                switch(accountType){
            case SAVINGS:
                if (amount <= 1000) {
                    interest = getDailyCompoundingInterest(0.001) * amount;
                    return amount + interest;
                }
                else {
                    interest = getDailyCompoundingInterest(0.002) * (1 + (amount - 1000));
                    return amount + interest;
                }
//            case SUPER_SAVINGS:
//                if (amount <= 4000)
//                    return 20;
            case MAXI_SAVINGS:
                if (amount <= 1000)
                    interest = getDailyCompoundingInterest(0.02) * amount;
                    return amount + interest;
                //identifies whether the last transaction was made in the last 10 days
                if (amount <= 2000) and (transactions.get(transactions.size() - 1).before(LocalDate.now().minusDays(10)));{
                    interest = getDailyCompoundingInterest(0.05) * (20 + (amount - 1000));
                    return amount + interest;
                }
                interest = getDailyCompoundingInterest(0.1) * (70 + (amount-2000));
                return amount + interest;
            default:
                interest = getDailyCompoundingInterest(0.001) * amount;
                return amount + interest;
        }
    }


    public double sumTransactions() {
       return checkIfTransactionsExist(true);
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.amount;
        return amount;
    }

    public int getAccountType() {
        return accountType;
    }

}
