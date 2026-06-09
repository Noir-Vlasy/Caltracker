import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public final class FoodEntry {
    private final Ingredient ingredient;
    private final double quantityInGrams;
    private final LocalDateTime consumedAt;
    private final NutritionalValue nutritionSnapshot;

    public FoodEntry(Ingredient ingredient, double quantityInGrams, LocalDateTime consumedAt) {

        if (ingredient == null) {
            throw new IllegalArgumentException(
                    "Ingredient cannot be null or blank"
            );
        }

        if (quantityInGrams <= 0) {
            throw new IllegalArgumentException(
                    "Quantity should be greater than 0"
            );
        }
        if (consumedAt == null) {
            throw new IllegalArgumentException(
                    "Time cannot be null"
            );
        }

        this.ingredient = ingredient;
        this.quantityInGrams = quantityInGrams;
        this.consumedAt = consumedAt;
        this.nutritionSnapshot = ingredient.getNutritionPer100g().scale(quantityInGrams);

    }
}
