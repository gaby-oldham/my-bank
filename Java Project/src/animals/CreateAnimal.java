package animals;

import java.util.Scanner;
@SuppressWarnings("unused")

public class CreateAnimal {

    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        CreateAnimal create = new CreateAnimal();
        create.getAnimalType();
    }

    private void getAnimalType() { //method
        System.out.println("What animal would you like to create?");
        String animal = scn.nextLine();

        switch(animal.toLowerCase()){

            case "dog":
                createDog();
                break;

            case "cat":
                createCat();
                break;

            default:
                System.out.println(animal + " is not an animal we can currently create, please try again!");
        }
    }

    private void createDog() {
        System.out.println("What would you like to call the dog?");
        String name = scn.nextLine();
        System.out.println("What size would you like the dog to be?");
        String size = scn.nextLine();
        System.out.println("How old would you like the dog to be?");
        int age = Integer.parseInt(scn.nextLine());
        System.out.println("What breed would you like the dog to be?");
        String breed = scn.nextLine();

        Dog dog = new Dog(name, size, age, breed); //pass attributes
        System.out.println(dog.bark(size)); //pass methods
        System.out.println(dog.play(breed));
        System.out.println(dog.beHuman(name, age, breed));
    }

    private void createCat() {
        System.out.println("What would you like to call the cat?");
        String name = scn.nextLine();
        System.out.println("What size would you like the cat to be?");
        String size = scn.nextLine();
        System.out.println("How old would you like the cat to be?");
        int age = Integer.parseInt(scn.nextLine());
        System.out.println("What breed would you like the cat to be?");
        String breed = scn.nextLine();

        Cat cat = new Cat(name, size, age, breed); //pass attributes
        System.out.println(cat.meow(size)); //pass methods
        System.out.println(cat.play(breed));
        System.out.println(cat.beHuman(name, age, breed));
    }

}