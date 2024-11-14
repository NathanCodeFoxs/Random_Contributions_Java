import java.util.Scanner;

public class 33_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);

        System.out.print("Enter the number of Roblox items you own: ");
        int Num_Items = Scanner_Input.nextInt();
        Scanner_Input.nextLine(); // consume the newline

        String[] Item_Names = new String[Num_Items];
        double[] Item_Prices = new double[Num_Items];
        double Total_Value = 0;

        // Input details for each item
        for (int i = 0; i < Num_Items; i++) {
            System.out.print("\nEnter the name of item " + (i + 1) + ": ");
            Item_Names[i] = Scanner_Input.nextLine();

            System.out.print("Enter the price of " + Item_Names[i] + " (in Robux): ");
            Item_Prices[i] = Scanner_Input.nextDouble();
            Scanner_Input.nextLine(); // consume the newline

            Total_Value += Item_Prices[i];
        }

        // Display the results
        System.out.println("\nRoblox Inventory Summary:");
        for (int i = 0; i < Num_Items; i++) {
            System.out.println("Item: " + Item_Names[i] + " | Price: " + Item_Prices[i] + " Robux");
        }

        System.out.println("\nTotal Value of Your Roblox Inventory: " + Total_Value + " Robux");

        Scanner_Input.close();
    }
}
