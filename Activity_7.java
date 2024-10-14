import java.util.Scanner;

public class Activity_7 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        // Ask for the user's age
        System.out.print("Enter your age: ");
        int Age = Scan.nextInt();

        // Check if the user is 18 or older
        if (Age >= 18) {
            System.out.println("Access granted! You are allowed to enter.");
            // Add the code here for what happens after access is granted
        } else {
            System.out.println("Access denied! You must be 18 or older to enter.");
        }
    }
}
