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

public class 19_Activity {
    public static void main(String[] args) {
        ArrayList<Book> Library = new ArrayList<>();
        Scanner Scanner_Input = new Scanner(System.in);
        int Choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            Choice = Scanner_Input.nextInt();
            Scanner_Input.nextLine(); // Consume newline

            switch (Choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String Title = Scanner_Input.nextLine();
                    System.out.print("Enter author name: ");
                    String Author = Scanner_Input.nextLine();
                    Library.add(new Book(Title, Author));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.println("\nLibrary Books:");
                    for (int i = 0; i < Library.size(); i++) {
                        Book Current_Book = Library.get(i);
                        System.out.println((i + 1) + ". " + Current_Book.Title + " by " + Current_Book.Author + " - " + (Current_Book.Is_Available ? "Available" : "Borrowed"));
                    }
                    break;

                case 3:
                    System.out.print("Enter book number to borrow: ");
                    int Borrow_Index = Scanner_Input.nextInt() - 1;
                    if (Borrow_Index >= 0 && Borrow_Index < Library.size()) {
                        Book Book_To_Borrow = Library.get(Borrow_Index);
                        if (Book_To_Borrow.Is_Available) {
                            Book_To_Borrow.Is_Available = false;
                            System.out.println("You have borrowed \"" + Book_To_Borrow.Title + "\".");
                        } else {
                            System.out.println("Sorry, the book is already borrowed.");
                        }
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter book number to return: ");
                    int Return_Index = Scanner_Input.nextInt() - 1;
                    if (Return_Index >= 0 && Return_Index < Library.size()) {
                        Book Book_To_Return = Library.get(Return_Index);
                        if (!Book_To_Return.Is_Available) {
                            Book_To_Return.Is_Available = true;
                            System.out.println("You have returned \"" + Book_To_Return.Title + "\".");
                        } else {
                            System.out.println("This book was not borrowed.");
                        }
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Library Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (Choice != 5);

        Scanner_Input.close();
    }
}
