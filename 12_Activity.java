import java.util.Random;
import java.util.Scanner;

public class Activity_12 {

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        Random Random = new Random();
        boolean Play_Again = true;

        System.out.println("Welcome to Russian Roulette!");

        // Main game loop
        while (Play_Again) {
            // Set up the gun (1 bullet in 6 chambers)
            int Bullet_Position = Random.nextInt(6) + 1;
            System.out.println("\nSpinning the cylinder...");

            // Ask the player to pull the trigger
            System.out.print("Press 'p' to pull the trigger or 'q' to quit: ");
            String Input = Scan.next();

            if (Input.equalsIgnoreCase("p")) {
                int Player_Chamber = Random.nextInt(6) + 1;
                System.out.println("You pulled the trigger on chamber " + Player_Chamber + "...");

                // Check if the player loses
                if (Player_Chamber == Bullet_Position) {
                    System.out.println("BANG! You lose.");
                    Play_Again = false;
                } else {
                    System.out.println("Click... You're safe. Want to try again?");
                }

            } else if (Input.equalsIgnoreCase("q")) {
                System.out.println("Thank you for playing! Goodbye!");
                Play_Again = false;

            } else {
                System.out.println("Invalid input. Please press 'p' to play or 'q' to quit.");
            }
        }

        Scan.close();
    }
}
