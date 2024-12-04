import java.util.Scanner;

public class 44_Activity {

    // Method to encrypt a message using a Caesar Cipher
    public static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                encrypted.append((char) ((character - base + key) % 26 + base));
            } else {
                encrypted.append(character); // Non-alphabetic characters remain unchanged
            }
        }

        return encrypted.toString();
    }

    // Method to decrypt a message using a Caesar Cipher
    public static String decrypt(String message, int key) {
        return encrypt(message, 26 - (key % 26)); // Decryption reverses encryption
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Encryption and Decryption Tool!");
        System.out.println("1. Encrypt a message");
        System.out.println("2. Decrypt a message");
        System.out.println("3. Exit");

        while (true) {
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the message to encrypt: ");
                    String messageToEncrypt = scanner.nextLine();
                    System.out.print("Enter the encryption key (1-25): ");
                    int encryptionKey = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.println("Encrypted Message: " + encrypt(messageToEncrypt, encryptionKey));
                    break;

                case 2:
                    System.out.print("Enter the message to decrypt: ");
                    String messageToDecrypt = scanner.nextLine();
                    System.out.print("Enter the decryption key (1-25): ");
                    int decryptionKey = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.println("Decrypted Message: " + decrypt(messageToDecrypt, decryptionKey));
                    break;

                case 3:
                    System.out.println("Exiting the tool. Stay secure!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
