package com.application.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.application.config.ActionConfig;
import com.application.config.ApiConfigProperties;
import com.application.service.ActionService;

@Component
public class ActionControllerHandler {

    @Autowired
    private ActionService actionService;

    @Autowired
    private ApiConfigProperties apiConfigProperties;

    public ResponseEntity<String> handleAction(String action, Map<String, Object> requestData) {
        // Section 1: Retrieve action configuration
        ActionConfig actionConfig = apiConfigProperties.getActions().get(action);

        if (actionConfig == null) {
            return ResponseEntity.notFound().build();
        }

        String method = actionConfig.getMethod();

        // Section 2: Check HTTP method validity
        //here added or and get,put,delete method
        if ("POST".equals(method) || "GET".equals(method) || "PUT".equals(method) || "DELETE".equals(method)) {
            // Section 3: Execute action if the HTTP method is valid
            actionService.executeAction(action, requestData);
            return ResponseEntity.ok("Post executed successfully!");
        } else {
            // Section 4: Handle invalid HTTP method
            return ResponseEntity.badRequest().body("Invalid method for action " + action);
        }
    }
}


