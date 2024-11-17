import java.util.ArrayList;
import java.util.Scanner;

public class 34_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);
        ArrayList<String> Playlist = new ArrayList<>();
        boolean Is_Running = true;

        System.out.println("Welcome to the Simple Song Player!");

        while (Is_Running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a song to the playlist");
            System.out.println("2. Play a song");
            System.out.println("3. View all songs");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int Choice = Scanner_Input.nextInt();
            Scanner_Input.nextLine(); // consume newline

            switch (Choice) {
                case 1:
                    System.out.print("Enter the song title to add: ");
                    String Song_Title = Scanner_Input.nextLine();
                    Playlist.add(Song_Title);
                    System.out.println("Song '" + Song_Title + "' added to the playlist!");
                    break;

                case 2:
                    if (Playlist.isEmpty()) {
                        System.out.println("The playlist is empty. Add some songs first!");
                    } else {
                        System.out.print("Enter the song number to play (1 to " + Playlist.size() + "): ");
                        int Song_Index = Scanner_Input.nextInt();
                        if (Song_Index >= 1 && Song_Index <= Playlist.size()) {
                            System.out.println("Playing: " + Playlist.get(Song_Index - 1));
                        } else {
                            System.out.println("Invalid song number.");
                        }
                    }
                    break;

                case 3:
                    if (Playlist.isEmpty()) {
                        System.out.println("The playlist is empty.");
                    } else {
                        System.out.println("\nPlaylist:");
                        for (int i = 0; i < Playlist.size(); i++) {
                            System.out.println((i + 1) + ". " + Playlist.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Song Player. Goodbye!");
                    Is_Running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        Scanner_Input.close();
    }
}
