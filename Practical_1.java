import javax.swing.*;

public class Practical_1 {
    public static void main(String[] args) {
        // Arrays for main menu and submission options
        String[] USER_Options = { "Register", "Login", "Exit" };
        String[] USER_Submit_Cancel = { "Submit", "Cancel" };
        String[] Payment_Options = { "Cash", "Credit Card" };
        String[] Payment_Options_2 = { "Cash Payment", "Credit Card Payment" };

        // Array to store user info
        String[] USER_Registration_Info = new String[4];

        // Arrays to store purchased items details
        String[] Bought_Items = new String[100];
        int[] Bought_Quantities = new int[100];
        double[] Bought_Prices = new double[100];
        int Purchase_Count = 0;

        // Loop control variable
        boolean Continue_Loop = true;

        // Display the main menu
        while (Continue_Loop) {
            int USER_Choice = JOptionPane.showOptionDialog(null, "Welcome to the Shop", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, USER_Options, USER_Options[0]);

            if (USER_Choice == 0) { // Register
                registerUser(USER_Registration_Info, USER_Submit_Cancel);
            } else if (USER_Choice == 1) { // Login
                String registeredUsername = USER_Registration_Info[0];
                String registeredPassword = USER_Registration_Info[3];

                if (registeredUsername == null) {
                    JOptionPane.showMessageDialog(null, "You need to register first!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean loginSuccess = loginUser(registeredUsername, registeredPassword);

                    if (loginSuccess) {
                        shoppingProcess(Bought_Items, Bought_Quantities, Bought_Prices, Payment_Options, Purchase_Count);
                        Continue_Loop = false; // Exit the loop after shopping
                    }
                }
            } else if (USER_Choice == 2) { // Exit
                Continue_Loop = false;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Choice", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void registerUser(String[] userInfo, String[] submitCancel) {
        String username = JOptionPane.showInputDialog(null, "Enter your Username:", "Register", JOptionPane.INFORMATION_MESSAGE);
        String fullName = JOptionPane.showInputDialog(null, "Enter your Full Name:", "Register", JOptionPane.INFORMATION_MESSAGE);
        String contactNo = JOptionPane.showInputDialog(null, "Enter your Contact No:", "Register", JOptionPane.INFORMATION_MESSAGE);
        String password = JOptionPane.showInputDialog(null, "Create your Password:", "Register", JOptionPane.INFORMATION_MESSAGE);

        int registerChoice = JOptionPane.showOptionDialog(null, "Review your information before proceeding:\n" +
                        "Username: " + username + "\nFull Name: " + fullName + "\nContact No: " + contactNo + "\n" +
                        "Password: " + password + "\n" +
                        "Are you sure you want to register with these details?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, submitCancel, submitCancel[0]);

        if (registerChoice == JOptionPane.YES_OPTION) {
            userInfo[0] = username;
            userInfo[1] = fullName;
            userInfo[2] = contactNo;
            userInfo[3] = password;
            JOptionPane.showMessageDialog(null, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Registration Cancelled", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean loginUser(String registeredUsername, String registeredPassword) {
        String loginUsername = JOptionPane.showInputDialog(null, "Enter your Username:", "Login", JOptionPane.INFORMATION_MESSAGE);
        String loginPassword = JOptionPane.showInputDialog(null, "Enter your Password:", "Login", JOptionPane.INFORMATION_MESSAGE);

        if (loginUsername.equals(registeredUsername) && loginPassword.equals(registeredPassword)) {
            JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private static void shoppingProcess(String[] boughtItems, int[] boughtQuantities, double[] boughtPrices, String[] paymentOptions, int purchaseCount) {
        String[] grocerySections = { "Fruits and Vegetables", "Frozen Meats", "Canned/ Jarred Goods", "Beverage", "Personal Care" };

        String[][] itemsByCategory = {
                { "Apple", "Banana", "Tomato", "Potato", "Strawberry" },
                { "Fish", "Pork Meat", "Chicken", "Beef Meat" },
                { "555 Tuna", "Argentina Corned Beef", "Maling", "Silver Swan", "UFC Ketchup", "Wow Ulam", "Spam", "San Marino" },
                { "Gin", "Zest-o", "Vita Milk", "Cobra", "Bearbrand Sterilized", "Red Horse" },
                { "Tissue", "Joy", "Safeguard", "Mr. Clean (bar)", "Downy", "Tender Care (powder)", "Modess", "Gatsby" }
        };

        double[][] pricesByCategory = {
                { 20.50, 8.00, 150.75, 90.00, 206.50 },
                { 250.75, 170.00, 180.50, 500.25 },
                { 25.25, 30.75, 53.00, 15.75, 11.50, 23.00, 109.50, 30.75 },
                { 42.75, 12.00, 35.00, 24.50, 38.25, 110.00 },
                { 11.50, 10.00, 19.75, 27.25, 15.00, 21.00, 47.25, 50.75 }
        };

        boolean shopping = true;
        double totalCost = 0.0;

        while (shopping) {
            int categoryChoice = JOptionPane.showOptionDialog(null, "Select a category to shop from", "Store",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, grocerySections, grocerySections[0]);

            if (categoryChoice == -1) {
                break;
            }

            int itemChoice = JOptionPane.showOptionDialog(null, "Select an item to buy", "Items",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, itemsByCategory[categoryChoice], itemsByCategory[categoryChoice][0]);

            if (itemChoice == -1) {
                break;
            }

            String quantityString = JOptionPane.showInputDialog(null,
                    "Enter quantity for " + itemsByCategory[categoryChoice][itemChoice] + " = " +
                            pricesByCategory[categoryChoice][itemChoice] + " each:", "Quantity", JOptionPane.INFORMATION_MESSAGE);
            int quantity = Integer.parseInt(quantityString);

            boughtItems[purchaseCount] = itemsByCategory[categoryChoice][itemChoice];
            boughtQuantities[purchaseCount] = quantity;
            boughtPrices[purchaseCount] = pricesByCategory[categoryChoice][itemChoice] * quantity;
            totalCost += boughtPrices[purchaseCount];
            purchaseCount++;

            JOptionPane.showMessageDialog(null, "Added To Cart", "Added To Cart", JOptionPane.INFORMATION_MESSAGE);

            int continueShopping = JOptionPane.showConfirmDialog(null, "Do you want to add another item?", "Continue", JOptionPane.YES_NO_OPTION);
            if (continueShopping == JOptionPane.NO_OPTION) {
                shopping = false;
            }
        }

        proceedToCheckout(boughtItems, boughtQuantities, boughtPrices, totalCost, paymentOptions);
    }

    private static void proceedToCheckout(String[] boughtItems, int[] boughtQuantities, double[] boughtPrices, double totalCost, String[] paymentOptions) {
        int checkoutChoice = JOptionPane.showOptionDialog(null, "Do you want to proceed to checkout?", "Checkout",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Checkout", "Cancel"}, "Checkout");

        if (checkoutChoice == JOptionPane.YES_OPTION) {
            checkoutProcess(boughtItems, boughtQuantities, boughtPrices, totalCost, paymentOptions);
        } else {
            JOptionPane.showMessageDialog(null, "Returning to main menu", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void checkoutProcess(String[] boughtItems, int[] boughtQuantities, double[] boughtPrices, double totalCost, String[] paymentOptions) {
        int paymentChoice = JOptionPane.showOptionDialog(null, "Choose payment method", "Payment",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, paymentOptions, paymentOptions[0]);

        if (paymentChoice != JOptionPane.CLOSED_OPTION) {
            String paymentMethod = paymentOptions[paymentChoice];
            String paymentMethodDesc = Payment_Options_2[paymentChoice]; // Payment method description

            // Prepare receipt
            StringBuilder receipt = new StringBuilder(paymentMethodDesc + "\nItems Price Quantity Total\n");
            for (int i = 0; i < boughtItems.length; i++) {
                if (boughtItems[i] != null) {
                    receipt.append(boughtItems[i]).append("  ").append(String.format("%.2f", boughtPrices[i] / boughtQuantities[i])).append("  ");
                    receipt.append("%.2f", boughtPrices[i]).append("\n");
                }
            }

            // Calculate total quantity
            int totalQuantity = 0;
            for (int i = 0; i < boughtItems.length; i++) {
                if (boughtItems[i] != null) {
                    totalQuantity += boughtQuantities[i];
                }
            }

            // Display total quantity and total cost
            receipt.append("\nTotal Quantity: ").append(totalQuantity).append("\n");
            receipt.append("Total Cost: ").append(String.format("%.2f", totalCost)).append("\n");

            // Handle Cash payment method
            if (paymentMethod.equals("Cash")) {
                String amountPaidString = JOptionPane.showInputDialog(null, "Enter amount paid:", "Cash Payment", JOptionPane.INFORMATION_MESSAGE);
                double amountPaid = Double.parseDouble(amountPaidString);

                double change = amountPaid - totalCost;
                receipt.append("Cash: ").append(amountPaid).append("\n");
                receipt.append("Change: ").append(String.format("%.2f", change)).append("\n");
            }

            // Display receipt
            JOptionPane.showMessageDialog(null, receipt.toString(), "Receipt", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Payment Cancelled", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
