import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DailyLog {
    private final LocalDate date;
    private final List<FoodEntry> foodEntries = new ArrayList<>();

    public DailyLog(LocalDate date) {

        if (date == null) {
            throw new IllegalArgumentException(
                    "Date cannot be null"
            );
        }
        this.date = date;
    } // Here we have date

    public void addEntry(FoodEntry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Entry Cannot be NULL value");
        }
        if (entry.getConsumedAt().toLocalDate().equals(date)) {
            foodEntries.add(entry);
        } else {
            throw new IllegalArgumentException("Entry date Must match the Log's Date");
        }

    }

    public void removeEntry(FoodEntry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Entry to be removed Cannot be NULL value");
        }
        foodEntries.remove(entry);
    }

    public List<FoodEntry> getEntries() {
        return Collections.unmodifiableList(foodEntries);
    }

    public NutritionalValue getTotalNutrition() {
        NutritionalValue Total = new NutritionalValue(0, 0, 0, 0);
        for (FoodEntry entry : foodEntries) {

            Total = Total.add(entry.getNutritionSnapshot());
        }
        return Total;
    }

}
