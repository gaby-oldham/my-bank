package my_bank_master.main;
import mobile_banking.controllers.initDB;
import mobile_banking.views.AccountMenu;
import my_bank_master.test.*;
import my_bank_master.ui.*;
import java.util.*;
import java.lang.*;
@SuppressWarnings("unused")

public class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    Scanner scn = new Scanner(System.in);

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

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public static void viewAccounts(ArrayList<Account> accList) {
        boolean ans = accList.isEmpty();
        if (ans == false) {
            for(Account a : accList){
                if (a.getAccountType() == 0){
                    System.out.println("Checking");
                } else if (a.getAccountType() == 1){
                    System.out.println("Savings");
                } else {
                    System.out.println("Maxi Savings");
                }
            }
        } else {
                System.out.println("You have no accounts open");
            }
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
        return String.format("$%,.2f", Math.abs(d));
    }
}
