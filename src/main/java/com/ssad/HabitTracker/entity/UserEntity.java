package com.ssad.HabitTracker.entity;

import com.ssad.HabitTracker.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Table(name = "user")
@Entity
@NoArgsConstructor
@Setter
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column
    private String bio;
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column(name = "birthday")
    private String birthdayDate;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<GoalEntity> goals;

    public static UserEntity buildFrom(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setSecondName(userDto.getSecondName());
        userEntity.setEmail(userDto.getEmailOrNumber());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setBirthdayDate(userDto.getBirthdayDate());
        return userEntity;
    }

}
