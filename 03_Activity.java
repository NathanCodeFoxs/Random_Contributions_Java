import java.util.Random;
import java.util.Scanner;

public class Activity_3 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        Random Random = new Random();

        // Randomly pick a door between 1 and 3 as the prize door
        int Prize_Door = Random.nextInt(3) + 1;

        // Ask the user to pick a door
        System.out.println("Welcome to the Game Show!");
        System.out.println("Pick a door: 1, 2, or 3?");
        int User_Choice = Scan.nextInt();

        // Validate user input
        if (User_Choice < 1 || User_Choice > 3) {
            System.out.println("Invalid choice! Please pick a door between 1 and 3.");
        } else {
            // Reveal the result
            if (User_Choice == Prize_Door) {
                System.out.println("Congratulations! You've picked door " + User_Choice + ", and it's the prize door!");
            } else {
                System.out.println("Sorry, you picked door " + User_Choice + ", but the prize was behind door " + Prize_Door + ".");
            }
        }

        // End the game
        System.out.println("Thanks for playing the Game Show!");
    }
}
