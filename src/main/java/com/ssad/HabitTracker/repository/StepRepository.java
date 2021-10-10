package com.ssad.HabitTracker.repository;

import com.ssad.HabitTracker.entity.StepEntity;
import com.ssad.HabitTracker.entity.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<StepEntity, Integer> {
}
