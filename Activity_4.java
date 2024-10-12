import java.util.Random;

public class Activity_4 {
    public static void main(String[] args) {
        // Create an instance of Random class
        Random rand = new Random();

        // Generate a random number between 0 and 100
        int randomNumber = rand.nextInt(101);

        // Print the random number
        System.out.println("Random Number: " + randomNumber);

        // Check if the number is even or odd
        if (randomNumber % 2 == 0) {
            System.out.println(randomNumber + " is even.");
        } else {
            System.out.println(randomNumber + " is odd.");
        }
    }
}
