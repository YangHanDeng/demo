package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            Users user1 = new Users("user1", 0, 18, "test1@uci.edu");
            Users user2 = new Users("user2", 0, 30, "test2@uci.edu");
            userRepository.saveAll(
                    List.of(user1, user2)
            );
        };
    }

}
