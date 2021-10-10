package com.ssad.HabitTracker.service;

import com.ssad.HabitTracker.dto.UserDto;
import com.ssad.HabitTracker.entity.UserEntity;
import com.ssad.HabitTracker.entity.UserTokenEntity;
import com.ssad.HabitTracker.exception.ForbiddenException;
import com.ssad.HabitTracker.exception.NotFoundException;
import com.ssad.HabitTracker.exception.UnauthorizedException;
import com.ssad.HabitTracker.repository.UserRepository;
import com.ssad.HabitTracker.repository.UserTokenRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;

    public void register(UserDto userDto){
        UserEntity userEntity = UserEntity.buildFrom(userDto);

        Optional<UserEntity> optionalUserEntity = userRepository.findOneByEmail(userEntity.getEmail());

        if(optionalUserEntity.isPresent()){
            throw new ForbiddenException("User already exist");
        }

        userRepository.save(userEntity);
    }

    public String login(String email, String password){
        Optional<UserEntity> optionalUserEntity = userRepository.findOneByEmail(email);
        if(!optionalUserEntity.isPresent()){
            throw new NotFoundException("User doesn't exist");
        }
        UserEntity userEntity = optionalUserEntity.get();
        if(!userEntity.getPassword().equals(password)){
            throw new UnauthorizedException("Incorrect password");
        }
        String token = UUID.randomUUID().toString();
        UserTokenEntity userTokenEntity = new UserTokenEntity(token, userEntity.getId());
        userTokenRepository.save(userTokenEntity);
        return token;
    }

    public UserEntity info(String email){
        Optional<UserEntity> optionalUserEntity = userRepository.findOneByEmail(email);
        if(!optionalUserEntity.isPresent()){
            throw new NotFoundException("User doesn't exist");
        }
        UserEntity userEntity = optionalUserEntity.get();

        return userEntity;
    }
}
