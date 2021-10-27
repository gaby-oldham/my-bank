package my_bank_master.test;
import my_bank_master.main.*;
import my_bank_master.ui.*;
import static org.junit.Assert.*;
import org.junit.Test;
@SuppressWarnings("unused")

public class TransactionTest {
    public void transaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
    }
}
