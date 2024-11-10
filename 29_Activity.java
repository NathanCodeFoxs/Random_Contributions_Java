import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class 29_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        LocalDate Start_Date = LocalDate.of(2024, 11, 1);
        LocalDate Current_Date = LocalDate.now();
        long Days_Passed = ChronoUnit.DAYS.between(Start_Date, Current_Date);

        if (Days_Passed < 0 || Days_Passed > 30) {
            System.out.println("It's not No-Nut November currently!");
            return;
        }

        System.out.println("Welcome to the No-Nut November Challenge Tracker!");
        System.out.println("Today is Day " + (Days_Passed + 1) + " of No-Nut November.");
        
        System.out.print("Did you succeed today? (yes/no): ");
        String Input = Scanner_Input.nextLine().toLowerCase();

        if (Input.equals("yes")) {
            System.out.println("Great job! Keep going strong 💪!");
        } else if (Input.equals("no")) {
            System.out.println("Stay strong! You can try again next year! 🫣");
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }

        System.out.println("Stay disciplined and make it through November! 📅");
        Scanner_Input.close();
    }
}
