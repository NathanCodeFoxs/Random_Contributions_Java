import java.util.HashMap;
import java.util.Scanner;

public class 40_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);

        // Initialize budget and categories
        System.out.print("Enter your total monthly income: ");
        double Total_Income = Scanner_Input.nextDouble();

        HashMap<String, Double> Expenses = new HashMap<>();
        Expenses.put("Food", 0.0);
        Expenses.put("Rent", 0.0);
        Expenses.put("Entertainment", 0.0);
        Expenses.put("Utilities", 0.0);
        Expenses.put("Miscellaneous", 0.0);

        boolean Is_Running = true;

        while (Is_Running) {
            System.out.println("\nBudget Tracker Menu:");
            System.out.println("1. Add an Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Check Remaining Budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int Choice = Scanner_Input.nextInt();

            switch (Choice) {
                case 1:
                    System.out.println("\nExpense Categories: " + Expenses.keySet());
                    System.out.print("Enter the category: ");
                    String Category = Scanner_Input.next();

                    if (Expenses.containsKey(Category)) {
                        System.out.print("Enter the amount for " + Category + ": ");
                        double Amount = Scanner_Input.nextDouble();

                        Expenses.put(Category, Expenses.get(Category) + Amount);
                        System.out.println("Added " + Amount + " to " + Category + " expenses.");
                    } else {
                        System.out.println("Invalid category. Try again.");
                    }
                    break;

                case 2:
                    System.out.println("\nExpenses by Category:");
                    double Total_Expenses = 0.0;

                    for (String Key : Expenses.keySet()) {
                        System.out.println(Key + ": $" + Expenses.get(Key));
                        Total_Expenses += Expenses.get(Key);
                    }

                    System.out.println("Total Expenses: $" + Total_Expenses);
                    break;

                case 3:
                    double Remaining_Budget = Total_Income;

                    for (double Expense : Expenses.values()) {
                        Remaining_Budget -= Expense;
                    }

                    System.out.println("\nRemaining Budget: $" + Remaining_Budget);
                    if (Remaining_Budget < 0) {
                        System.out.println("Warning: You have exceeded your total income!");
                    } else {
                        System.out.println("You are within your budget. Keep it up!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Budget Tracker. Goodbye!");
                    Is_Running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        Scanner_Input.close();
    }
}
