package com.cognizant.stackSimplify.dto;

import java.util.List;

public class StackSimplifyResponse {
    private String explanation;
    private List<String> suggestions;

    public StackSimplifyResponse() {
    }

    public StackSimplifyResponse(String explanation, List<String> suggestions) {
        this.explanation = explanation;
        this.suggestions = suggestions;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }
}