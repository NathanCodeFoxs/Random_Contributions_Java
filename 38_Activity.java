import java.util.Scanner;

public class 38_Activity {
    public static void main(String[] args) {
        Scanner Scanner_Input = new Scanner(System.in);

        // Maze setup
        char[][] Maze = {
            {'S', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', '#', '#'},
            {' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', ' '},
            {' ', ' ', ' ', ' ', 'E'}
        };

        int Player_Row = 0;
        int Player_Col = 0;
        boolean Is_Running = true;

        System.out.println("Welcome to the Maze Solver Simulator!");
        System.out.println("Navigate through the maze to reach the exit 'E'.");
        System.out.println("Commands: up, down, left, right");
        System.out.println("Legend: S = Start, E = Exit, # = Wall, ' ' = Open Path");
        System.out.println();

        while (Is_Running) {
            // Display the maze
            for (int i = 0; i < Maze.length; i++) {
                for (int j = 0; j < Maze[i].length; j++) {
                    if (i == Player_Row && j == Player_Col) {
                        System.out.print("P "); // Player's position
                    } else {
                        System.out.print(Maze[i][j] + " ");
                    }
                }
                System.out.println();
            }

            System.out.print("\nEnter your move: ");
            String Move = Scanner_Input.nextLine().toLowerCase();

            int New_Row = Player_Row;
            int New_Col = Player_Col;

            // Process move
            switch (Move) {
                case "up":
                    New_Row--;
                    break;
                case "down":
                    New_Row++;
                    break;
                case "left":
                    New_Col--;
                    break;
                case "right":
                    New_Col++;
                    break;
                default:
                    System.out.println("Invalid move! Use up, down, left, or right.");
                    continue;
            }

            // Check boundaries and walls
            if (New_Row < 0 || New_Row >= Maze.length || New_Col < 0 || New_Col >= Maze[0].length) {
                System.out.println("You hit a wall! Try a different direction.");
            } else if (Maze[New_Row][New_Col] == '#') {
                System.out.println("You can't move there, it's a wall!");
            } else {
                // Move player
                Player_Row = New_Row;
                Player_Col = New_Col;

                // Check for exit
                if (Maze[Player_Row][Player_Col] == 'E') {
                    System.out.println("\nCongratulations! You reached the exit!");
                    Is_Running = false;
                }
            }
        }

        System.out.println("Thanks for playing the Maze Solver Simulator!");
        Scanner_Input.close();
    }
}
