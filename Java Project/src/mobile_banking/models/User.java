package mobile_banking.models;
@SuppressWarnings("unused")

public class User {

    private String fullName;
    private int userID;
    private String username;
    private String password;
    private ArrayList<Account> accounts;

    public User(String fullName, int userID, String username, String password, ArrayList<Account> accounts){
        this.fullName = fullName;
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.accounts = accounts;
    }

    public String getFullName(){
        return fullName;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void setAccounts(String accounts){
        this.accounts = accounts;
    }

}
