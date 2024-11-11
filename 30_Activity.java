import java.util.Scanner;

public class 30_Activity {
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
