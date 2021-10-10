package com.ssad.HabitTracker.repository;

import com.ssad.HabitTracker.entity.GoalEntity;
import com.ssad.HabitTracker.entity.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<GoalEntity, Integer> {
}
