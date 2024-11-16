import java.util.Scanner;
import java.util.HashMap;

public class 33_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        HashMap<String, String> Locker = new HashMap<>();

        System.out.print("Set your Digital Locker passcode: ");
        String Passcode = Scanner_Input.nextLine();

        boolean Is_Logged_In = false;
        int Attempts = 3;

        while (Attempts > 0 && !Is_Logged_In) {
            System.out.print("\nEnter your passcode to access the locker: ");
            String Input_Code = Scanner_Input.nextLine();
            
            if (Input_Code.equals(Passcode)) {
                Is_Logged_In = true;
                System.out.println("Access granted!");
            } else {
                Attempts--;
                System.out.println("Incorrect passcode. Attempts remaining: " + Attempts);
            }
        }

        if (!Is_Logged_In) {
            System.out.println("Access denied. Too many failed attempts.");
            Scanner_Input.close();
            return;
        }

        while (true) {
            System.out.println("\nDigital Locker Menu:");
            System.out.println("1. Store a secret");
            System.out.println("2. Retrieve a secret");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            int Choice = Scanner_Input.nextInt();
            Scanner_Input.nextLine(); // consume newline

            switch (Choice) {
                case 1:
                    System.out.print("Enter a title for your secret: ");
                    String Title = Scanner_Input.nextLine();
                    System.out.print("Enter the secret: ");
                    String Secret = Scanner_Input.nextLine();
                    Locker.put(Title, Secret);
                    System.out.println("Secret stored successfully!");
                    break;
                case 2:
                    System.out.print("Enter the title of the secret to retrieve: ");
                    String Retrieve_Title = Scanner_Input.nextLine();
                    if (Locker.containsKey(Retrieve_Title)) {
                        System.out.println("Secret: " + Locker.get(Retrieve_Title));
                    } else {
                        System.out.println("No secret found with that title.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Digital Locker. Stay safe!");
                    Scanner_Input.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
