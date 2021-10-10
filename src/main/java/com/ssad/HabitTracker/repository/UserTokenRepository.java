package com.ssad.HabitTracker.repository;


import com.ssad.HabitTracker.entity.UserTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTokenRepository extends JpaRepository<UserTokenEntity, Integer> {
}