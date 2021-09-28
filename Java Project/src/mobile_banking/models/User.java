package mobile_banking.models;
import java.util.*;
@SuppressWarnings("unused")

public class User {

    private String username;
    private String password;
    private String forename;
    private String surname;
    private ArrayList<Account> accounts;

    public User(String username, String password, String forename, String surname){
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.accounts = new ArrayList<>();
    }

    public User(String username, String password, String forename, String surname, ArrayList<Account> accounts){
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.accounts = accounts;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getForename(){
        return forename;
    }

    public String getSurname(){
        return surname;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

}
