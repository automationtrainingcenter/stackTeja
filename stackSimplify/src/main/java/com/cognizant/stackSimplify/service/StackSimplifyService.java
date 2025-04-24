package com.cognizant.stackSimplify.service;

import com.cognizant.stackSimplify.dto.StackAnalysisOutput;
import com.cognizant.stackSimplify.dto.StackSimplifyResponse;

import java.util.Arrays;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.stereotype.Service;

@Service
public class StackSimplifyService {

    private final OllamaChatModel ollamaChatModel;
    
    private final BeanOutputConverter<StackAnalysisOutput> outputConverter = 
        new BeanOutputConverter<>(StackAnalysisOutput.class);

    public StackSimplifyService(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    public StackSimplifyResponse analyzeStackTrace(String stackTrace, String modelType) {
        // Default to Ollama if no model type is specified
        if (modelType == null || modelType.isEmpty()) {
            modelType = "ollama";
        }

        // For now, only Ollama is supported
        if ("ollama".equalsIgnoreCase(modelType)) {
            return processWithOllama(stackTrace);
        }
        
        // Placeholder for future model support
        throw new UnsupportedOperationException("Model type not supported yet: " + modelType);
    }

    private StackSimplifyResponse processWithOllama(String stackTrace) {
        String promptText = buildPrompt(stackTrace);
        Prompt ollamaPrompt = new Prompt(promptText, OllamaOptions.builder()
            .model("phi4-mini")
            .temperature(0.7)
            .format(outputConverter.getJsonSchemaMap())
            .build());
        
        // Using ChatClient.builder pattern with OllamaChatModel
        String content = this.ollamaChatModel.call(ollamaPrompt).getResult().getOutput().getText();
        
        // Convert the response to our bean structure
        StackAnalysisOutput analysisOutput = outputConverter.convert(content);
        
        // Map to our response DTO
        return new StackSimplifyResponse(
            analysisOutput.explanation(), 
            Arrays.asList(analysisOutput.suggestions())
        );
    }

    private String buildPrompt(String stackTrace) {
        return """
                Given the following stack trace, provide:
                1. A clear explanation of the root cause in simple English
                2. A list of possible solutions to fix the issue
                
                Format your response as a JSON object with two fields:
                - 'explanation': A string containing a clear explanation of what went wrong
                - 'suggestions': An array of strings, each containing a concrete suggestion for fixing the problem
                
                Here is the stack trace:
                
                """ + stackTrace;
    }
}