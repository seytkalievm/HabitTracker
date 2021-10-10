package com.ssad.HabitTracker.entity;

import com.ssad.HabitTracker.dto.GoalDto;
import com.ssad.HabitTracker.dto.StepDto;
import com.ssad.HabitTracker.repository.GoalRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Table(name = "goal")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class GoalEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "goal_id")
    private Integer id;

    @Column
    private String goalName;
    @Column
    private String goalType;
    @Column
    private String generalInfo;
    @Column
    private String PreporationSteps;
    @Column
    private String state;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<StepEntity> steps;

    public static GoalEntity buildFrom(GoalDto goalDto, UserEntity userEntity){
        GoalEntity goalEntity = new GoalEntity();
        goalEntity.setGoalName(goalDto.getGoalName());
        goalEntity.setGoalType(goalDto.getGoalType());
        goalEntity.setGeneralInfo(goalDto.getGeneralInfo());
        goalEntity.setPreporationSteps(goalDto.getPreporationSteps());
        goalEntity.setUser(userEntity);
        goalEntity.setState("Active");
        List<StepEntity> steps = new ArrayList<>();
        List<StepDto> stepsDto = goalDto.getSteps();
        for(int i = 0; i < stepsDto.size(); i++){
            steps.add(new StepEntity(stepsDto.get(i)));
        }
        goalEntity.setSteps(steps);
        for(int i = 0; i < steps.size(); i++){
            steps.get(i).setGoal(goalEntity);
            steps.get(i).setStepNumber(i + 1);
        }
        return goalEntity;
    }

}
