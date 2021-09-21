package mobile_banking.controllers;
@SuppressWarnings("unused")

import java.util.ArrayList;
// imports the appropriate data from the java library so that the ArrayList data structure can be used

public class Initialise {
    /* creates initialise controller class
       this class will be used to add to the various lists used within the program */

    public static ArrayList<User> createUsers(){
        ArrayList<User> users = new ArrayList();
        // creates a new instance of ArrayList under the name users
        users.add(new User("Gaby Oldham", 1, "gabyoldham", "password"));
        users.add(new User("Alice Evans", 2, "aliceevans", "password"));
        users.add(new User("Lizzie Cameron", 3, "lizziecameron", "password"));
        users.add(new User("Maddy Blunn", 4, "maddyblunn", "password"));
        // adds user details to users ArrayList
        return users;
        // causes the method to exit and assigns the value of users to it
    }

    public static ArrayList<Account> createSingleAccount(){
        ArrayList<Account> accounts = new ArrayList();
        /* creates a new instance of ArrayList under the name accounts
           this is to be used when a user has a single account open */
        accounts.add(new Account("Current", 100, "Current", 274935, 29385620));
        // adds account details to ArrayList
        return accounts;
        // causes the method to exit and assigns the value of accounts to it
    }

    public static ArrayList<Account> createTwoAccounts(){
        ArrayList<Account> accounts = new ArrayList();
        /* creates a new instance of ArrayList under the name accounts
           this is to be used when a user has two accounts open */
        accounts.add(new Account("Current", 100, "Current", 29385620));
        accounts.add(new Account("Savings", 500, "Savings", 38561094));
        // adds account details to ArrayList
        return accounts;
        // causes the method to exit and assigns the value of accounts to it
    }

}
