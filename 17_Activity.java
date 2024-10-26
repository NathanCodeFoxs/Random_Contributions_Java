import java.util.Scanner;

public class 17_Activity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Answer the following questions by entering the correct option (a, b, c, or d).\n");

        // Question 1
        System.out.println("1. What is the capital of France?");
        System.out.println("a) Berlin");
        System.out.println("b) Madrid");
        System.out.println("c) Paris");
        System.out.println("d) Rome");
        System.out.print("Your answer: ");
        char answer1 = scanner.next().toLowerCase().charAt(0);
        if (answer1 == 'c') {
            score++;
        }

        // Question 2
        System.out.println("\n2. Who developed the theory of relativity?");
        System.out.println("a) Isaac Newton");
        System.out.println("b) Nikola Tesla");
        System.out.println("c) Albert Einstein");
        System.out.println("d) Galileo Galilei");
        System.out.print("Your answer: ");
        char answer2 = scanner.next().toLowerCase().charAt(0);
        if (answer2 == 'c') {
            score++;
        }

        // Question 3
        System.out.println("\n3. What is the largest planet in our solar system?");
        System.out.println("a) Earth");
        System.out.println("b) Jupiter");
        System.out.println("c) Mars");
        System.out.println("d) Venus");
        System.out.print("Your answer: ");
        char answer3 = scanner.next().toLowerCase().charAt(0);
        if (answer3 == 'b') {
            score++;
        }

        // Question 4
        System.out.println("\n4. Which element has the chemical symbol 'O'?");
        System.out.println("a) Gold");
        System.out.println("b) Oxygen");
        System.out.println("c) Hydrogen");
        System.out.println("d) Helium");
        System.out.print("Your answer: ");
        char answer4 = scanner.next().toLowerCase().charAt(0);
        if (answer4 == 'b') {
            score++;
        }

        // Display the final score
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is: " + score + "/4");

        if (score == 4) {
            System.out.println("Excellent! You got all the questions right!");
        } else if (score == 3) {
            System.out.println("Good job! You got 3 out of 4 correct.");
        } else if (score == 2) {
            System.out.println("Not bad! You got 2 out of 4 correct.");
        } else if (score == 1) {
            System.out.println("You got 1 out of 4 correct. Keep practicing!");
        } else {
            System.out.println("Better luck next time! You got 0 out of 4 correct.");
        }

        scanner.close();
    }
}
