// Class for Animal
class Animal {
    String Name;
    String Sound;
    String Habitat;

    // Constructor for Animal class
    public Animal(String Name, String Sound, String Habitat) {
        this.Name = Name;
        this.Sound = Sound;
        this.Habitat = Habitat;
    }

    // Method to make the animal sound
    public void Make_Sound() {
        System.out.println(Name + " sounds: " + Sound);
    }

    // Method to display animal habitat
    public void Show_Habitat() {
        System.out.println(Name + " lives in: " + Habitat);
    }
}

// Main class
public class Activity_9 {
    public static void main(String[] args) {
        // Create specific animal objects
        Animal Lion = new Animal("Lion", "Roar", "Savannah");
        Animal Elephant = new Animal("Elephant", "Trumpet", "Forest");
        Animal Snake = new Animal("Snake", "Hiss", "Jungle");
        Animal Dog = new Animal("Dog", "Bark", "House");
        Animal Dolphin = new Animal("Dolphin", "Click", "Ocean");

        // Display the results
        Lion.Make_Sound();
        Lion.Show_Habitat();

        Elephant.Make_Sound();
        Elephant.Show_Habitat();

        Snake.Make_Sound();
        Snake.Show_Habitat();

        Dog.Make_Sound();
        Dog.Show_Habitat();

        Dolphin.Make_Sound();
        Dolphin.Show_Habitat();
    }
}
