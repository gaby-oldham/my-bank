package mobile_banking.controllers;

import mobile_banking.models.*;
import mobile_banking.views.*;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")

public class AccountActions {
/* creates account action controller class
   this class will allow the user to view or create an account*/

    public static User currentUser;
    // creates an instance of the User class under the same of currentUser

    public static boolean createAccount(User u){
    /* creates new method
       this method will allow the user to open a new account within the system */

        String accType = AccountMenu.openAccountGetType();
        // sets variable accType to the type of account chosen by the user
        double initialBalance = AccountMenu.openAccountInitialDeposit();
        // sets variable initialBalance to the initial balance of account chosen by the user
        String accName = AccountMenu.openAccountGetName();
        // sets variable accName to the name of account chosen by the user
        if(accName == null){
            accName = accType;
            // sets variable accName to the type of account chosen by the user if it is not named
        }
        u.addAccount(new Account(accName, initialBalance, accType));
        // adds the new account to the list of the user's current accounts

        return true;
        /* boolean return value
           this is so that we can validate whether an account has been successfully created or not */
    }

    public static void viewAccounts(ArrayList<Account> accList) {
    /* creates new method
       this method will be used to generate a list of all accounts the user holds */
        String[] accountNames = new String[accList.size()];
        /* create a new string array and initialise it with a new string array
           it's size will be equal to the size of the acclist passed into this method */
        for (Account a : accList) {
        /* for every account in the list of account names ...
           'a' is a variable and its data type is account */
            accountNames[accList.indexOf(a)] = a.getAccountName();
            /* retrieves the name of every account using the get function
               the account names are then assigned to the specified index of the account names list */
        }
        int accountSelected = AccountMenu.displayAccounts(accountNames) - 1;
        // sets the value of variable accountSelected to the index of the account the user has selected
        Account selectedAccount = accList.get(accountSelected);
        // sets the value of variable selectedAccount with data type Account to the account selected by the user

        switch (AccountActionsMenu.menu()){
            case 1:
                // switch case statement used since we have multiple conditions
                AccountActionsMenu.viewBalance(selectedAccount.getAccountBalance());
                // if user chose to view their balance theyre directed to the view balance method
                break;
            case 2:
                viewTransactions(selectedAccount);
                break;
            case 3:
                if(transferFunds(selectedAccount)){
                    System.out.println("Transfer successful");
                }
                else{
                    System.out.println("Transfer failed, please try again");
                }
                break;
            case 4:
                // rename account
                renameAccount(selectedAccount);
                break;

            case 5: //Close Account
                break;
        }
    }

    private static void renameAccount(Account selectedAccount) {
        System.out.println("Please choose a new name for your account:");
        String newName = (new Scanner(System.in).nextLine());
        selectedAccount.setAccountName(newName);
    }

    private static void viewTransactions(Account selectedAccount) {
        ArrayList<String> transactions = new ArrayList<>();
        for(Transaction t : selectedAccount.getTransactions()){
            transactions.add(t.toString());
        }
        AccountActionsMenu.displayTransactions(transactions);
    }

    public static boolean transferFunds(Account sourceAccount){
        //get destination account
        ArrayList<String> accNames = new ArrayList<>();
        int sourceIndex = 0;
        for(Account a : currentUser.getAccounts()){
            if(!a.equals(sourceAccount)){
                accNames.add(a.getAccountName());
            }
            else {
                sourceIndex = accNames.size();
            }
        }
        int accIndex = AccountActionsMenu.getDestinationAccount(accNames);
        Account destinationAccount;
        if(accIndex < sourceIndex){
            destinationAccount = currentUser.getAccounts().get(accIndex);
        }
        else{
            destinationAccount = currentUser.getAccounts().get(accIndex + 1);
        }
        double amount = AccountActionsMenu.getTransferAmount();
        if(sourceAccount.getAccountBalance() >= amount){
            //they have enough wonga
            sourceAccount.setAccountBalance(sourceAccount.getAccountBalance() - amount);
            sourceAccount.addTransaction(new Transaction(LocalDate.now(), destinationAccount.getAccountName(),
                    amount * -1, sourceAccount.getAccountBalance()));
            destinationAccount.setAccountBalance(destinationAccount.getAccountBalance() + amount);
            destinationAccount.addTransaction(new Transaction(LocalDate.now(), sourceAccount.getAccountName(),
                    amount, destinationAccount.getAccountBalance()));
            return true;
        }
        else {
            //you dont have enough money!
            return false;
        }
    }

}