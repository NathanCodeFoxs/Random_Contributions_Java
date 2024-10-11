import java.util.Scanner;

public class Activity_2 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        // Input the first number
        System.out.print("Enter the first number: ");
        double Num_1 = Scan.nextDouble();

        // Input the second number
        System.out.print("Enter the second number: ");
        double Num_2 = Scan.nextDouble();

        // Input the operator
        System.out.print("Enter an operator (+, -, *, /): ");
        char Operator = Scan.next().charAt(0);

        // Variable to store the result
        double Result = 0;

        // Perform the operation based on the operator input
        switch (Operator) {
            case '+':
                Result = Num_1 + Num_2;
                break;
            case '-':
                Result = Num_1 - Num_2;
                break;
            case '*':
                Result = Num_1 * Num_2;
                break;
            case '/':
                if (Num_2 != 0) {
                    Result = Num_1 / Num_2;
                } else {
                    System.out.println("Error: Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator. Please use +, -, *, or /.");
                return;
        }

        // Display the result
        System.out.println("The result is: " + Result);
    }
}
