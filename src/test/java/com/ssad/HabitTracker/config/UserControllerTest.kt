package com.ssad.HabitTracker.config

import com.ssad.HabitTracker.dto.UserDto
import com.ssad.HabitTracker.exception.NotFoundException
import com.ssad.HabitTracker.repository.UserRepository
import com.ssad.HabitTracker.service.UserService
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [TestConfig::class])
class UserControllerTest {
    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun register() {
        val userDto = UserDto()
        userDto.birthdayDate = "19.03.2001"
        userDto.emailOrNumber = "ne.danat.ne.ayazbayev@gmail.com"
        userDto.firstName = "Danat"
        userDto.secondName = "Ayazbayev"
        userDto.password = "otvechayuNeDanat"
        userService.register(userDto)
        val optionalUserEntity = userRepository.findOneByEmail(userDto.emailOrNumber)
        assertTrue(optionalUserEntity.isPresent)
        userRepository.delete(optionalUserEntity.get())
    }
}