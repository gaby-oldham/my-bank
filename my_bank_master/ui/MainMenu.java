package my_bank_master.ui;
import mobile_banking.controllers.AccountActions;
import my_bank_master.main.*;
import my_bank_master.test.*;
import java.util.*;
@SuppressWarnings("unused")

public class MainMenu {

    Customer currentCustomer;

    public MainMenu(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        displayMenu();
    }

    Scanner scn = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("------------------------------");
        System.out.println("Main Menu");
        System.out.println("------------------------------");
        System.out.println("Please choose an option");
        System.out.println("1. Open account");
        System.out.println("2. View your accounts");
        System.out.println("3. Close an account");
        System.out.println("4. Perform an action");
        System.out.println("5. Logout");
        System.out.println("------------------------------");
        int choice = Integer.parseInt(scn.nextLine());
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("------------------------------");
                System.out.println("You want to open an account!");
                System.out.println("------------------------------");
                System.out.println("What sort of account do you want to open?");
                System.out.println("1. Checking account");
                System.out.println("2. Savings accounts");
                System.out.println("3. Maxi-Savings account");
                int decision = Integer.parseInt((scn.nextLine()));
                if ((decision < 1) || (decision > 3)) {
                System.out.println("Invalid choice");
                displayMenu();
            }
                if (!checkForDuplicate(decision)) {
                    currentCustomer.openAccount(new Account(decision - 1));
                    System.out.println("Successfully created your account!");
                } else {
                    System.out.println("You already have that type of account.");
                }
                break;
            case 2:
                System.out.println("You want to view your accounts.");
                Customer.viewAccounts(currentCustomer.getAccounts());
                break;
            case 3:
                System.out.println("Please select the account you want to close.");
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
                int choice2 = Integer.parseInt(new Scanner(System.in).nextLine());
                currentCustomer.getAccounts().remove(choice2 - 1);
                System.out.println("Success!");
                displayMenu();
            case 4:
                System.out.println("You want to perform an action.");
                new AccountActionsMenu(currentCustomer);
            case 5:
                System.out.println("You want to logout.");
                System.exit(1);
            default:
                System.out.println("Invalid choice.");
                break;
        }
        displayMenu();
    }

    public boolean checkForDuplicate(int decision) {
        for (Account a : currentCustomer.getAccounts()) {
            if (a.getAccountType() == decision) {
                return true;
            }
        }
        return false;
    }
}