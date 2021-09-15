package songs;

import java.util.Scanner;

@SuppressWarnings("unused")

public class BottleSong {

    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        BottleSong create = new BottleSong();
        create.sing();
    }

    private void sing(){

        System.out.println("How many bottles are left? ");
        int bottles = Integer.parseInt(scn.nextLine());

        String word = "bottles";
        int newValue = 0;

        for (int i = bottles; i > 0; i--) {

            System.out.println("There's " + i + " " + word + " of beer on the wall");
            System.out.println(i + " " + word + " of beer");
            System.out.println("Take one down, pass it around");

            newValue = i - 1;

            if (newValue == 1){
                word = "bottle";
            }else {
                word = "bottles";
            }

            System.out.println("Now there's " + newValue + " " + word + " of beer left on the wall");
        }

    }

}
