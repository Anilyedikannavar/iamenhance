package com.application.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.User;
import com.application.repository.UserRepository;

@Service
public class RegisterActionService implements ActionStrategy {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void execute(Map<String, Object> requestData) {
        // Extract user registration data from the requestData map
        String email = (String) requestData.get("email");
        String password = (String) requestData.get("password");

        // Check if the email is already registered
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already registered!");
        }

        // Create a new user entity and save it
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);

        // You can also set other user properties as needed
        // newUser.setFirstName((String) requestData.get("firstName"));
        // newUser.setLastName((String) requestData.get("lastName"));

        userRepository.save(newUser);

        // Optionally, you can return a success message or any other response
        // based on your application's requirements.
    }
}
