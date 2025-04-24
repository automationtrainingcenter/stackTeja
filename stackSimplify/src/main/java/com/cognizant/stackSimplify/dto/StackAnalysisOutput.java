package com.cognizant.stackSimplify.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bean structure for AI response formatting using BeanOutputConverter
 */
public record StackAnalysisOutput(
    @JsonProperty(required = true, value = "explanation") String explanation,
    @JsonProperty(required = true, value = "suggestions") String[] suggestions) {
}