package my_bank_master.ui;
import my_bank_master.main.*;
import my_bank_master.test.*;
import java.util.*;
@SuppressWarnings("unused")

public class LoginMenu {
    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        LoginMenu login = new LoginMenu();
        while (true) {
            System.out.println("Welcome " + CustomerTest.testApp().getName() + "!");
            new MainMenu(CustomerTest.testApp());
        }
    }
}