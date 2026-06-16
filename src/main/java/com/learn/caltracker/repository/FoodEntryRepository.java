package com.learn.caltracker.repository;

import com.learn.caltracker.entity.FoodEntry;
import com.learn.caltracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FoodEntryRepository extends JpaRepository<FoodEntry, Long> {

    List<FoodEntry> findByUser(User user);

    List<FoodEntry> findByUserAndConsumedAtBetween(
            User user,
            LocalDateTime start,
            LocalDateTime end
    );
}