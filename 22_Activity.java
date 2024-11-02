import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String Name;
    String Phone_Number;

    public Contact(String Name, String Phone_Number) {
        this.Name = Name;
        this.Phone_Number = Phone_Number;
    }
}

public class 23_Activity {
    public static void main(String[] args) {
        ArrayList<Contact> Contacts = new ArrayList<>();
        Scanner Scanner_Input = new Scanner(System.in);
        int Choice;

        do {
            System.out.println("\n--- Contact Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            Choice = Scanner_Input.nextInt();
            Scanner_Input.nextLine(); // Consume newline

            switch (Choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String Name = Scanner_Input.nextLine();
                    System.out.print("Enter phone number: ");
                    String Phone_Number = Scanner_Input.nextLine();
                    Contacts.add(new Contact(Name, Phone_Number));
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.println("\n--- Contact List ---");
                    for (Contact Contact : Contacts) {
                        System.out.println("Name: " + Contact.Name + ", Phone: " + Contact.Phone_Number);
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String Search_Name = Scanner_Input.nextLine();
                    boolean Found = false;
                    for (Contact Contact : Contacts) {
                        if (Contact.Name.equalsIgnoreCase(Search_Name)) {
                            System.out.println("Found: " + Contact.Name + ", Phone: " + Contact.Phone_Number);
                            Found = true;
                            break;
                        }
                    }
                    if (!Found) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Contact Book...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (Choice != 4);

        Scanner_Input.close();
    }
}
