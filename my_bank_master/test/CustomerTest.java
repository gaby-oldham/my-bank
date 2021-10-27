package my_bank_master.test;
import my_bank_master.main.*;
import my_bank_master.ui.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
@SuppressWarnings("unused")

public class CustomerTest {

    public static ArrayList<Customer> createCustomers() {
        Customer henry = new Customer("Henry").openAccount(new Account(Account.CHECKING)).openAccount(new Account(Account.SAVINGS));
        ArrayList<Customer> customers = new ArrayList();
        // creates a new instance of ArrayList under the name users
        customers.add(henry);
        // adds user details to users ArrayList
        return customers;
    }

    public static Customer testApp(){

        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        return henry;

    }

    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new Account(Account.SAVINGS));
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(Account.SAVINGS));
        oscar.openAccount(new Account(Account.CHECKING));
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    public void testThreeAccounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(Account.SAVINGS));
        oscar.openAccount(new Account(Account.CHECKING));
        assertEquals(3, oscar.getNumberOfAccounts());
    }
}
