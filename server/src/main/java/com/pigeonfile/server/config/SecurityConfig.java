package com.pigeonfile.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. On rend accessibles /h2-console et /ping sans authentification
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/ping", "/api/ping").permitAll()
                        .anyRequest().authenticated()
                )
                // 2. On désactive CSRF pour la console H2
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )
                // 3. On autorise l'affichage sous forme d'iFrames (nécessaire pour H2)
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                );

        return http.build();
    }
}