import java.util.Random;
import java.util.Scanner;

public class Activity_11 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        Random Random = new Random();

        boolean Play_Again = true;

        System.out.println("Welcome to the Dice Roll Simulator!");

        // Loop to continue rolling the dice
        while (Play_Again) {
            System.out.print("\nPress 'r' to roll the dice or 'q' to quit: ");
            String Input = Scan.next();

            if (Input.equalsIgnoreCase("r")) {
                int Dice_Roll = Random.nextInt(6) + 1; // Generate a random number between 1 and 6
                System.out.println("You rolled a " + Dice_Roll + "!");
            } else if (Input.equalsIgnoreCase("q")) {
                System.out.println("Thank you for playing! Goodbye!");
                Play_Again = false;
            } else {
                System.out.println("Invalid input. Please press 'r' to roll or 'q' to quit.");
            }
        }

        Scan.close();
    }
}
