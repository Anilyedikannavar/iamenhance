package com.application.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.config.ApiConfigProperties;

import jakarta.annotation.PostConstruct;

@Service
public class ActionService {

    private final ApiConfigProperties apiConfigProperties;
    private final Map<String, ActionStrategy> actionStrategies = new HashMap<>();

    @Autowired
    public ActionService(ApiConfigProperties apiConfigProperties, RegisterActionService registerActionService) {
        this.apiConfigProperties = apiConfigProperties;
        actionStrategies.put("register", registerActionService);
    //    actionStrategies.put("login", loginActionService);

    }

//    @PostConstruct
//    public void initialize() {
        // Initialize action strategies using lambdas

  //      actionStrategies.put("register", this::executeRegisterAction);
   //     actionStrategies.put("login", this::executeLoginAction);
        // Add other action strategies as needed
//    }

	

	public void executeAction(String action, Map<String, Object> requestData) {
        ActionStrategy actionStrategy = actionStrategies.get(action);

        if (actionStrategy != null) {
            actionStrategy.execute(requestData);
        } else {
            throw new IllegalArgumentException("Invalid action: " + action);
        }
    }
}
//check whether that action or event is present from the requestData


