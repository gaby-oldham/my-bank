package animals;
@SuppressWarnings("unused")

public class Cat {

    private String name;
    private String size;
    private int age;
    private String breed;

    public Cat(String name, String size, int age, String breed){
        this.name = name;
        this.size = size;
        this.age = age;
        this.breed = breed;
    }

    public String meow(String size) {
        String meow = "";
        if(size.equalsIgnoreCase("small")) {
            meow = "";
        }
        else if(size.equalsIgnoreCase("medium")) {
            meow = "";
        }
        else {
            meow = "";
        }

        return meow;

    }

    public String play(String size) {
        String playing = "";
        if(breed.equalsIgnoreCase("persian")){
            playing = "";
        }
        else if(breed.equalsIgnoreCase("siamese")){
            playing = "";
        }
        else if(breed.equalsIgnoreCase("lion")){
            playing = "R";
        }

        return playing;
    }

    public String beHuman(String name, int age, String breed) {
        return "Hello human, I'm " + name + " and I am a " + age + " year old " + breed + ", nice to meet you!";
    }

}
