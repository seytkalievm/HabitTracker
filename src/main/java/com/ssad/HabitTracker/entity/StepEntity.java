package com.ssad.HabitTracker.entity;

import com.ssad.HabitTracker.dto.StepDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "step")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class StepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "goal_id", nullable = false)
    private GoalEntity goal;

    @Column
    private int stepNumber;

    @Column
    private String disc;

    @Column
    private Date date;

    @Column
    private int state;

    public StepEntity(StepDto stepDto){
        this.disc = stepDto.getDisc();
        this.date = stepDto.getDate();
        this.state = 0;
    }
}
