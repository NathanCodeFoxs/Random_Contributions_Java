import java.util.Scanner;

public class 16_Activity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validPassword = false;

        System.out.println("Welcome to the Simple Password Validator!");

        while (!validPassword) {
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();

            if (isValidPassword(password)) {
                System.out.println("Password is valid!");
                validPassword = true;
            } else {
                System.out.println("Invalid password. Please follow the password rules:");
                System.out.println("1. At least 8 characters long.");
                System.out.println("2. Must contain at least one uppercase letter.");
                System.out.println("3. Must contain at least one lowercase letter.");
                System.out.println("4. Must contain at least one digit.");
                System.out.println("5. Must contain at least one special character (!@#$%^&*).");
            }
        }

        scanner.close();
    }

    // Method to validate the password based on the rules
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if ("!@#$%^&*".contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        // Return true if all conditions are met
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }
}
