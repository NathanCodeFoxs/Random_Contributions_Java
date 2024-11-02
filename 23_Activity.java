import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String Description;
    double Amount;

    public Expense(String Description, double Amount) {
        this.Description = Description;
        this.Amount = Amount;
    }
}

public class 23_Activity {
    public static void main(String[] args) {
        ArrayList<Expense> Expenses = new ArrayList<>();
        Scanner Scanner_Input = new Scanner(System.in);
        int Choice;
        double Total_Expense = 0;

        do {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            Choice = Scanner_Input.nextInt();
            Scanner_Input.nextLine(); // Consume newline

            switch (Choice) {
                case 1:
                    System.out.print("Enter expense description: ");
                    String Description = Scanner_Input.nextLine();
                    System.out.print("Enter amount: ");
                    double Amount = Scanner_Input.nextDouble();
                    Expenses.add(new Expense(Description, Amount));
                    Total_Expense += Amount;
                    System.out.println("Expense added successfully.");
                    break;

                case 2:
                    System.out.println("\n--- Expense List ---");
                    for (Expense Exp : Expenses) {
                        System.out.println("Description: " + Exp.Description + ", Amount: $" + Exp.Amount);
                    }
                    break;

                case 3:
                    System.out.println("Total Expenses: $" + Total_Expense);
                    break;

                case 4:
                    System.out.println("Exiting Expense Tracker...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (Choice != 4);

        Scanner_Input.close();
    }
}
