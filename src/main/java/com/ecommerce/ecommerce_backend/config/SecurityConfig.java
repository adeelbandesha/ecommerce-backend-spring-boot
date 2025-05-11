package com.ecommerce.ecommerce_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing (optional but recommended for APIs)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // ✅ Allow all /api/ requests without login
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated() // Other requests → Require login
            )
            .httpBasic(); // OR .formLogin(); you can remove this for API

        return http.build();
    }
}
