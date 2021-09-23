package mobile_banking.views;
import java.util.Scanner;
@SuppressWarnings("unused")

public class AccountActionsMenu {
/* creates account action menu view class
   this class will allow the user to choose an account */

    Scanner scn = new Scanner(System.in);
    // creates a new instance of the scanner class

    public static int displayAccounts(String[] accounts){
    /* creates new method
       this method will allow the user to choose an account */
        System.out.println("Please select one of your accounts from the list below:");
        // prompt - outputted to the user
        for(int i = 1; i < accounts.length + 1; i++){
        // this loop will run until it has outputted every item of the accounts list
            System.out.println(i + " - " + accounts[i - 1]);
            // outputs the item of the accounts list with the index corresponding to the value of i
        }
        return Integer.parseInt(new Scanner(System.in).nextLine());
        // the return value of this method will be the corresponding value to the account selected by the user
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
