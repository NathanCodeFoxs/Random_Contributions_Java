import java.util.Scanner;

public class Activity_10 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        double Balance = 1000.0; // Initial balance
        boolean Continue = true;

        System.out.println("Welcome to the ATM!");

        // Main loop
        while (Continue) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int Choice = Scan.nextInt();

            switch (Choice) {
                case 1:
                    System.out.printf("Your current balance is: $%.2f%n", Balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double Deposit_Amount = Scan.nextDouble();
                    if (Deposit_Amount > 0) {
                        Balance += Deposit_Amount;
                        System.out.printf("You've successfully deposited $%.2f. New balance: $%.2f%n", Deposit_Amount, Balance);
                    } else {
                        System.out.println("Invalid amount. Deposit must be greater than zero.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double Withdraw_Amount = Scan.nextDouble();
                    if (Withdraw_Amount > 0 && Withdraw_Amount <= Balance) {
                        Balance -= Withdraw_Amount;
                        System.out.printf("You've successfully withdrawn $%.2f. New balance: $%.2f%n", Withdraw_Amount, Balance);
                    } else if (Withdraw_Amount > Balance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        System.out.println("Invalid amount. Withdrawal must be greater than zero.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    Continue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 4.");
            }
        }
        Scan.close();
    }
}
