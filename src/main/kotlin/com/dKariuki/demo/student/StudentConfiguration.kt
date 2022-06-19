package com.dKariuki.demo.student

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.Month

@Configuration
class StudentConfiguration {

    @Bean
    fun commandLineRunner(repository: StudentRepository): CommandLineRunner {
        return CommandLineRunner {
            val st1 = Student(
                name = "Test",
                email = "test@test.com",
                dob = LocalDate.of(2000, Month.MAY, 21)
            )
            val st2 = Student(
                name = "Test2",
                email = "test2@test.com",
                dob = LocalDate.of(1998, Month.MAY, 21)
            )

            repository.saveAll(listOf(st1, st2))
        }
    }
}