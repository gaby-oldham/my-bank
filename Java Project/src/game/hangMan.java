package game;

import java.util.*;
@SuppressWarnings("unused")

public class hangMan {

    public String guess;
    public String word;
    public int playerLives;

    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        hangMan create = new hangMan();
        create.start();

    }

    public void start() {

        System.out.println("Welcome to hangman!");
        System.out.println("Do you want to play?");
        String option = scn.nextLine();

        if (option.equalsIgnoreCase("yes")){
            wordInitialisation();
        } else if (option.equalsIgnoreCase("no")){
            System.out.println("Goodbye!");
        } else{
            System.out.println("Sorry, I don't understand!.");
            start();

        }
    }

    public void wordInitialisation() {

        String guess = "";

        System.out.println("Please enter the word or phrase to be guessed. ");
        String word = scn.nextLine();
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                guess += "/";
                word = word.substring(0, i) + "/" + word.substring(i + 1);
            } else {
                guess += "_";
            }
        }

        System.out.println(guess);
        guess(word, guess);

    }

    public void guess(String word, String guess){

        playerLives = 5;
        int count = 0;
        List guessedLetters = new ArrayList();

        while (!(guess.equals(word))) {

            if (playerLives == 0) {
                System.out.println("You have run out of playerLives.");
                start();
            }

            System.out.println("Please guess a letter: ");
            String letterGuess = scn.nextLine();
            letterGuess = letterGuess.toLowerCase();
            char letter = letterGuess.charAt(0);

            boolean letterExists = guessedLetters.contains(letter);

            if (letterExists == false) {

                guessedLetters.add(letter);
                for (int i = 0; i < word.length(); i++) {

                    if (word.charAt(i) == letter) {
                        guess = guess.substring(0, i) + letter + guess.substring(i + 1);
                    } else {
                        count += 1;
                    }
                }

                if (count == word.length()) {
                    playerLives -= 1;
                    System.out.println("Letter not used. You now have " + playerLives + " lives left.");
                } else {
                    System.out.println("Correct guess!");
                }

                count = 0;
                System.out.println(guess);

            }
        }
        System.out.println("Congratulations! You have guessed correctly!");
        start();
        }
}
