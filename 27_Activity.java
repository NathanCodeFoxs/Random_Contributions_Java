import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String Title;
    String Author;
    boolean Is_Available;

    public Book(String Title, String Author) {
        this.Title = Title;
        this.Author = Author;
        this.Is_Available = true;
    }
}

public class 27_Activity {
    public static void main(String[] args) {
        ArrayList<Book> Library = new ArrayList<>();
        Scanner Scanner_Input = new Scanner(System.in);
        int Choice;

        do {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            Choice = Scanner_Input.nextInt();
            Scanner_Input.nextLine(); // Consume newline

            switch (Choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String Title = Scanner_Input.nextLine();
                    System.out.print("Enter Author Name: ");
                    String Author = Scanner_Input.nextLine();
                    Library.add(new Book(Title, Author));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.println("\n--- Book List ---");
                    for (Book B : Library) {
                        System.out.println("Title: " + B.Title + ", Author: " + B.Author + ", Available: " + (B.Is_Available ? "Yes" : "No"));
                    }
                    break;

                case 3:
                    System.out.print("Enter Book Title to Search: ");
                    String Search_Title = Scanner_Input.nextLine();
                    boolean Found = false;
                    for (Book B : Library) {
                        if (B.Title.equalsIgnoreCase(Search_Title)) {
                            System.out.println("Found: " + B.Title + ", Author: " + B.Author + ", Available: " + (B.Is_Available ? "Yes" : "No"));
                            Found = true;
                            break;
                        }
                    }
                    if (!Found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Library System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (Choice != 4);

        Scanner_Input.close();
    }
}
