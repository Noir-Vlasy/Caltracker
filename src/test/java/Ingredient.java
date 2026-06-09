import lombok.Getter;

@Getter
public final class Ingredient {

    private final String name;
    private final NutritionalValue nutritionPer100g;

    public Ingredient(String name, NutritionalValue nutritionPer100g) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Ingredient name cannot be null or blank"
            );
        }

        if (nutritionPer100g == null) {
            throw new IllegalArgumentException(
                    "Nutrition data cannot be null"
            );
        }

        this.name = name.trim();
        this.nutritionPer100g = nutritionPer100g;
    }
}