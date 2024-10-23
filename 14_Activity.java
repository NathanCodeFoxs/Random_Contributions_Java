import java.util.ArrayList;
import java.util.Scanner;

public class 14_Activity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        boolean exit = false;

        System.out.println("Welcome to the Simple E-Commerce Shopping Cart!");

        while (!exit) {
            System.out.println("\n1. Add Item to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Remove Item from Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String item = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    cart.add(item);
                    prices.add(price);
                    System.out.println(item + " added to cart at $" + price);
                    break;

                case 2:
                    System.out.println("\n--- Your Shopping Cart ---");
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty!");
                    } else {
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.println((i + 1) + ". " + cart.get(i) + " - $" + prices.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Remove Item from Cart ---");
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty, nothing to remove!");
                    } else {
                        System.out.print("Enter the item number to remove: ");
                        int itemNumber = scanner.nextInt();
                        if (itemNumber > 0 && itemNumber <= cart.size()) {
                            System.out.println(cart.get(itemNumber - 1) + " removed from cart.");
                            cart.remove(itemNumber - 1);
                            prices.remove(itemNumber - 1);
                        } else {
                            System.out.println("Invalid item number.");
                        }
                    }
                    break;

                case 4:
                    double totalPrice = 0;
                    System.out.println("\n--- Checkout ---");
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty!");
                    } else {
                        System.out.println("Items in your cart:");
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.println(cart.get(i) + " - $" + prices.get(i));
                            totalPrice += prices.get(i);
                        }
                        System.out.println("Total Price: $" + totalPrice);
                        System.out.println("Thank you for shopping with us!");
                        cart.clear();
                        prices.clear();
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thank you for visiting! Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please choose between 1 and 5.");
            }
        }

        scanner.close();
    }
}
