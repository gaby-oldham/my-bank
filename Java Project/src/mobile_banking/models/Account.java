package mobile_banking.models;

import java.util.ArrayList;

@SuppressWarnings("unused")

public class Account {

    private String accountName;
    private double balance;
    private String accountType;
    private int sortCode;
    private int accountNumber;

    public Account(String accountName, double balance, String accountType, int accountNumber){
        this.accountName = accountName;
        this.balance = balance;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
