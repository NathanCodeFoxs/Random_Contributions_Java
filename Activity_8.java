import java.util.Random;
import java.util.Scanner;

public class Activity_8 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        Random Random = new Random();

        // Variables to store the scores
        int Player_Score = 0;
        int Computer_Score = 0;
        int Rounds = 0;

        // Game loop, continues until either player or computer wins 3 matches
        while (Player_Score < 3 && Computer_Score < 3) {
            System.out.println("Round " + (Rounds + 1));
            System.out.println("Choose: 1 for Rock, 2 for Paper, 3 for Scissors");
            int Player_Choice = Scan.nextInt();

            // Ensure the player input is valid
            if (Player_Choice < 1 || Player_Choice > 3) {
                System.out.println("Invalid choice. Please choose between 1 (Rock), 2 (Paper), or 3 (Scissors).");
                continue;
            }

            // Computer's random choice
            int Computer_Choice = Random.nextInt(3) + 1; // Generates 1, 2, or 3

            // Display choices
            System.out.println("You chose: " + getChoiceName(Player_Choice));
            System.out.println("Computer chose: " + getChoiceName(Computer_Choice));

            // Determine the result of the round
            if (Player_Choice == Computer_Choice) {
                System.out.println("It's a tie! Let's redo this round.");
            } else if ((Player_Choice == 1 && Computer_Choice == 3) ||
                       (Player_Choice == 2 && Computer_Choice == 1) ||
                       (Player_Choice == 3 && Computer_Choice == 2)) {
                System.out.println("You win this round!");
                Player_Score++;
                Rounds++;
            } else {
                System.out.println("Computer wins this round!");
                Computer_Score++;
                Rounds++;
            }

            // Display current scores
            System.out.println("Player score: " + Player_Score + " | Computer score: " + Computer_Score);
            System.out.println();
        }

        // Final result
        if (Player_Score == 3) {
            System.out.println("Congratulations! You won the game.");
        } else {
            System.out.println("Game over! The computer won.");
        }
    }

    // Method to convert numerical choice to Rock, Paper, or Scissors
    public static String getChoiceName(int Choice) {
        switch (Choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid Choice";
        }
    }
}
