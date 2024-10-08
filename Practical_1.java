import javax.swing.JOptionPane;

public class Practical_1 {
    public static void main(String[] args) {
        // Arrays for main menu and submission options
        String[] USER_Options = { "Register", "Login", "Exit" }; //Line 25
        String[] USER_Submit_Cancel = { "Submit", "Cancel" }; //Line 43
        String[] Payment_Options = { "Cash", "Credit Card" }; //Line 171
        String[] Payment_Options_2 = { "Cash Payment", "Cashless1"};
        String[] Checkout_Options = {"Check out", "Cancel"};

        // Array to store user info
        String[] USER_Registration_Info = new String[4]; //Line 46

        // Arrays to store purchased items details
        String[] Bought_Items = new String[100]; //Line 156
        int[] Bought_Quantities = new int[100]; //Line 157
        double[] Bought_Prices = new double[100]; //Line 158
        int Purchase_Count = 0; //Line 160

        // Loop control variable
        boolean Continue_Loop = true;

        // Display the main menu
        while (Continue_Loop) { // 1
            int USER_Choice = JOptionPane.showOptionDialog(null, "Welcome to the Shop", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, USER_Options, USER_Options[0]);

            if (USER_Choice == 0) { // Register // 2
                String USER_Username = JOptionPane.showInputDialog(null, "Enter your Username:", "Input",
                        JOptionPane.INFORMATION_MESSAGE);
                String USER_Fullname = JOptionPane.showInputDialog(null, "Enter your Full Name:", "Input",
                        JOptionPane.INFORMATION_MESSAGE);
                String USER_Contact_No = JOptionPane.showInputDialog(null, "Enter your Contact No:", "Input",
                        JOptionPane.INFORMATION_MESSAGE);
                String USER_Password = JOptionPane.showInputDialog(null, "Create your Password:", "Input",
                        JOptionPane.INFORMATION_MESSAGE);
                
                // Check if any of the input fields are empty
                if (USER_Username.isEmpty() || USER_Fullname.isEmpty() || USER_Contact_No.isEmpty() || USER_Password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter all required information!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    // Optionally, you can add further handling here (e.g., returning or continuing)
                } else {
                    int USER_Register_Final = JOptionPane.showOptionDialog(null,
                            "Review your information before proceeding:\n" + "Username: " + USER_Username + "\n"
                            + "Full Name: " + USER_Fullname + "\n" + "Contact No: " + USER_Contact_No + "\n"
                            + "Password: " + USER_Password + "\n"
                            + "Are you sure you want to register with these details?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, USER_Submit_Cancel,
                USER_Submit_Cancel[0]);

                if (USER_Register_Final == JOptionPane.YES_OPTION) {
                    USER_Registration_Info[0] = USER_Username;
                    USER_Registration_Info[1] = USER_Fullname;
                    USER_Registration_Info[2] = USER_Contact_No;
                    USER_Registration_Info[3] = USER_Password;
                    JOptionPane.showMessageDialog(null, "Registration Successful", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Registration Cancelled", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        
            } else if (USER_Choice == 1) { // Login 
                if (USER_Registration_Info[0] == null) { //USER_Error Handling
                    JOptionPane.showMessageDialog(null, "You need to register first!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // Reset shopping cart arrays
                    Bought_Items = new String[100];
                    Bought_Quantities = new int[100];
                    Bought_Prices = new double[100];
                    Purchase_Count = 0;
                        // 3
                    String USER_Login_Username = JOptionPane.showInputDialog(null, "Enter your Username:", "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    String USER_Login_Password = JOptionPane.showInputDialog(null, "Enter your Password:", "Login",
                            JOptionPane.INFORMATION_MESSAGE);

                    if (USER_Login_Username.equals(USER_Registration_Info[0])
                            && USER_Login_Password.equals(USER_Registration_Info[3])) {
                        JOptionPane.showMessageDialog(null, "Login Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                                // 4
                        // Define categories and items grouped by categories
                        String[] Grocery_Section = { 
                            "Fruits and Vegetables", 
                            "Frozen Meats", 
                            "Canned/ Jarred Goods",
                            "Dairy and Baking Goods", 
                            "Beverage", 
                            "Personal Care and Cleaners" };
                        //Item Buttins                
                        //String[]
                        // Items Grouped By Categories
                        String[][] ItemsByCategory = {
                                // Fruits and Vegetables
                                { "Apple", "Banana", "Tomato", "Potato", "Strawberry" },
                                // Frozen Meats
                                { "Fish", "Pork Meat", "Chicken", "Beef Meat" },
                                // Canned/ Jarred Goods
                                { "555 Tuna", "Argentina Corned Beef", "Maling", "Silver Swan", "UFC Ketchup", "Wow Ulam", "Spam", "San Marino" },
                                // Dairy and Baking Goods
                                { "Butter", "Star Margarine", "Flour" },
                                // Beverage
                                { "Gin", "Zest-o", "Vita Milk", "Cobra", "Bearbrand Sterilized", "Red Horse" },
                                // Personal Care and Cleaners
                                { "Tissue", "Joy", "Safeguard", "Mr. Clean (bar)", "Downy", "Tender Care (powder)", "Modess", "Gatsby" } };

                        // Prices Grouped By Categories (Corresponding To ItemsByCategory)
                        double[][] PricesByCategory = {
                                // Fruits and Vegetables
                                { 20.50, 8.00, 150.75, 90.00, 206.50 },
                                // Frozen Meats
                                { 250.75, 170.00, 180.50, 500.25 },
                                // Canned/ Jarred Goods
                                { 25.25, 30.75, 53.00, 15.75, 11.50, 23.00, 109.50, 30.75 },
                                // Dairy and Baking Goods
                                { 35.25, 30.75, 40.00 },
                                // Beverage
                                { 42.75, 12.00, 35.00, 24.50, 38.25, 110.00 },
                                // Personal Care and Cleaners
                                { 11.50, 10.00, 19.75, 27.25, 15.00, 21.00, 47.25, 50.75 } };

                        // Units Grouped By Categories (Corresponding To ItemsByCategory)
                        String[][] UnitsByCategory = {
                                // Fruits and Vegetables
                                { "1 piece", "1 piece", "1 kilo", "½ kilo", "¼ kilo" },
                                // Frozen Meats
                                { "1 kilo", "1 kilo", "1 kilo", "1 kilo" },
                                // Canned/ Jarred Goods
                                { "1 piece", "1 piece", "1 piece", "1 piece", "1 piece", "1 piece", "1 piece", "1 piece" },
                                // Dairy and Baking Goods
                                { "1 piece", "1 piece", "1 kilo" },
                                // Beverage
                                { "1 piece", "1 piece", "1 piece", "1 piece", "1 piece", "1 piece" },
                                // Personal Care and Cleaners
                                { "1 piece", "1 piece", "1 piece", "1 piece", "1 piece", "1 piece", "1 pack (8 pcs)", "1 piece" } };

                        boolean Shopping_USER = true;
                        double Total_Cost = 0.0;

                        while (Shopping_USER) { // 5
                            int Category_Choice = JOptionPane.showOptionDialog(null,
                                    "Select a category to shop from", "Store", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.PLAIN_MESSAGE, null, Grocery_Section, Grocery_Section[0]);
                                
                            if (Category_Choice == -1) { //USER_Error Handling
                                break;
                            }
                                // 5 (A)
                            int Item_Choice = JOptionPane.showOptionDialog(null, "Select an item to buy", "Items",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                    ItemsByCategory[Category_Choice], ItemsByCategory[Category_Choice][0]);
                                
                            if (Item_Choice == -1) { //USER_Error Handling
                                break;
                            }
                            //Quantity // 5 (B)
                            String Quantity_String = JOptionPane.showInputDialog(null,
                                    "Enter quantity for " + ItemsByCategory[Category_Choice][Item_Choice] + " = " + PricesByCategory[Category_Choice][Item_Choice] + " ("
                                            + UnitsByCategory[Category_Choice][Item_Choice]  + "):",
                                    "Quantity", JOptionPane.INFORMATION_MESSAGE);
                            int Quantity = Integer.parseInt(Quantity_String);

                                Bought_Items[Purchase_Count] = ItemsByCategory[Category_Choice][Item_Choice]; //Stores the item chosen based on Category_Choice and Item_Choice
                                Bought_Quantities[Purchase_Count] = Quantity; //Records the quantity of the item purchased.
                                Bought_Prices[Purchase_Count] = PricesByCategory[Category_Choice][Item_Choice] * Quantity; //Calculates the total cost of the purchase by multiplying the item's price by the quantity purchased.
                                Total_Cost += Bought_Prices[Purchase_Count]; //Accumulates the total cost by adding the current purchase's total price.
                                Purchase_Count++; //Increments to keep track of the number of purchases made.

                            // Add to Cart //Quantity 
                            String Continue_Shop_AddedToCart = "Added To Cart";
                            JOptionPane.showMessageDialog(null, Continue_Shop_AddedToCart, "Added To Cart", JOptionPane.INFORMATION_MESSAGE);

                            // 5 (C and D)
                            int Continue_Shopping = JOptionPane.showConfirmDialog(null,
                                    "Do you want to add another item?", "Continue", JOptionPane.YES_NO_OPTION);
                            if (Continue_Shopping == JOptionPane.NO_OPTION) {
                                // 6
                                int Checkout_Shpping = JOptionPane.showOptionDialog(null, "Proceed to Checkout?", "Checkout",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Checkout_Options,
                                Checkout_Options[0]);
                                if(Checkout_Shpping == 0){
                                        Shopping_USER = false;
                                }
                            }
                        }
                        // Check Out List 7
                        String Checkout_list = "\nItems Price Quantity Total\n";
                        for (int i = 0; i < Purchase_Count; i++) {
                                Checkout_list += Bought_Items[i] + "  " + Bought_Prices[i] / Bought_Quantities[i] + "  " + Bought_Quantities[i] + "  " + Bought_Prices[i] + "\n";
                            }
                            Checkout_list += "Total Cost: " + Total_Cost + "\n";
                            JOptionPane.showMessageDialog(null, Checkout_list, "Lists", JOptionPane.INFORMATION_MESSAGE);

                        int Payment_Choice = JOptionPane.showOptionDialog(null, "Choose payment method", "Payment",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Payment_Options,
                                Payment_Options[0]);

                        if (Payment_Choice != JOptionPane.CLOSED_OPTION) {
                            String Payment_Method = Payment_Options[Payment_Choice];
                            String Payment_Method_2 = Payment_Options_2[Payment_Choice];
                            
                                // Calculate total quantity
                                int Total_Quantity = 0;
                                for (int i = 0; i < Purchase_Count; i++) {      
                                Total_Quantity += Bought_Quantities[i];
                                }
                            // Prepare receipt
                            String Receipt = Payment_Method_2 + "\nItems Price Quantity Total\n";
                            for (int i = 0; i < Purchase_Count; i++) {
                                Receipt += Bought_Items[i] + "  " + Bought_Prices[i] / Bought_Quantities[i] + "  " + Bought_Quantities[i] + "  " + Bought_Prices[i] + "\n";
                            }

                            // Display total quantity and total cost (Credit Card)
                            Receipt += "\nTotal Quantity: " + Total_Quantity + "\n";
                            Receipt += "Total Cost: " + Total_Cost + "\n";
                            if(Payment_Method == "Credit Card") {
                            Receipt += "Paid with " + Payment_Method + "\n";
                            }
                            // Handle Cash payment method
                            if (Payment_Method.equals("Cash")) {
                                String Amount_PaidString = JOptionPane.showInputDialog(null, "Enter amount paid:",
                                        "Cash Payment", JOptionPane.INFORMATION_MESSAGE);
                                double Amount_Paid = Double.parseDouble(Amount_PaidString);

                                double Change = Amount_Paid - Total_Cost;
                                Receipt += "Cash: " + Amount_Paid + "\n";
                                Receipt += "Change: " + Change + "\n";
                            }
                            // 8 
                            // Display receipt
                            JOptionPane.showMessageDialog(null, Receipt, "Receipt", JOptionPane.INFORMATION_MESSAGE);

                            //Thank you
                            String Thank_you = "Thank you";
                            JOptionPane.showMessageDialog(null, Thank_you, "Thank you", JOptionPane.INFORMATION_MESSAGE);

                            int Repeat_Shopping = JOptionPane.showConfirmDialog(null, //9
                            "Wnat to make another transaction?", "Shop Again?", JOptionPane.YES_NO_OPTION);
                          if(Repeat_Shopping == JOptionPane.NO_OPTION) {
                                Continue_Loop = false;
                            } else {
                                Continue_Loop = true;
                            }

                        }

                    } else { //USER_Error Handling
                        JOptionPane.showMessageDialog(null, "Login Failed. Incorrect Username or Password.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (USER_Choice == 2) { // Exit
                Continue_Loop = false;
            } else { //USER_Error Handling
                JOptionPane.showMessageDialog(null, "Invalid Choice", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
