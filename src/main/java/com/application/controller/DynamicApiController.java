package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DynamicApiController {

    @Autowired
    private ActionControllerHandler actionControllerHandler;

//    @PostMapping("/{action}")
//    public ResponseEntity<String> handleAction(
//            @RequestBody Map<String, Object> requestData,
//            @PathVariable String action
//    ) {
//        return actionControllerHandler.handleAction(action, requestData);
//    }
    
    // Today's change
    @RequestMapping(value = "/{action}", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<String> handlePostAndPut(
            @RequestBody Map<String, Object> requestData,
            @PathVariable String action
    ) {
        return actionControllerHandler.handleAction(action, requestData);
    }

    @GetMapping("/{action}")
    public ResponseEntity<String> handleGet (@RequestBody Map<String,Object> requestData, @PathVariable String action ) {
    	
    	
        // Handle GET request here
        // You can add specific logic for GET requests here.
        return actionControllerHandler.handleAction(action,requestData);
    }

    @DeleteMapping("/{action}")
    public ResponseEntity<String> handleDelete(@RequestBody Map<String,Object> requestData,
            @PathVariable String action
    ) {
        // Handle DELETE request here
        // You can add specific logic for DELETE requests here.
        return actionControllerHandler.handleAction(action,requestData);
    }
}
    
    
    
