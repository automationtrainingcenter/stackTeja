package com.cognizant.stackSimplify.dto;

public class StackTraceRequest {
    private String stackTrace;
    private String modelType; // Optional: "ollama", "openai", "claude"

    public StackTraceRequest() {
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
}