import java.util.HashMap;
import java.util.Scanner;

public class 46_Activity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> dailyExercise = new HashMap<>();
        int totalCalories = 0;
        int totalMinutes = 0;

        System.out.println("Welcome to the Fitness Tracker!");
        System.out.println("Log your daily exercises for the week. Type 'done' to finish.");

        for (int day = 1; day <= 7; day++) {
            System.out.println("\nDay " + day + ":");

            while (true) {
                System.out.print("Enter exercise type (e.g., Running, Yoga, etc.) or 'done' to finish for the day: ");
                String activity = scanner.nextLine();

                if (activity.equalsIgnoreCase("done")) {
                    break;
                }

                System.out.print("Enter duration in minutes for " + activity + ": ");
                int duration = scanner.nextInt();

                System.out.print("Enter calories burned for " + activity + ": ");
                int calories = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                dailyExercise.put(activity, dailyExercise.getOrDefault(activity, 0) + duration);
                totalMinutes += duration;
                totalCalories += calories;
            }
        }

        // Calculate weekly stats
        double averageMinutes = totalMinutes / 7.0;

        // Display results
        System.out.println("\n--- Weekly Fitness Summary ---");
        System.out.println("Total Minutes Exercised: " + totalMinutes);
        System.out.println("Total Calories Burned: " + totalCalories);
        System.out.printf("Average Daily Exercise Time: %.2f minutes\n", averageMinutes);

        System.out.println("\nExercise Breakdown:");
        for (String activity : dailyExercise.keySet()) {
            System.out.println(activity + ": " + dailyExercise.get(activity) + " minutes");
        }

        // Suggest improvement if average is less than 30 minutes per day
        if (averageMinutes < 30) {
            System.out.println("\nYou should aim for at least 30 minutes of exercise daily. Keep it up!");
        } else {
            System.out.println("\nGreat job staying active this week! Keep up the good work.");
        }

        scanner.close();
    }
}
