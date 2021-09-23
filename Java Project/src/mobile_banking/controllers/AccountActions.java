package mobile_banking.controllers;
import mobile_banking.models.*;
import mobile_banking.views.*;
import java.util.*;
@SuppressWarnings("unused")

public class AccountActions {
/* creates account action controller class
   this class will allow the user to view or create an account*/

    public static boolean createAccount(User u){
    /* creates new method
       this method will allow the user to open a new account within the system */
        return false;
        /* boolean return value
           this is so we can validate whether an account has been successfully created or not */
    }

    public static void viewAccounts(ArrayList<Account> accList) {
    /* creates new method
       this method will allow the user to view the accounts they already have open within the system */
        String[] accountNames = new String[accounts.size()];
        for(Account a : accList){
        // for every account in the list of accounts...
            accountNames[accList.indexOf(a)] = a.getAccountName();
            // creates a list of all the user's account names
        }
        int accountSelected = AccountActionsMenu.displayAccounts(accountNames) - 1;
        // sets the value of variable accountSelected to the index of the account the user has selected
        Account selectedAccount = accList.get(accountSelected);
        // sets the value of variable selectedAccount to the account selected by the user
    }

}
