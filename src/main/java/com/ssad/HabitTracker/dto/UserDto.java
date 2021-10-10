package com.ssad.HabitTracker.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty
    private String emailOrNumber;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String secondName;
    @JsonProperty
    private String birthdayDate;
    @JsonProperty
    private String password;
}
