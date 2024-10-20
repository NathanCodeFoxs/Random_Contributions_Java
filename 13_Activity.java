import java.util.Scanner;

public class 13_Activity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Unit Converter!");
            System.out.println("Choose a conversion type:");
            System.out.println("1. Length (Meters to Feet)");
            System.out.println("2. Weight (Kilograms to Pounds)");
            System.out.println("3. Temperature (Celsius to Fahrenheit)");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value in meters: ");
                    double meters = scanner.nextDouble();
                    double feet = metersToFeet(meters);
                    System.out.println(meters + " meters is " + feet + " feet.");
                    break;
                case 2:
                    System.out.print("Enter the value in kilograms: ");
                    double kilograms = scanner.nextDouble();
                    double pounds = kilogramsToPounds(kilograms);
                    System.out.println(kilograms + " kilograms is " + pounds + " pounds.");
                    break;
                case 3:
                    System.out.print("Enter the temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = celsiusToFahrenheit(celsius);
                    System.out.println(celsius + "°C is " + fahrenheit + "°F.");
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the Unit Converter. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1, 2, 3, or 4.");
            }
            System.out.println();
        }
        scanner.close();
    }

    // Conversion methods
    public static double metersToFeet(double meters) {
        return meters * 3.28084; // 1 meter = 3.28084 feet
    }

    public static double kilogramsToPounds(double kilograms) {
        return kilograms * 2.20462; // 1 kilogram = 2.20462 pounds
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32; // Conversion formula for Celsius to Fahrenheit
    }
}
