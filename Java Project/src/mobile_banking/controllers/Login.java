package mobile_banking.controllers;
@SuppressWarnings("unused")

public class Login {
    /* creates login controller class
       this class will be used to handle and process the user input from the login menu */

    public User validateLogin(String username, String password){
        /* creates method and assigns it's parameters
           this method will be used to check whether the login details entered
           by the user are a valid combination */

        ArrayList<User> allUsers = Initialise.createUsers();
        /* creates list called allUsers and adds every mobile banking user's, as
           specified in the initialise class, details to it */
        for (User thisUser : allUsers){
            /* program runs through every item in the allUsers list and checks the if statement
               condition against it */
            if (username.equalsIgnoreCase(thisUser.getUsername) && password.equals(thisUser.getPassword)){
            /* determines whether the username sand password combination entered by the user match the list
               if they do then the program flows to the next step
               if they don't the program skips to after the if statement */
                return thisUser;
                // causes the method to exit and assigns the value of thisUser to it
            }
        }
        return null;
        // causes the method to exit without assigning a value to it
    }

}
