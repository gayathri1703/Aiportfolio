package com.gayathri.aiportfolio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gayathri.aiportfolio.repository.ProjectRepository;
import com.gayathri.aiportfolio.entity.Project;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ProjectRepository repository) {
        return args -> {

            repository.save(new Project(
                    "Fashionexus",
                    "AI virtual dress try-on system",
                    "https://github.com/gayathri1703/Fashionexus",
                    "https://via.placeholder.com/400"
            ));

            repository.save(new Project(
                    "Tourist Guide",
                    "Tourist recommendation system",
                    "https://github.com/gayathri1703/TouristGuide",
                    "https://via.placeholder.com/400"
            ));

            repository.save(new Project(
                    "Stocksence",
                    "Stock analysis platform",
                    "https://github.com/gayathri1703/Stocksence",
                    "https://via.placeholder.com/400"
            ));

            repository.save(new Project(
                    "AI Portfolio",
                    "Spring Boot developer portfolio",
                    "https://github.com/gayathri1703/Aiportfolio",
                    "https://via.placeholder.com/400"
            ));
        };
    }
}