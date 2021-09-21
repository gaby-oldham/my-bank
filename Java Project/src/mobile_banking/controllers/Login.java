package mobile_banking.controllers;
@SuppressWarnings("unused")

public class Login {

    private String username;
    private String password;

    public boolean validateLogin(String username, String password){
        if (username.equalsIgnoreCase("Gaby") && password.equals("Pass")){
            return true;
        }
        return false;
    }

}
