package mobile_banking.views;
import java.util.Scanner;
@SuppressWarnings("unused")

public class AccountMenu {
/* creates account action menu view class
   this class will allow the user to choose an account */

    Scanner scn = new Scanner(System.in);
    // creates a new instance of the scanner class

    public static int displayAccounts(String[] accounts) {
    /* creates new method
       this method will allow the user to choose an account */
        System.out.println("Please select one of your accounts from the list below:");
        // prompt - outputted to the user
        for (int i = 1; i < accounts.length + 1; i++) {
            // this loop will run until it has outputted every item of the accounts list
            System.out.println(i + " - " + accounts[i - 1]);
            // outputs the item of the accounts list with the index corresponding to the value of i
        }
        return Integer.parseInt(new Scanner(System.in).nextLine());
        // the return value of this method will be the corresponding value to the account selected by the user
    }

    public static String openAccountGetName() {
    /* creates new method
       this method will allow the user to name their new account */
        System.out.println("Would you like to name your new account? (y/n)");
        // asks user whether they want to name their new account
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("y")) {
            System.out.println("Please enter the name of the account below:");
            // if the user wants to name they account then they are prompted to
            return new Scanner(System.in).nextLine();
            // sets the return value of the method to the account name chosen by the user
        }
        return null;
    }

    public static String openAccountGetType() {
    /* creates new method
       this method will allow the user to choose the type of their new account */
        System.out.println("What type of account would you like to create?");
        System.out.println("1: Current Account");
        System.out.println("1: Standard Savings Account");
        System.out.println("1: ISA");
        System.out.println("1: Credit Account");
        // outputs the account type options to the user
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        // saves the value that corresponds to the user's choice to variable choice
        switch (choice) {
            // switch case statement used since we have multiple conditions
            case 1:
                return "Current";
            case 2:
                return "Standard Savings";
            case 3:
                return "ISA";
            case 4:
                return "Credit";
            // sets the return value of the method to the account type chosen by the user
            default:
                System.out.println("Invalid option provided, please try again.");
                openAccountGetType();
                // if the user enters invalid input theyre redirected back to the start of the method
        }
        return null;
    }

    public static double openAccountInitialDeposit() {
    /* creates new method
       this method will allow the user to choose the initial balance of their new account */
        System.out.println("Would you like to make an initial deposit to your new account? (y/n)");
        // asks user if they want to make an initial deposit
        if(new Scanner(System.in).nextLine().equalsIgnoreCase("y")){
            System.out.println("How much would you like to deposit?");
            return Double.parseDouble(new Scanner(System.in).nextLine());
            // if the user wants to make an initial deposit the return value of the method is set to the deposit amount
        }
        return 0.0;
        // the default return value is 0, which is what it will be set to if they user doesnt make an inital depost
    }
    /*

    User is asked if they want to view their account balence
    if so they are shown their balence

    if not they're asked if they want to transfer funds
    if so they are able to transfer funds

    if not they're asked if they are done and want to log out
    if so program ends
    if not theyre redirected to account actions menu

     */

}
