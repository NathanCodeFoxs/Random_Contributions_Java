import java.util.Scanner;

public class 39_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);

        // Pet stats
        int Hunger = 50; // 0 (full) to 100 (starving)
        int Happiness = 50; // 0 (sad) to 100 (happy)
        int Energy = 50; // 0 (tired) to 100 (energetic)

        System.out.println("Welcome to the Virtual Pet Simulator!");
        System.out.println("Take care of your pet by managing its hunger, happiness, and energy.");
        System.out.println("If any stat reaches 100 or 0, your pet might leave or get sad. Keep it balanced!");
        System.out.println();

        boolean Is_Playing = true;

        while (Is_Playing) {
            System.out.println("Current Stats:");
            System.out.println("Hunger: " + Hunger + "/100");
            System.out.println("Happiness: " + Happiness + "/100");
            System.out.println("Energy: " + Energy + "/100");
            System.out.println();

            System.out.println("What would you like to do?");
            System.out.println("1. Feed your pet (-10 Hunger, +5 Energy)");
            System.out.println("2. Play with your pet (+10 Happiness, -5 Energy)");
            System.out.println("3. Let your pet rest (+10 Energy, +5 Hunger)");
            System.out.println("4. Quit the game");
            System.out.print("Enter your choice: ");
            int Choice = Scanner_Input.nextInt();

            switch (Choice) {
                case 1:
                    Hunger = Math.max(0, Hunger - 10);
                    Energy = Math.min(100, Energy + 5);
                    System.out.println("You fed your pet! It's less hungry now.");
                    break;
                case 2:
                    Happiness = Math.min(100, Happiness + 10);
                    Energy = Math.max(0, Energy - 5);
                    System.out.println("You played with your pet! It's happier now.");
                    break;
                case 3:
                    Energy = Math.min(100, Energy + 10);
                    Hunger = Math.min(100, Hunger + 5);
                    System.out.println("Your pet rested! It's more energetic now.");
                    break;
                case 4:
                    System.out.println("Thanks for playing! Goodbye!");
                    Is_Playing = false;
                    continue;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    continue;
            }

            // Check for game over conditions
            if (Hunger == 100) {
                System.out.println("\nYour pet is starving! It has run away in search of food...");
                Is_Playing = false;
            } else if (Happiness == 0) {
                System.out.println("\nYour pet is too sad to stay. It has wandered off...");
                Is_Playing = false;
            } else if (Energy == 0) {
                System.out.println("\nYour pet is too tired to do anything. Let it rest more next time.");
                Is_Playing = false;
            }
        }

        System.out.println("Game over. Take better care of your pet next time!");
        Scanner_Input.close();
    }
}
