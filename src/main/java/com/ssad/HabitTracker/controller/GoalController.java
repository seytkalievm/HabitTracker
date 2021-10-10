package com.ssad.HabitTracker.controller;

import com.ssad.HabitTracker.dto.GoalDto;
import com.ssad.HabitTracker.dto.UserDto;
import com.ssad.HabitTracker.service.GoalService;
import com.ssad.HabitTracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoalController {
    private final GoalService gaolService;
    private final String goalCreate = "/goal/create";
    @PostMapping(goalCreate)
    private void creatGoal(@RequestBody GoalDto goalDto){
        gaolService.createGoal(goalDto);
    }
}
