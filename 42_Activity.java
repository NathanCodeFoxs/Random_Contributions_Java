import java.util.ArrayList;
import java.util.Scanner;

class Workout {
    String Type;
    int Duration; // in minutes
    int Calories;

    public Workout(String type, int duration, int calories) {
        this.Type = type;
        this.Duration = duration;
        this.Calories = calories;
    }
}

public class 42_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        ArrayList<Workout> Workouts = new ArrayList<>();
        boolean Is_Running = true;

        System.out.println("Welcome to the Workout Tracker!");
        System.out.println("Track your daily workouts and review your weekly progress.\n");

        while (Is_Running) {
            System.out.println("Menu:");
            System.out.println("1. Add a Workout");
            System.out.println("2. View Weekly Summary");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int Choice = Scanner_Input.nextInt();

            switch (Choice) {
                case 1:
                    Scanner_Input.nextLine(); // Consume the newline
                    System.out.print("Enter the workout type (e.g., Cardio, Strength, Yoga): ");
                    String Type = Scanner_Input.nextLine();

                    System.out.print("Enter the duration (in minutes): ");
                    int Duration = Scanner_Input.nextInt();

                    System.out.print("Enter the calories burned: ");
                    int Calories = Scanner_Input.nextInt();

                    Workouts.add(new Workout(Type, Duration, Calories));
                    System.out.println("Workout added successfully!\n");
                    break;

                case 2:
                    if (Workouts.isEmpty()) {
                        System.out.println("No workouts logged yet. Add some workouts first!\n");
                    } else {
                        System.out.println("Weekly Workout Summary:");
                        int Total_Duration = 0;
                        int Total_Calories = 0;

                        for (Workout W : Workouts) {
                            System.out.println("Type: " + W.Type + ", Duration: " + W.Duration + " mins, Calories: " + W.Calories + " kcal");
                            Total_Duration += W.Duration;
                            Total_Calories += W.Calories;
                        }

                        System.out.println("\nTotal Time Spent: " + Total_Duration + " minutes");
                        System.out.println("Total Calories Burned: " + Total_Calories + " kcal\n");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the Workout Tracker. Stay active and healthy!");
                    Is_Running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        Scanner_Input.close();
    }
}
