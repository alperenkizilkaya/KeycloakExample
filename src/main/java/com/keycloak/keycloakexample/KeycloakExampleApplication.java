package com.keycloak.keycloakexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class KeycloakExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakExampleApplication.class, args);
    }

}
