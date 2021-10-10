package com.ssad.HabitTracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssad.HabitTracker.entity.StepEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoalDto {
    @JsonProperty
    private String goalName;
    @JsonProperty
    private String goalType;
    @JsonProperty
    private String generalInfo;
    @JsonProperty
    private String PreporationSteps;
    @JsonProperty
    private String email;
    @JsonProperty
    private List<StepDto> steps;
}
