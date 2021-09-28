package mobile_banking.models;
import java.util.*;

@SuppressWarnings("unused")

public class Account {

    private String accountName;
    private double accountBalance;
    private String accountType;
    private ArrayList<Transaction> transactions;

    public Account(String accountName, double accountBalance, String accountType) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
