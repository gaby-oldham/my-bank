package mobile_banking.views;
import java.util.*;

@SuppressWarnings("unused")

public class AccountActionsMenu {
/* creates account action menu view class
   this class will allow the user to choose an action */

    public static int menu(){
    /* creates method menu
       this method will be used to output a selection of actions to the user */
        System.out.println("Please choose an option");
        System.out.println("1. View balance");
        System.out.println("2. View transactions");
        System.out.println("3. Make transfer");
        System.out.println("4. Rename account");
        System.out.println("5. Close account");
        // outputs the menu options to the user
        return Integer.parseInt(new Scanner(System.in).nextLine());
        // sets choice variable to the user's choice
    }

    // View balance
    public static void viewBalance(double balance){
    /* creates method view balance
       this method will be used to output the user's chosen account's balance */
        System.out.println("Your account's balance is " + balance);
        // outputs the user's chosen account's balance
    }

    // View transactions

    // Make transfer
    public static byte getDestinationAccount(ArrayList<String> accNames){
        System.out.println("Please select the destination account");
        for(String s : accNames){
            System.out.println(accNames.indexOf(s) + 1 + " - " + s);
        }
        return (byte) (Byte.parseByte(new Scanner(System.in).nextLine()) - 1);
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

    // Close account

    // Change account name

}
