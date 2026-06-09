import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // -----------------------------
        // 1. Create Ingredients
        // -----------------------------

        Ingredient paneer = new Ingredient(
                "Paneer",
                new NutritionalValue(265, 18, 1.2, 21)
        );

        Ingredient milk = new Ingredient(
                "Milk",
                new NutritionalValue(61, 3.2, 4.8, 3.3)
        );

        Ingredient banana = new Ingredient(
                "Banana",
                new NutritionalValue(89, 1.1, 23, 0.3)
        );

        // -----------------------------
        // 2. Create Food Entries
        // -----------------------------

        FoodEntry paneerEntry = new FoodEntry(
                paneer,
                150,
                LocalDateTime.of(2026, 6, 9, 8, 0)
        );

        FoodEntry milkEntry = new FoodEntry(
                milk,
                250,
                LocalDateTime.of(2026, 6, 9, 8, 30)
        );

        FoodEntry bananaEntry = new FoodEntry(
                banana,
                120,
                LocalDateTime.of(2026, 6, 9, 11, 0)
        );

        // -----------------------------
        // 3. Print Individual Entries
        // -----------------------------

        System.out.println("=== FOOD ENTRIES ===");

        printEntry(paneerEntry);
        printEntry(milkEntry);
        printEntry(bananaEntry);

        // -----------------------------
        // 4. Daily Total (Manual Sum)
        // -----------------------------

        NutritionalValue total =
                paneerEntry.getNutritionSnapshot()
                        .add(milkEntry.getNutritionSnapshot())
                        .add(bananaEntry.getNutritionSnapshot());

        System.out.println("\n=== DAILY TOTAL ===");
        System.out.println(total);
    }

    private static void printEntry(FoodEntry entry) {
        System.out.println("\nFood: " + entry.getIngredient().getName());
        System.out.println("Time: " + entry.getConsumedAt());
        System.out.println("Quantity: " + entry.getQuantityInGrams() + "g");
        System.out.println("Nutrition: " + entry.getNutritionSnapshot());
    }
}