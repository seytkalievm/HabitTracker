package com.ssad.HabitTracker.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "user_token")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class UserTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String token;
    @Column
    private int userId;

    public UserTokenEntity(String token, int userId){
        this.token = token;
        this.userId = userId;
    }

}
