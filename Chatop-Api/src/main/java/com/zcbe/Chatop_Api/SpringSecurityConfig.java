package com.zcbe.chatop_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/public/**").permitAll()  // Exemple: Permet l'accès aux URL commençant par /public
                .anyRequest().authenticated() // Exemple: Nécessite l'authentification pour toutes les autres requêtes
            )
            .formLogin(form -> form
                .loginPage("/login") // Exemple: Spécifie la page de connexion personnalisée
                .permitAll() // Permet l'accès à la page de connexion pour tout le monde
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // Exemple: Spécifie l'URL de déconnexion
                .permitAll() // Permet l'accès à l'URL de déconnexion pour tout le monde
            );
        
        return http.build();
    }
}
