import java.util.HashMap;
import java.util.Scanner;

public class 24_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        HashMap<String, Integer> Votes = new HashMap<>();

        // Predefined options
        Votes.put("Option_1: Apple", 0);
        Votes.put("Option_2: Banana", 0);
        Votes.put("Option_3: Orange", 0);

        System.out.println("---- Voting System ----");
        System.out.println("Please vote for your favorite option:");
        System.out.println("1. Apple");
        System.out.println("2. Banana");
        System.out.println("3. Orange");

        for (int i = 1; i <= 5; i++) { // Five users voting in this example
            System.out.print("User " + i + ", enter your vote (1-3): ");
            int Vote = Scanner_Input.nextInt();
            switch (Vote) {
                case 1:
                    Votes.put("Option_1: Apple", Votes.get("Option_1: Apple") + 1);
                    break;
                case 2:
                    Votes.put("Option_2: Banana", Votes.get("Option_2: Banana") + 1);
                    break;
                case 3:
                    Votes.put("Option_3: Orange", Votes.get("Option_3: Orange") + 1);
                    break;
                default:
                    System.out.println("Invalid vote.");
            }
        }

        // Displaying the results
        System.out.println("\n--- Voting Results ---");
        String Winner = "";
        int Max_Votes = 0;
        for (String Option : Votes.keySet()) {
            int Vote_Count = Votes.get(Option);
            System.out.println(Option + " - Votes: " + Vote_Count);
            if (Vote_Count > Max_Votes) {
                Max_Votes = Vote_Count;
                Winner = Option;
            }
        }
        System.out.println("The winning option is: " + Winner);
        
        Scanner_Input.close();
    }
}
