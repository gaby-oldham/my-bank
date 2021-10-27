package my_bank_master.main;
import my_bank_master.test.*;
import my_bank_master.ui.*;
import java.util.Calendar;
import java.util.Date;
@SuppressWarnings("unused")

public class DateProvider {
    private static DateProvider instance = null;

    public static DateProvider getInstance() {
        if (instance == null)
            instance = new DateProvider();
        return instance;
    }

    public Date now() {
        return Calendar.getInstance().getTime();
    }
}
