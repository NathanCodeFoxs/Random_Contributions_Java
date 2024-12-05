import java.util.HashMap;
import java.util.Scanner;

public class 45_Activity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> expenses = new HashMap<>();

        // Input income
        System.out.print("Enter your monthly income: ");
        double income = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Input expenses
        System.out.println("Enter your monthly expenses. Type 'done' to finish:");
        while (true) {
            System.out.print("Enter expense category (e.g., Rent, Food): ");
            String category = scanner.nextLine();

            if (category.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter amount for " + category + ": ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
        }

        // Calculate total expenses
        double totalExpenses = 0;
        for (double amount : expenses.values()) {
            totalExpenses += amount;
        }

        // Calculate remaining balance
        double balance = income - totalExpenses;

        // Display results
        System.out.println("\n--- Budget Summary ---");
        System.out.println("Income: $" + income);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Remaining Balance: $" + balance);

        System.out.println("\nExpense Breakdown:");
        for (String category : expenses.keySet()) {
            double percentage = (expenses.get(category) / income) * 100;
            System.out.printf("%s: $%.2f (%.2f%% of income)\n", category, expenses.get(category), percentage);
        }

        // Check for overspending
        if (balance < 0) {
            System.out.println("\nWarning: You have overspent your income by $" + Math.abs(balance));
        } else {
            System.out.println("\nGood job! You have managed your budget well.");
        }

        scanner.close();
    }
}
