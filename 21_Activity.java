import java.util.Random;
import java.util.Scanner;

public class 22_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        System.out.print("Enter the length of the password: ");
        int Password_Length = Scanner_Input.nextInt();
        
        String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        StringBuilder Password = new StringBuilder();
        Random Random_Generator = new Random();
        
        for (int i = 0; i < Password_Length; i++) {
            int Index = Random_Generator.nextInt(Characters.length());
            Password.append(Characters.charAt(Index));
        }
        
        System.out.println("Generated Password: " + Password);
        Scanner_Input.close();
    }
}
