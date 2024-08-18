package com.example.springdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args-> {
            Student roy = new Student(
                    "Roy",
                    "test@test.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            Student rolls = new Student(
                    "Rolls",
                    "testrolls@test.com",
                    LocalDate.of(2001, Month.FEBRUARY, 15)
            );

            repository.saveAll(
                    List.of(roy, rolls)
            );
        };
    }
}
