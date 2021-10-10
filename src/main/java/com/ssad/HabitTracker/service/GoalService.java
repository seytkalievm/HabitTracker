package com.ssad.HabitTracker.service;

import com.ssad.HabitTracker.dto.GoalDto;
import com.ssad.HabitTracker.entity.GoalEntity;
import com.ssad.HabitTracker.entity.UserEntity;
import com.ssad.HabitTracker.exception.NotFoundException;
import com.ssad.HabitTracker.repository.GoalRepository;
import com.ssad.HabitTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoalService{
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private UserRepository userRepository;

    public void createGoal(GoalDto goalDto){
        Optional<UserEntity> optionalUserEntity = userRepository.findOneByEmail(goalDto.getEmail());
        if(!optionalUserEntity.isPresent()){
            throw new NotFoundException("User doesn't exist");
        }
        GoalEntity goalEntity = GoalEntity.buildFrom(goalDto, optionalUserEntity.get());
        goalRepository.save(goalEntity);
    }
    public List<GoalEntity> activeGoal(String email){
        return null;
    }
}
