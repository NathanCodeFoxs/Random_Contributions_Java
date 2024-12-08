import java.util.ArrayList;
import java.util.Scanner;

class Memo {
    private String Title;
    private String Content;

    public Memo(String Title, String Content) {
        this.Title = Title;
        this.Content = Content;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    public void displayMemo() {
        System.out.println("Title: " + Title);
        System.out.println("Content: " + Content);
    }
}

public class 48_Activity {

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        ArrayList<Memo> Memos = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Memo Manager ---");
            System.out.println("1. Add Memo");
            System.out.println("2. View All Memos");
            System.out.println("3. Search Memo by Title");
            System.out.println("4. Delete Memo");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int Choice = Scan.nextInt();
            Scan.nextLine(); // Consume newline

            switch (Choice) {
                case 1:
                    System.out.print("Enter memo title: ");
                    String Title = Scan.nextLine();
                    System.out.print("Enter memo content: ");
                    String Content = Scan.nextLine();

                    Memos.add(new Memo(Title, Content));
                    System.out.println("Memo added successfully!");
                    break;

                case 2:
                    if (Memos.isEmpty()) {
                        System.out.println("No memos available.");
                    } else {
                        for (int i = 0; i < Memos.size(); i++) {
                            System.out.println("\nMemo " + (i + 1) + ":");
                            Memos.get(i).displayMemo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    String Search_Title = Scan.nextLine();
                    boolean Found = false;

                    for (Memo Memo : Memos) {
                        if (Memo.getTitle().equalsIgnoreCase(Search_Title)) {
                            System.out.println("\nMemo Found:");
                            Memo.displayMemo();
                            Found = true;
                            break;
                        }
                    }

                    if (!Found) {
                        System.out.println("No memo found with the title: " + Search_Title);
                    }
                    break;

                case 4:
                    System.out.print("Enter title of the memo to delete: ");
                    String Delete_Title = Scan.nextLine();
                    Found = false;

                    for (int i = 0; i < Memos.size(); i++) {
                        if (Memos.get(i).getTitle().equalsIgnoreCase(Delete_Title)) {
                            Memos.remove(i);
                            System.out.println("Memo deleted successfully!");
                            Found = true;
                            break;
                        }
                    }

                    if (!Found) {
                        System.out.println("No memo found with the title: " + Delete_Title);
                    }
                    break;

                case 5:
                    System.out.println("Exiting Memo Manager. Goodbye!");
                    Scan.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
