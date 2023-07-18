package com.example.bff2.config;

import com.example.bff2.model.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll() // Allow access to the login page
                .antMatchers("/doctors/**").hasRole(UserRole.DOCTOR.name()) // Restrict access based on role
                .antMatchers("/patients/**").hasRole(UserRole.PATIENT.name())
                .and()
                .formLogin()
                .loginPage("/login") // Custom login page
                .defaultSuccessUrl("/home") // Redirect to the home page after successful login
                .and()
                .logout()
                .logoutSuccessUrl("/login") // Redirect to the login page after logout
                .and()
                .csrf().disable(); // Disable CSRF for simplicity (not recommended for production)
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

