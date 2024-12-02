import java.util.Scanner;

class Habit {
    String Name;
    boolean[] DaysCompleted; // 7 days: 0-Monday to 6-Sunday

    public Habit(String name) {
        this.Name = name;
        this.DaysCompleted = new boolean[7];
    }

    public void markDayComplete(int day) {
        if (day >= 0 && day < 7) {
            DaysCompleted[day] = true;
        }
    }

    public int getCompletedDays() {
        int count = 0;
        for (boolean completed : DaysCompleted) {
            if (completed) count++;
        }
        return count;
    }
}

public class 43_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        Habit[] Habits = new Habit[10];
        int Habit_Count = 0;
        boolean Is_Running = true;

        System.out.println("Welcome to the Habit Tracker!");
        System.out.println("Track your habits and monitor your progress for the week.\n");

        while (Is_Running) {
            System.out.println("Menu:");
            System.out.println("1. Add a Habit");
            System.out.println("2. Mark Habit as Completed");
            System.out.println("3. View Weekly Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int Choice = Scanner_Input.nextInt();

            switch (Choice) {
                case 1:
                    if (Habit_Count < Habits.length) {
                        Scanner_Input.nextLine(); // Consume the newline
                        System.out.print("Enter the name of the habit: ");
                        String Habit_Name = Scanner_Input.nextLine();
                        Habits[Habit_Count++] = new Habit(Habit_Name);
                        System.out.println("Habit added successfully!\n");
                    } else {
                        System.out.println("Habit limit reached. Cannot add more habits.\n");
                    }
                    break;

                case 2:
                    if (Habit_Count == 0) {
                        System.out.println("No habits to mark as completed. Add some habits first!\n");
                    } else {
                        System.out.println("Select a habit to mark as completed:");
                        for (int i = 0; i < Habit_Count; i++) {
                            System.out.println((i + 1) + ". " + Habits[i].Name);
                        }
                        int Habit_Choice = Scanner_Input.nextInt() - 1;

                        if (Habit_Choice >= 0 && Habit_Choice < Habit_Count) {
                            System.out.print("Enter the day of the week (1-Monday to 7-Sunday): ");
                            int Day = Scanner_Input.nextInt() - 1;

                            if (Day >= 0 && Day < 7) {
                                Habits[Habit_Choice].markDayComplete(Day);
                                System.out.println("Habit marked as completed for the day!\n");
                            } else {
                                System.out.println("Invalid day. Please enter a number between 1 and 7.\n");
                            }
                        } else {
                            System.out.println("Invalid habit selection.\n");
                        }
                    }
                    break;

                case 3:
                    if (Habit_Count == 0) {
                        System.out.println("No habits to display. Add some habits first!\n");
                    } else {
                        System.out.println("Weekly Summary:");
                        for (int i = 0; i < Habit_Count; i++) {
                            System.out.println(Habits[i].Name + ": " + Habits[i].getCompletedDays() + " days completed");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Habit Tracker. Stay consistent and achieve your goals!");
                    Is_Running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        Scanner_Input.close();
    }
}
