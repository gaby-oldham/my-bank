package my_bank_master.ui;
import my_bank_master.main.*;
import my_bank_master.test.*;
import java.util.*;
import java.lang.Math;
@SuppressWarnings("unused")

public class interestMenu {

    Customer currentCustomer;

    public interestMenu(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        menu();
    }

    public void menu() {
        System.out.println("------------------------------");
        System.out.println("Interest Menu");
        System.out.println("------------------------------");
        System.out.println("Please choose an option");
        System.out.println("1. Calculate total interest earned so far");
        System.out.println("2. Estimate annual interest");
        System.out.println("3. Main menu");
        System.out.println("------------------------------");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("You want to calculate the total interest earned so far");
                System.out.println("Please select an account from the list.");
                Account acc = getAccount();
                double startAmount = acc.sumTransactions();
                System.out.println(dailyCompoundInterest(acc.getAccountType(), startAmount, acc));
                menu();
            case 2:
                System.out.println("You want to estimate the annual interest");
                System.out.println("Please select an account from the list.");
                System.out.println("Your estimated annual interest for the selected account is: " + getAccount().interestEarned());
                menu();
            case 3:
                new MainMenu(currentCustomer);
            default:
                System.out.println("Invalid choice.");
                new MainMenu(currentCustomer);
        }
    }

    public Account getAccount() {
        int x = 1;
        String output = null;
        for (Account s : currentCustomer.getAccounts()) {
            if (s.getAccountType() == 0) {
                output = "Checking";
            } else if (s.getAccountType() == 1) {
                output = "Savings";
            } else {
                output = "Maxi Savings";
            }
            System.out.println(x + " - " + output);
            x += 1;
        }
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        return currentCustomer.getAccounts().get(choice);
    }

    public double dailyCompoundInterest(int accountType, double startAmount, Account account) {
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        double e = 0;
        if (accountType == 0) {
            return (startAmount * (Math.pow(1 + 0.001, 365))) - startAmount;
        } else if (accountType == 1) {
            if (startAmount < 1000) {
                return (startAmount * (Math.pow(1 + 0.001, 365))) - startAmount;
            } else {
                a = (1000 * (Math.pow(1 + 0.001, 365))) - 1000;
                b = (((startAmount - 1000) * (Math.pow(1 + 0.002, 365)))) - (startAmount - 1000);
                return a + b;
            }
        } else if (accountType == 2) {
            if (timeDiff(account)) {
                return (startAmount * (Math.pow(1 + 0.05, 365))) - startAmount;
            } else {
                return (startAmount * (Math.pow(1 + 0.001, 365))) - startAmount;
            }
        } else {
            System.exit(1);
        }
        return 0;
    }

    public boolean timeDiff(Account account){
        Transaction t = account.getTransactions().get(account.transactions.size()-1);
        Date lastTransaction = t.getTransactionDate();
        Date now = DateProvider.getInstance().now();
        if(lastTransaction.compareTo(now) < 10) {
            return true;
        }
        return false;
    }

}
