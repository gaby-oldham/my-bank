package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    // Make transfer
    public static void transfer(ArrayList<String> accNames){

        //determine account to transfer money from
        System.out.println("Please choose the account you wish to transfer from");
        for(String s : accNames){
            System.out.println(accNames.indexOf(s) + 1 + " - " + s);
        }
        string accountOne = accNames[Byte.parseByte(new Scanner(System.in).nextLine()) - 1];

        //determine account to transfer money to
        System.out.println("Please choose the account you wish to transfer to");
        for(String s : accNames){
            System.out.println(accNames.indexOf(s) + 1 + " - " + s);
        }
        string accountTwo = accNames[Byte.parseByte(new Scanner(System.in).nextLine()) - 1];

        //error handling
        if (accountOne == accountTwo){
            System.out.println("Same account selected");
            transfer(accNames);
        }
        //determine how much money needs transferring
        System.out.println("How much would you like to transfer?");
        double amount = Double.parseDouble(new Scanner(System.in).nextLine());

        //transfer money
        accountOne.withdraw(amount);
        accountTwo.deposit(amount);
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

    public String getStatement() {
        String statement = null;
        statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.sumTransactions();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }

    private String statementForAccount(Account a) {
        String s = "";

       //Translate to pretty account type
        switch(a.getAccountType()){
            case Account.CHECKING:
                s += "Checking Account\n";
                break;
            case Account.SAVINGS:
                s += "Savings Account\n";
                break;
            case Account.MAXI_SAVINGS:
                s += "Maxi Savings Account\n";
                break;
        }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.transactions) {
            s += "  " + (t.amount < 0 ? "withdrawal" : "deposit") + " " + toDollars(t.amount) + "\n";
            total += t.amount;
        }
        s += "Total " + toDollars(total);
        return s;
    }

    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }
}
