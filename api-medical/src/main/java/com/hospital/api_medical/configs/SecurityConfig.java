package com.hospital.api_medical.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST,"/patients/signup").permitAll()
                        .requestMatchers(HttpMethod.GET,"/medics/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "patients/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "schedules/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "availabilities/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}