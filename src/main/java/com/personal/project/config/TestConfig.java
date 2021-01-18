package com.personal.project.config;

import com.personal.project.entities.Order;
import com.personal.project.entities.User;
import com.personal.project.repositories.OrderRepository;
import com.personal.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("User1", "email1@email.com", "12345", "1111111111");
        User u2 = new User("User2", "email2@email.com", "12345", "2222222222");

        Order o1 = new Order(u1);
        Order o2 = new Order(u2);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
    }
}
