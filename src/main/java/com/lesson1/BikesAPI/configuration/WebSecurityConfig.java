package com.lesson1.BikesAPI.configuration;

import com.lesson1.BikesAPI.filter.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig extends WebSecurityConfiguration {
    private final JwtTokenFilter jwtTokenFilter;
    private final String basUrl = "/api/v1";

    public WebSecurityConfig(JwtTokenFilter jwtTokenFilter) {

        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
// We need to do this to allow POST requests
        httpSecurity.csrf().disable();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.authorizeHttpRequests()
                .requestMatchers(basUrl+"/members/login").permitAll()
              .requestMatchers(basUrl+"/motorbikes").authenticated();


        // We ensure our own filter is executed before the framework runs its own authentication filter code
        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
