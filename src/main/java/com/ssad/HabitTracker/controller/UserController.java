package com.ssad.HabitTracker.controller;

import com.ssad.HabitTracker.dto.UserDto;
import com.ssad.HabitTracker.entity.UserEntity;
import com.ssad.HabitTracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final static String userRegister = "/user/register";
    private final static String userLogin = "/user/login";
    private final static String userInfo = "/user/info";

    @PostMapping(userRegister)
    private void register(@RequestBody UserDto userDto){
        userService.register(userDto);
    }

    @GetMapping(userLogin)
    private ResponseEntity<String> login(@RequestParam("email") String email, @RequestParam("password") String password) throws Exception{
        String token = userService.login(email, password);
        return ok(token);
    }
    @GetMapping(userInfo)
    private ResponseEntity<UserEntity> info(@RequestParam("email") String email) throws Exception{
        UserEntity userEntity = userService.info(email);
        return ok(userEntity);
    }
}
