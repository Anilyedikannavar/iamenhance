package com.application.service;

import java.util.Map;

public interface ActionStrategy {
    void execute(Map<String, Object> requestData);
}
