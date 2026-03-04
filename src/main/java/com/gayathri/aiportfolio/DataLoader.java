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
                    "https://github.com/gayathri1703/FASHIONEUS",
                    "https://images.unsplash.com/photo-1523381210434-271e8be1f52b"
            ));

            repository.save(new Project(
                    "Tourist Guide",
                    "Tourist recommendation system",
                    "https://github.com/gayathri1703/tourist-guide",
                    "https://images.unsplash.com/photo-1501785888041-af3ef285b470"
            ));

            repository.save(new Project(
                    "Stocksence",
                    "Stock analysis platform",
                    "https://github.com/gayathri1703/stocksense-learn-hub",
                    "https://images.unsplash.com/photo-1611974789855-9c2a0a7236a3"
                    "https://images.unsplash.com/photo-1518770660439-4636190af475"
            ));

            repository.save(new Project(
                    "AI Portfolio",
                    "Spring Boot developer portfolio",
                    "https://github.com/gayathri1703/Aiportfolio",
                    "https://images.unsplash.com/photo-1518770660439-4636190af475"
            ));
        };
    }
}