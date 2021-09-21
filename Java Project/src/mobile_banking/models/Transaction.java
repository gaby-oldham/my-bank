package mobile_banking.models;
import java.util.*;
@SuppressWarnings("unused")

public class Transaction {

    private double amount;
    private Date transactionDate;
    private String transactionParty;
    private double newBalance;

    public Transaction(double amount, Date transactionDate, String transactionParty, double newBalance){
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionParty = transactionParty;
        this.newBalance = newBalance;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionParty() {
        return transactionParty;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }
}
