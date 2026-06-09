import java.util.Objects;

public final class NutritionalValue {

    private final double calories;
    private final double protein;
    private final double carbs;
    private final double fat;

    public NutritionalValue(double calories,
                            double protein,
                            double carbs,
                            double fat) {

        validate(calories, "calories");
        validate(protein, "protein");
        validate(carbs, "carbs");
        validate(fat, "fat");

        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public NutritionalValue scale(double grams) {

        if (Double.isNaN(grams) || Double.isInfinite(grams) || grams <= 0) {
            throw new IllegalArgumentException(
                    "grams must be a positive finite number"
            );
        }

        double multiplier = grams / 100.0;

        return new NutritionalValue(
                calories * multiplier,
                protein * multiplier,
                carbs * multiplier,
                fat * multiplier
        );
    }

    public NutritionalValue add(NutritionalValue other) {

        Objects.requireNonNull(other, "other nutritional value cannot be null");

        return new NutritionalValue(
                this.calories + other.calories,
                this.protein + other.protein,
                this.carbs + other.carbs,
                this.fat + other.fat
        );
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFat() {
        return fat;
    }

    private static void validate(double value, String fieldName) {

        if (Double.isNaN(value)
                || Double.isInfinite(value)
                || value < 0) {

            throw new IllegalArgumentException(
                    fieldName + " must be a non-negative finite number"
            );
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Calories: %.2f, Protein: %.2fg, Carbs: %.2fg, Fat: %.2fg",
                calories,
                protein,
                carbs,
                fat
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof NutritionalValue other)) {
            return false;
        }

        return Double.compare(calories, other.calories) == 0
                && Double.compare(protein, other.protein) == 0
                && Double.compare(carbs, other.carbs) == 0
                && Double.compare(fat, other.fat) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(calories, protein, carbs, fat);
    }
}