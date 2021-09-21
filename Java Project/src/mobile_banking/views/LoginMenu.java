package mobile_banking.views;
@SuppressWarnings("unused")

import java.util.Scanner;
// imports the appropriate data from the java library so that the Scanner class can be used to get user input

public class LoginMenu {
    /* creates login menu view class
       this class will act as the user interface for the login process */

    Scanner scn = new Scanner(System.in);
    // creates a new instance of the scanner class

    public static void main(String[] args) {
        /* creates the main method
           the purpose of the main method is to act as the program's execution start point */
        LoginMenu login = new LoginMenu();
        // creates a new instance of the login menu class
        while(true) {
            login.getUserDetails();
            // while the return value of this class is true execute the getUserDetails method
        }
    }

    public void getUserDetails(){
        /* creates method
           this method will be used to prompt the user to enter their login details */
        System.out.println("Please enter your username.");
        // prompts user to enter their username
        String username = scn.nextLine();
        // saves the username inputted by the user to a variable
        System.out.println("Please enter your password.");
        // prompts user to enter their password
        String password = scn.nextLine();
        // saves the password inputted by the user to a variable
        Login loginController = new Login();
        // creates a new instance of the login class, connecting the two classes
        if(loginController.validateLogin(username, password)){
        /* if the username and password entered by the user are valid do then the program flows to the next step
           if they don't the program skips to after the else statement */
            System.out.println("Welcome back " + username);
            // marks successful login
        }
        else{
            System.out.println("Invalid details, please try again");
            // marks unsuccessful login
        }
    }

    /*

    HOMEWORK 16/09/2021

    menu asks user if they have account

    if not they can add a username and password to array
    if register successful they are logged into automatically and redirected to account menu

    if user selects login they are prompted to enter log in details
    if login successful they are logged into automatically and redirected to account menu


     */

}
