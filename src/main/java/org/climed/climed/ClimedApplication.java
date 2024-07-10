package org.climed.climed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ClimedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClimedApplication.class, args);
    }

    @Bean
    public WebClient.Builder getWebClient() {
        return WebClient.builder();
    }

}
