package mobile_banking.controllers;
import mobile_banking.models.*;
import java.util.*;
// imports the appropriate data from the java library so that the ArrayList data structure can be used
@SuppressWarnings("unused")

public class Initialise {
    /* creates initialise controller class
       this class will be used to add to the various lists used within the program */

    public static ArrayList<User> createUsers(){
        ArrayList<User> users = new ArrayList();
        // creates a new instance of ArrayList under the name users
        users.add(new User("gabyoldham", "password", "Gaby", "Oldham"));
        users.add(new User("aliceevans", "password", "Alice", "Evans"));
        users.add(new User("lizziecameron", "password", "Lizzie", "Cameron"));
        users.add(new User("maddyblunn", "password", "Maddy", "Blunn"));
        // adds user details to users ArrayList
        return users;
        // causes the method to exit and assigns the value of users to it
    }

    public static ArrayList<Account> createSingleAccount(){
        ArrayList<Account> accounts = new ArrayList();
        /* creates a new instance of ArrayList under the name accounts
           this is to be used when a user has a single account open */
        accounts.add(new Account("Personal Account", 100, "Current"));
        // adds account details to ArrayList
        return accounts;
        // causes the method to exit and assigns the value of accounts to it
    }

    public static ArrayList<Account> createTwoAccounts(){
        ArrayList<Account> accounts = new ArrayList();
        /* creates a new instance of ArrayList under the name accounts
           this is to be used when a user has two accounts open */
        accounts.add(new Account("Joint Account", 100,"Current"));
        accounts.add(new Account("Rainy Day Money", 500, "Savings"));
        // adds account details to ArrayList
        return accounts;
        // causes the method to exit and assigns the value of accounts to it
    }
}
