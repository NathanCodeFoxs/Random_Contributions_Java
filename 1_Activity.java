import java.util.Scanner;

public class Activity_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean Repeat = true;

        while (Repeat) {
            System.out.println("--- Educational Level System ---");
            System.out.print("Input your name here: ");
            String Name = scan.nextLine();
            System.out.print("Input your age here: ");
            int Age = scan.nextInt();
            scan.nextLine(); // Consume newline

            if (Age < 5 || Age > 100) {
                System.out.println("Error");
            } else if (Age >= 5 && Age <= 6) {
                System.out.println("Hello " + name + ", you are in kindergarten");
            } else if (Age >= 7 && Age <= 12) {
                System.out.println("Hello " + name + ", you are in elementary");
            } else if (Age >= 13 && Age <= 17) {
                System.out.println("Hello " + name + ", you are in junior high school");
            } else if (Age >= 18 && Age <= 19) {
                System.out.println("Hello " + name + ", you are in senior high school");
            } else if (Age >= 20 && Age <= 100) {
                System.out.println("Hello " + name + ", you are in college");
            }

            System.out.println();
            System.out.println("Do you want to enter details for another person? Yes(1) No(2)");
            String Again = scan.nextLine();

            if (Again.equals("1")) {
                continue;
            } else if (Again.equals("2")) {
                break;
            } else {
                System.out.println("1 or 2 Only");
                break;
            }
        }
    }
}
