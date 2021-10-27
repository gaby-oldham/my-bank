package my_bank_master.main;
import my_bank_master.test.*;
import my_bank_master.ui.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
@SuppressWarnings("unused")

public class Transaction {
    public final double amount;

    private Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.getInstance().now();
    }

    public Date getTransactionDate(){
        return transactionDate;
    }

}
