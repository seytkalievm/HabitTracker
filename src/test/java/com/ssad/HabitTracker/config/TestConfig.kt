package com.ssad.HabitTracker.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories("com.ssad.HabitTracker.*")
@EntityScan("com.ssad.HabitTracker.*")
@ComponentScan(
        basePackages = ["com.ssad.HabitTracker.*"],
        lazyInit = true,
)
@Configuration
open class TestConfig {
}