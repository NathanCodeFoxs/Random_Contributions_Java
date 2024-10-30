import java.util.Scanner;

public class 20_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        int Choice;

        System.out.println("---- Temperature Converter ----");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.print("Choose an option (1-6): ");
        Choice = Scanner_Input.nextInt();

        System.out.print("Enter the temperature to convert: ");
        double Input_Temp = Scanner_Input.nextDouble();
        double Converted_Temp;

        switch (Choice) {
            case 1:
                Converted_Temp = (Input_Temp * 9 / 5) + 32;
                System.out.println(Input_Temp + " °C is " + Converted_Temp + " °F");
                break;

            case 2:
                Converted_Temp = (Input_Temp - 32) * 5 / 9;
                System.out.println(Input_Temp + " °F is " + Converted_Temp + " °C");
                break;

            case 3:
                Converted_Temp = Input_Temp + 273.15;
                System.out.println(Input_Temp + " °C is " + Converted_Temp + " K");
                break;

            case 4:
                Converted_Temp = Input_Temp - 273.15;
                System.out.println(Input_Temp + " K is " + Converted_Temp + " °C");
                break;

            case 5:
                Converted_Temp = ((Input_Temp - 32) * 5 / 9) + 273.15;
                System.out.println(Input_Temp + " °F is " + Converted_Temp + " K");
                break;

            case 6:
                Converted_Temp = ((Input_Temp - 273.15) * 9 / 5) + 32;
                System.out.println(Input_Temp + " K is " + Converted_Temp + " °F");
                break;

            default:
                System.out.println("Invalid choice!");
                break;
        }

        Scanner_Input.close();
    }
}
