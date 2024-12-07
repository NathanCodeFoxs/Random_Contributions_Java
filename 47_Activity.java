import java.util.ArrayList;
import java.util.Scanner;

class Recipe {
    private String name;
    private ArrayList<String> ingredients;
    private ArrayList<String> steps;

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public void addStep(String step) {
        steps.add(step);
    }

    public void displayRecipe() {
        System.out.println("Recipe: " + name);
        System.out.println("Ingredients:");
        for (int i = 0; i < ingredients.size(); i++) {
            System.out.println((i + 1) + ". " + ingredients.get(i));
        }

        System.out.println("\nSteps:");
        for (int i = 0; i < steps.size(); i++) {
            System.out.println((i + 1) + ". " + steps.get(i));
        }
    }
}

public class 47_Activity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recipe> recipes = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Recipe Organizer ---");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Search Recipe");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter recipe name: ");
                    String recipeName = scanner.nextLine();
                    Recipe recipe = new Recipe(recipeName);

                    System.out.println("Enter ingredients (type 'done' to finish):");
                    while (true) {
                        String ingredient = scanner.nextLine();
                        if (ingredient.equalsIgnoreCase("done")) break;
                        recipe.addIngredient(ingredient);
                    }

                    System.out.println("Enter steps (type 'done' to finish):");
                    while (true) {
                        String step = scanner.nextLine();
                        if (step.equalsIgnoreCase("done")) break;
                        recipe.addStep(step);
                    }

                    recipes.add(recipe);
                    System.out.println("Recipe added successfully!");
                    break;

                case 2:
                    if (recipes.isEmpty()) {
                        System.out.println("No recipes available.");
                    } else {
                        for (Recipe r : recipes) {
                            System.out.println("\n---");
                            r.displayRecipe();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter recipe name to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;

                    for (Recipe r : recipes) {
                        if (r.getName().equalsIgnoreCase(searchName)) {
                            r.displayRecipe();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Recipe not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Recipe Organizer. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
