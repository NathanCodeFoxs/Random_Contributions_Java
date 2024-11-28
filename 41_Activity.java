import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class 41_Activity {
    public static void main(String[] args) throws InterruptedException {
        Scanner Scanner_Input = new Scanner(System.in);
        Random Random_Generator = new Random();

        System.out.println("Welcome to the Memory Game!");
        System.out.println("Try to remember and type the sequence correctly.");
        System.out.println();

        int Level = 1;
        boolean Is_Playing = true;

        while (Is_Playing) {
            System.out.println("Level " + Level + ":");
            int[] Sequence = generateSequence(Level, Random_Generator);

            // Display the sequence briefly
            System.out.print("Memorize this sequence: ");
            for (int Num : Sequence) {
                System.out.print(Num + " ");
            }
            System.out.flush();
            TimeUnit.SECONDS.sleep(2);
            clearConsole();

            // User's turn to input the sequence
            System.out.println("Enter the sequence:");
            int[] User_Input = new int[Level];
            boolean Is_Correct = true;

            for (int i = 0; i < Level; i++) {
                User_Input[i] = Scanner_Input.nextInt();
                if (User_Input[i] != Sequence[i]) {
                    Is_Correct = false;
                }
            }

            if (Is_Correct) {
                System.out.println("Correct! Moving to the next level.");
                Level++;
            } else {
                System.out.println("Wrong sequence! Game over.");
                Is_Playing = false;
            }

            System.out.println();
        }

        System.out.println("You reached Level " + Level + ". Thanks for playing!");
        Scanner_Input.close();
    }

    // Generate a random sequence
    private static int[] generateSequence(int Level, Random Random_Generator) {
        int[] Sequence = new int[Level];
        for (int i = 0; i < Level; i++) {
            Sequence[i] = Random_Generator.nextInt(10); // Numbers from 0 to 9
        }
        return Sequence;
    }

    // Simulates clearing the console screen
    private static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
