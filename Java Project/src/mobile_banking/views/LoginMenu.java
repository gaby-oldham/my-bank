package mobile_banking.views;
import game.hangMan;

import java.util.Scanner;

@SuppressWarnings("unused")

public class LoginMenu {

    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        LoginMenu create = new LoginMenu();
        while(true) {
            login.getUserDetails();
        }
    }

    public void getUserDetails(){
        System.out.println("Please enter your username.");
        String username = scn.nextLine();
        System.out.println("Please enter your password.");
        String password = scn.nextLine();
        Login loginController = new Login();
        if(loginController.validateLogin(username, password)){
            System.out.println("Welcome back " + username);
        }
        else{
            System.out.println("Invalid details, please try again");
        }
    }

    /*

    menu asks user if they have account

    if not they can add a username and password to array
    if register successful they are logged into automatically and redirected to account menu

    if user selects login they are prompted to enter log in details
    if login successful they are logged into automatically and redirected to account menu


     */

}
