import java.util.Random;
import java.util.Scanner;

public class 15_Activity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int guess = 0;
            int attempts = 0;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("Can you guess what it is?");

            while (guess != numberToGuess) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }
            }

            System.out.print("\nWould you like to play again? (y/n): ");
            char response = scanner.next().toLowerCase().charAt(0);
            if (response != 'y') {
                playAgain = false;
                System.out.println("Thanks for playing! Goodbye.");
            }
        }

        scanner.close();
    }
}
