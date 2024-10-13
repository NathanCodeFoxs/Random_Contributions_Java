import java.util.Scanner;

public class Activity_6 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        // Display coffee menu
        System.out.println("Welcome to the Coffee Machine!");
        System.out.println("Please select your coffee:");
        System.out.println("1. Espresso");
        System.out.println("2. Cappuccino");
        System.out.println("3. Latte");
        System.out.println("4. Black Coffee");

        // Get user choice
        System.out.print("Enter the number of your choice: ");
        int Choice = Scan.nextInt();

        // Prepare coffee based on user choice
        switch (Choice) {
            case 1:
                System.out.println("Preparing Espresso...");
                System.out.println("Your Espresso is ready! Enjoy!");
                break;
            case 2:
                System.out.println("Preparing Cappuccino...");
                System.out.println("Your Cappuccino is ready! Enjoy!");
                break;
            case 3:
                System.out.println("Preparing Latte...");
                System.out.println("Your Latte is ready! Enjoy!");
                break;
            case 4:
                System.out.println("Preparing Black Coffee...");
                System.out.println("Your Black Coffee is ready! Enjoy!");
                break;
            default:
                System.out.println("Invalid selection. Please choose a number between 1 and 4.");
        }

        // End message
        System.out.println("Thank you for using the Coffee Machine!");
    }
}
