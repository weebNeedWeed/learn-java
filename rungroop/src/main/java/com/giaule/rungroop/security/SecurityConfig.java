package com.giaule.rungroop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(r ->
                        r.requestMatchers("/login", "/register", "/js/**", "/css/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(f -> f.loginPage("/login")
                        .defaultSuccessUrl("/clubs")
                        .failureUrl("/login?error")
                        .loginProcessingUrl("/login")
                        .permitAll())
                .logout(l -> l.logoutUrl("/logout")
                        .logoutSuccessUrl("/clubs").permitAll());

        return http.build();
    }

}
