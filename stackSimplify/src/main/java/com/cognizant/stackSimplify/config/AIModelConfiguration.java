package com.cognizant.stackSimplify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration for AI model settings.
 * This class will be expanded in the future to support multiple AI providers.
 */
@Configuration
public class AIModelConfiguration {

    /**
     * Properties specific to Ollama models
     */
    @Component
    @ConfigurationProperties(prefix = "app.ai.ollama")
    public static class OllamaProperties {
        private boolean enabled = true;
        private String defaultModel = "phi4-mini";

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getDefaultModel() {
            return defaultModel;
        }

        public void setDefaultModel(String defaultModel) {
            this.defaultModel = defaultModel;
        }
    }

    /**
     * Placeholder for future OpenAI configuration
     */
    @Component
    @ConfigurationProperties(prefix = "app.ai.openai")
    public static class OpenAIProperties {
        private boolean enabled = false;
        private String apiKey;
        private String defaultModel = "gpt-3.5-turbo";

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getDefaultModel() {
            return defaultModel;
        }

        public void setDefaultModel(String defaultModel) {
            this.defaultModel = defaultModel;
        }
    }

    /**
     * Placeholder for future Claude configuration
     */
    @Component
    @ConfigurationProperties(prefix = "app.ai.claude")
    public static class ClaudeProperties {
        private boolean enabled = false;
        private String apiKey;
        private String defaultModel = "claude-3-haiku";

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getDefaultModel() {
            return defaultModel;
        }

        public void setDefaultModel(String defaultModel) {
            this.defaultModel = defaultModel;
        }
    }
}