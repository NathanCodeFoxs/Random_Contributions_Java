import java.util.Scanner;

public class 28_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);

        System.out.println("Chatbot: Hi! I am your friendly chatbot. Type 'exit' to end the conversation.");
        while (true) {
            System.out.print("You: ");
            String User_Input = Scanner_Input.nextLine().toLowerCase();

            if (User_Input.equals("exit")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            } else if (User_Input.contains("hello") || User_Input.contains("hi")) {
                System.out.println("Chatbot: Hello there! How can I help you today?");
            } else if (User_Input.contains("how are you")) {
                System.out.println("Chatbot: I'm just a bunch of code, but thanks for asking!");
            } else if (User_Input.contains("name")) {
                System.out.println("Chatbot: I’m Chatbot, your virtual assistant.");
            } else if (User_Input.contains("joke")) {
                System.out.println("Chatbot: Why did the programmer quit his job? Because he didn't get arrays!");
            } else {
                System.out.println("Chatbot: Sorry, I didn't understand that. Can you try again?");
            }
        }
        Scanner_Input.close();
    }
}
