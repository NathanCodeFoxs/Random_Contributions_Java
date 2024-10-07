import java.util.Scanner;

public class Vending_Machine {

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        // Prices of the items
        int Soda_Price = 25;
        int Chips_Price = 15;
        int Chocolate_Price = 20;

        // Get initial balance from user
        System.out.print("Enter your initial balance: ");
        int Balance = Error_Int_Input(Scan);

        boolean Loop = true;

        while (Loop && Balance > 0) {
            // Display available items
            Display_Items(Soda_Price, Chips_Price, Chocolate_Price);

            // Get the item the user wants to buy
            int Choice = Error_Item_Choice(Scan);

            // Process the purchase
            Balance = Pocess_Purchase(Choice, Balance, Soda_Price, Chips_Price, Chocolate_Price);

            // Check if user wants to continue
            if (Balance > 0) {
                System.out.print("Do you want to buy another item? (yes/no): ");
                String Response = Error_Yes_No_Input(Scan);
                Loop = Response.equalsIgnoreCase("yes");
            } else {
                System.out.println("You have no remaining balance. Ending purchase.");
                break;
            }
        }

        System.out.println("Thank you for using the vending machine!");
        Scan.close();
    }

    // Method to display available items and prices
    public static void Display_Items(int Soda_Price, int Chips_Price, int Chocolate_Price) {
        System.out.println("Available items:");
        System.out.println("1. Soda - $" + Soda_Price);
        System.out.println("2. Chips - $" + Chips_Price);
        System.out.println("3. Chocolate - $" + Chocolate_Price);
    }

    // Method to process the purchase
    public static int Pocess_Purchase(int Choice, int Balance, int Soda_Price, int Chips_Price, int Chocolate_Price) {
        int Item_Price = 0;

        switch (Choice) {
            case 1:
                Item_Price = Soda_Price;
                break;
            case 2:
                Item_Price = Chips_Price;
                break;
            case 3:
                Item_Price = Chocolate_Price;
                break;
            default:
                System.out.println("Invalid choice. Please select a valid item.");
                return Balance; // Return the same balance if invalid choice
        }

        // Check if user has enough balance
        if (Balance >= Item_Price) {
            Balance -= Item_Price;
            System.out.println("Item purchased successfully! Your remaining balance is $" + Balance);
        } else {
            System.out.println("You don't have enough balance to buy this item.");
        }

        return Balance;
    }

    // Helper method to get valid item choice from the user
    public static int Error_Item_Choice(Scanner Scan) {
        int Choice = -1;
        boolean Loop_Error = false;

        while (!Loop_Error) {
            try {
                System.out.print("Enter the item number you want to buy: ");
                Choice = Scan.nextInt();

                // Check if choice is between 1 and 3
                if (Choice >= 1 && Choice <= 3) {
                    Loop_Error = true; // Valid input
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } catch (Exception Loop_Slot) {
                System.out.println("Invalid input. Please enter a number.");
                Scan.next(); // Clear the invalid input
            }
        }
        return Choice;
    }

    // Helper method to get valid yes/no input from the user
    public static String Error_Yes_No_Input(Scanner Scan) {
        String Response = "";
        boolean Loop_Error = false;

        while (!Loop_Error) {
            Response = Scan.next();

            // Check if response is yes or no
            if (Response.equalsIgnoreCase("yes") || Response.equalsIgnoreCase("no")) {
                Loop_Error = true; // Valid input
            } else {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            }
        }
        return Response;
    }

    // Helper method to get a valid integer input for the balance
    public static int Error_Int_Input(Scanner Scan) {
        int Number_Error = -1;
        boolean Loop_Error = false;

        while (!Loop_Error) {
            try {
                Number_Error = Scan.nextInt();
                Loop_Error = true; // Valid input
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Enter your initial balance: ");
                Scan.next(); // Clear the invalid input
            }
        }
        return Number_Error;
    }
}
