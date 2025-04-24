package com.cognizant.stackSimplify.controller;

import com.cognizant.stackSimplify.dto.StackSimplifyResponse;
import com.cognizant.stackSimplify.dto.StackTraceRequest;
import com.cognizant.stackSimplify.service.StackSimplifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stack-simplify")
public class StackSimplifyController {

    @Autowired
    private StackSimplifyService stackSimplifyService;

    @PostMapping
    public ResponseEntity<StackSimplifyResponse> simplifyStackTrace(@RequestBody StackTraceRequest request) {
        if (request.getStackTrace() == null || request.getStackTrace().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        StackSimplifyResponse response = stackSimplifyService.analyzeStackTrace(
            request.getStackTrace(), 
            request.getModelType()
        );
        
        return ResponseEntity.ok(response);
    }
}