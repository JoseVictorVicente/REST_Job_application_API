/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.candidateAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Jvicente
 */

@Configuration
@EnableWebSecurity
public class SecurityBootConfig {
    
    
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        UserDetails client = User.builder()
                .username("client")
                .password(encoder.encode("client123"))
                .roles("CLIENT")
                .build();
        
        return new InMemoryUserDetailsManager(admin, client);
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
               .csrf(csrf -> csrf.disable())
               .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
               .authorizeHttpRequests(auth -> auth
               .requestMatchers("/h2-console/**").permitAll()
               .requestMatchers("/admin/**").hasRole("ADMIN")
               .requestMatchers("/client/**").hasRole("CLIENT")
               .anyRequest().authenticated()
            ).httpBasic(Customizer.withDefaults());
        
        return http.build();
    }
}
