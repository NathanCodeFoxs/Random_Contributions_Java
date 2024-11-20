import java.util.HashMap;
import java.util.Scanner;

public class 35_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        HashMap<String, String> Weather_Data = new HashMap<>();
        boolean Is_Running = true;

        System.out.println("Welcome to the Weather Tracker!");

        while (Is_Running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Weather Data");
            System.out.println("2. View Weather for a City");
            System.out.println("3. View All Weather Data");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int Choice = Scanner_Input.nextInt();
            Scanner_Input.nextLine(); // consume newline

            switch (Choice) {
                case 1:
                    System.out.print("Enter the city name: ");
                    String City = Scanner_Input.nextLine();

                    System.out.print("Enter the temperature (°C): ");
                    String Temperature = Scanner_Input.nextLine();

                    System.out.print("Enter the humidity (%): ");
                    String Humidity = Scanner_Input.nextLine();

                    System.out.print("Enter the wind speed (km/h): ");
                    String Wind_Speed = Scanner_Input.nextLine();

                    String Weather_Info = "Temperature: " + Temperature + "°C, Humidity: " + Humidity + "%, Wind Speed: " + Wind_Speed + " km/h";
                    Weather_Data.put(City, Weather_Info);
                    System.out.println("Weather data for " + City + " has been added!");
                    break;

                case 2:
                    System.out.print("Enter the city name to view weather: ");
                    String City_Name = Scanner_Input.nextLine();
                    if (Weather_Data.containsKey(City_Name)) {
                        System.out.println("Weather for " + City_Name + ": " + Weather_Data.get(City_Name));
                    } else {
                        System.out.println("No weather data found for " + City_Name + ".");
                    }
                    break;

                case 3:
                    if (Weather_Data.isEmpty()) {
                        System.out.println("No weather data available.");
                    } else {
                        System.out.println("\nAll Weather Data:");
                        for (String Key : Weather_Data.keySet()) {
                            System.out.println(Key + ": " + Weather_Data.get(Key));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Weather Tracker. Stay updated!");
                    Is_Running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        Scanner_Input.close();
    }
}
