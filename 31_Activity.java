import java.util.Scanner;

public class 31_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);

        System.out.print("Enter your Roblox username: ");
        String Username = Scanner_Input.nextLine();

        System.out.print("Enter your Roblox password: ");
        String Password = Scanner_Input.nextLine();

        // Check password strength
        boolean Has_Number = false, Has_Special_Char = false;
        for (char c : Password.toCharArray()) {
            if (Character.isDigit(c)) Has_Number = true;
            if ("!@#$%^&*()_+<>?".contains(String.valueOf(c))) Has_Special_Char = true;
        }

        if (Password.length() >= 8 && Has_Number && Has_Special_Char) {
            System.out.println("Good job, " + Username + "! Your Roblox password is strong. Stay safe online! 🔒");
        } else {
            System.out.println("Hey " + Username + ", your password is weak. Consider using at least 8 characters with numbers and special characters!");
        }

        Scanner_Input.close();
    }
}
Explanation:
Username & Password Input: User enters their Roblox username and password.
Password Strength Check: Ensures the password is at least 8 characters long, includes numbers, and contains special characters.
Feedback: Provides feedback on the security of the entered password.
Let me know if you’d like another unique idea for 31_Activity!






You said:
This is 31

import java.util.Scanner;

// Base class: Vehicle
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    // Constructor
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Method to display vehicle details (overridden in subclasses)
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

// Subclass for Car
class Car extends Vehicle {
    private int numDoors;

    // Constructor for Car
    public Car(String brand, String model, int year, int numDoors) {
        super(brand, model, year);
        this.numDoors = numDoors;
    }

    // Overriding the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors);
    }
}

// Subclass for Motorbike
class Motorbike extends Vehicle {
    private boolean hasSidecar;

    // Constructor for Motorbike
    public Motorbike(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }

    // Overriding the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

// Main class
public class VehicleInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Car
        System.out.println("Car Information:");
        System.out.print("Enter the brand of the car: ");
        String carBrand = scanner.nextLine();
        System.out.print("Enter the model of the car: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter the year of the car: ");
        int carYear = scanner.nextInt();
        System.out.print("Enter the number of doors of the car: ");
        int carDoors = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        // Create Car object
        Car car = new Car(carBrand, carModel, carYear, carDoors);

        // Input for Motorbike
        System.out.println("\nMotorbike Information:");
        System.out.print("Enter the brand of the motorbike: ");
        String bikeBrand = scanner.nextLine();
        System.out.print("Enter the model of the motorbike: ");
        String bikeModel = scanner.nextLine();
        System.out.print("Enter the year of the motorbike: ");
        int bikeYear = scanner.nextInt();
        System.out.print("Does the motorbike have a sidecar? (true/false): ");
        boolean hasSidecar = scanner.nextBoolean();

        // Create Motorbike object
        Motorbike motorbike = new Motorbike(bikeBrand, bikeModel, bikeYear, hasSidecar);

        // Display information
        System.out.println("\nObject Creation and Display:");
        System.out.println("Car Information:");
        car.displayInfo();

        System.out.println("\nMotorbike Information:");
        motorbike.displayInfo();

        scanner.close();
    }
}
