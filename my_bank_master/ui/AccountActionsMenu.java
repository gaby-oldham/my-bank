package my_bank_master.ui;
import my_bank_master.main.*;
import my_bank_master.test.*;
import java.util.*;
@SuppressWarnings("unused")

public class AccountActionsMenu {

    Customer currentCustomer;

    public AccountActionsMenu(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        menu();
    }

    public void menu(){
        System.out.println("------------------------------");
        System.out.println("Account Actions Menu");
        System.out.println("------------------------------");
        System.out.println("Please choose an option");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View balance");
        System.out.println("4. Transfer");
        System.out.println("5. Handle interest");
        System.out.println("6. Main menu");
        System.out.println("------------------------------");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("How much do you want to deposit?");
                double amount = Double.parseDouble(new Scanner(System.in).nextLine());
                System.out.println("Please select the destination account");
                getDestinationAccount().deposit(amount);
                System.out.println("Success!");
                menu();
            case 2:
                System.out.println("How much do you want to withdraw?");
                double amount2 = Double.parseDouble(new Scanner(System.in).nextLine());
                System.out.println("Please select the destination account");
                getDestinationAccount().withdraw(amount2);
                System.out.println("Success!");
                menu();
            case 3:
                System.out.println("Please select the destination account");
                System.out.println(getDestinationAccount().sumTransactions());
                menu();
            case 4:
                System.out.println("How much do you want to transfer?");
                double amount3 = Double.parseDouble(new Scanner(System.in).nextLine());
                System.out.println("Please select the account to transfer from");
                getDestinationAccount().withdraw(amount3);
                System.out.println("Please select the account to transfer to");
                getDestinationAccount().deposit(amount3);
            case 5:
                new interestMenu(currentCustomer);
            case 6:
                new MainMenu(currentCustomer);
            default:
                System.out.println("Invalid choice.");
                new MainMenu(currentCustomer);
        }
    }


    public static void viewBalance(double balance){
        System.out.println("Your account's balance is " + balance);
    }

    public Account getDestinationAccount(){
        int x = 1;
        String output = null;
        for(Account s : currentCustomer.getAccounts()){
            if (s.getAccountType() == 0){
                output = "Checking";
            } else if (s.getAccountType() == 1){
                output = "Savings";
            } else {
                output = "Maxi Savings";
            }
            System.out.println(x + " - " + output);
            x += 1;
        }
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        return currentCustomer.getAccounts().get(choice-1);
    }

    public static double getTransferAmount(){
        System.out.println("How much would you like to transfer?");
        return Double.parseDouble(new Scanner(System.in).nextLine());
    }

    public static void displayTransactions(ArrayList<String> transactions){
        System.out.println("Please see all transactions listed below");
        for(String s : transactions){
            System.out.println(s);
        }
    }
}