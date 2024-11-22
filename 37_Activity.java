import java.util.Scanner;
import java.util.Random;

public class 37_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        Random Random_Generator = new Random();

        String[] Sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a versatile and powerful programming language.",
            "Practice makes perfect, so keep coding every day.",
            "Typing fast and accurately is an essential skill.",
            "Always strive to write clean and efficient code."
        };

        System.out.println("Welcome to the Typing Speed Test!");
        System.out.println("You will be given a sentence to type. Type it as quickly as you can!\n");

        // Generate a random sentence
        String Sentence_To_Type = Sentences[Random_Generator.nextInt(Sentences.length)];
        System.out.println("Your sentence is:\n" + Sentence_To_Type);
        System.out.println("\nPress Enter to start...");
        Scanner_Input.nextLine(); // Wait for user to press Enter

        // Start timing
        long Start_Time = System.currentTimeMillis();

        System.out.print("\nStart typing: ");
        String User_Input = Scanner_Input.nextLine();

        // End timing
        long End_Time = System.currentTimeMillis();

        // Calculate elapsed time
        double Time_Taken_Seconds = (End_Time - Start_Time) / 1000.0;
        int Words_Typed = Sentence_To_Type.split(" ").length;

        // Check accuracy
        if (User_Input.equals(Sentence_To_Type)) {
            double WPM = (Words_Typed / Time_Taken_Seconds) * 60;
            System.out.printf("\nGreat job! You typed the sentence correctly.\nTime Taken: %.2f seconds\nWords Per Minute (WPM): %.2f\n", Time_Taken_Seconds, WPM);
        } else {
            System.out.println("\nYou made a mistake. Better luck next time!");
            System.out.printf("Time Taken: %.2f seconds\n", Time_Taken_Seconds);
        }

        System.out.println("Thanks for playing the Typing Speed Test!");
        Scanner_Input.close();
    }
}
