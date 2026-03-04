package com.gayathri.aiportfolio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProjectRepository repository) {
        return args -> {

            repository.save(new Project(
                    "AI Portfolio",
                    "A portfolio website built using Spring Boot and Thymeleaf",
                    "https://github.com/gayathri1703/Aiportfolio"
            ));

            repository.save(new Project(
                    "Career Buddy",
                    "AI based career guidance chatbot",
                    "https://github.com/gayathri1703"
            ));

        };
    }
}
