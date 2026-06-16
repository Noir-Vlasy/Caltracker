package com.learn.caltracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table (name = "food_entries")
@Getter
@Setter
public class FoodEntry {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    // WHO ate it
    @ManyToOne
    @JoinColumn (name = "user_id", nullable = false)
    private User user;

    // WHAT was eaten
    @ManyToOne
    @JoinColumn (name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @Column (name = "quantity_grams", nullable = false)
    private double quantityGrams;

    // SNAPSHOT (important for history correctness)
    @Column (nullable = false)
    private double calories;

    @Column (nullable = false)
    private double protein;

    @Column (nullable = false)
    private double carbs;

    @Column (nullable = false)
    private double fat;

    @Column (name = "consumed_at", nullable = false)
    private LocalDateTime consumedAt;

    @Column (name = "meal_type")
    private String mealType;

    @Column (name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}