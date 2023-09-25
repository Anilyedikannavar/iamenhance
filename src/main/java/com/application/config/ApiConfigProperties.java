package com.application.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@EnableConfigurationProperties
@ConfigurationProperties("app-prop")
public class ApiConfigProperties {
	private Map<String, ActionConfig> actions;

	public Map<String, ActionConfig> getActions() {
		return actions;
	}

	public void setActions(Map<String, ActionConfig> actions) {
		this.actions = actions;

	}

	@PostConstruct
	public void init() {
		if (actions != null) {
			System.out.println("Number of actions loaded: " + actions.size());
			for (Map.Entry<String, ActionConfig> entry : actions.entrySet()) {
				System.out.println("Action: " + entry.getKey() + ", Path: " + entry.getValue().getPath() + ", Method: "
						+ entry.getValue().getMethod());
			}
		} else {
			System.out.println("No actions loaded.");
		}
	}
}