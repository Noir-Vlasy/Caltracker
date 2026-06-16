package com.learn.caltracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table (name = "ingredients")
@Getter
@Setter
public class Ingredient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true)
    private String name;

    @Column (name = "calorie_per_100g", nullable = false)
    private double caloriesPer100g;

    @Column (name = "protien_per_100g", nullable = false)
    private double protienPer100g;

    @Column (name = "carbs_per_100g", nullable = false)
    private double carbsPer100g;

    @Column (name = "fat_per_100g", nullable = false)
    private double fatPer100g;

    @Column (name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}