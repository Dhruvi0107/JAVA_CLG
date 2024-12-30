package com.example.Book_Demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            	.requestMatchers("/").permitAll()
                .requestMatchers("/login", "/signup", "/register").permitAll() // Allow access to these URLs without authentication
                .anyRequest().authenticated() // Require authentication for other requests
                .and()
            .formLogin()
                .loginPage("/login") // Specify the login page URL
                .defaultSuccessUrl("/success",true)
                .permitAll() // Allow everyone to see the login page
                .and()
            .logout()
                .permitAll(); // Allow everyone to log out

        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
