package mobile_banking.views;
import mobile_banking.models.*;
import mobile_banking.controllers.*;
import java.util.Scanner;
@SuppressWarnings("unused")

public class MainMenu {
    /* creates main menu view class
       this class will be used to ask the user what action they wish to complete and redirect them to complete it */

    User currentUser;

    public MainMenu(User currentUser) {
        this.currentUser = currentUser;
        AccountActions.currentUser = currentUser;
        displayMenu();
    }

    Scanner scn = new Scanner(System.in);
    // creates a new instance of the Scanner class to process user input

    public void displayMenu(){
        /* creates method display menu
           this method will be used to output a selection of actions to the user */
        System.out.println("Welcome to mobile banking " + currentUser.getForename() + currentUser.getSurname() + "!");
        System.out.println("Please choose an option");
        System.out.println("1. Open a new account");
        System.out.println("2. View your accounts");
        System.out.println("3. Settings");
        System.out.println("4. Logout");
        // outputs the menu options to the user
        int choice = Integer.parseInt(scn.nextLine());
        // saves the value that corresponds to the user's choice to variable choice
        handleChoice(choice);
        // redirects user to the handle choice method, passing the value of their choice as an argument
    }

    private void handleChoice(int choice){
    /* creates handle choice menu
       this method will be used to allow the user to complete the action of their choice */
        switch (choice) {
        // switch case statement used since we have multiple conditions
            case 1:
                AccountActions.createAccount(currentUser);
                // if user chose to create a new account theyre directed to the create account method
                break;
            case 2:
                AccountActions.viewAccounts(currentUser.getAccounts());
                // if user chose to view their accounts theyre directed to the view accounts method
                break;
            case 3:
                System.out.println("You want to visit settings.");
                // states user choice
                break;
            case 4:
                System.out.println("You want to logout.");
                // states user choice
                break;
            default:
                System.out.println("Invalid choice.");
                // error message before redirecting user back to the menu
                break;
        }
        displayMenu();
        // redirects user back to the menu
    }

    /*

    program greets user
    check if user has any accounts open

    if  not theyre prompted to create an account
    once account is created theyre redirected to account menu

     */

}
