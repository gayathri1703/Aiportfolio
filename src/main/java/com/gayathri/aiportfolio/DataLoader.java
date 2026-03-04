package com.gayathri.aiportfolio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gayathri.aiportfolio.model.Project;
import com.gayathri.aiportfolio.repository.ProjectRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProjectRepository repository) {
        return args -> {

            repository.save(new Project(
                    "Fashionexus",
                    "AI-powered virtual fashion try-on system",
                    "https://github.com/gayathri1703/Fashionexus"
                    "https://via.placeholder.com/400"
            ));

            repository.save(new Project(
                    "Tourist Guide",
                    "Travel recommendation web app for exploring tourist locations",
                    "https://github.com/gayathri1703/TouristGuide"
                    "https://via.placeholder.com/400"
            ));

            repository.save(new Project(
                    "Stocksence",
                    "Stock market analysis and prediction system",
                    "https://github.com/gayathri1703/Stocksence"
                    "https://via.placeholder.com/400"
            ));

            repository.save(new Project(
                    "AI Portfolio",
                    "Personal portfolio website built with Spring Boot and Thymeleaf",
                    "https://github.com/gayathri1703/Aiportfolio"
                    "https://via.placeholder.com/400"
            ));

        };
    }
}