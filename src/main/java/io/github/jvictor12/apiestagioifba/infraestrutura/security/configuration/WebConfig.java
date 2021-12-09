package io.github.jvictor12.apiestagioifba.infraestrutura.security.configuration;

import io.github.jvictor12.apiestagioifba.infraestrutura.security.filter.AuthenticationFilter;
import io.github.jvictor12.apiestagioifba.infraestrutura.security.filter.AuthorizationFilter;
import io.github.jvictor12.apiestagioifba.infraestrutura.security.suport.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;

    private static final String[] PUBLIC_MATCHERS = {};

    @Autowired
    public WebConfig(UserDetailsService userDetailsService, JWTUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
        ;

        http.addFilter(new AuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new AuthorizationFilter(authenticationManager(), userDetailsService, jwtUtil));
        http.cors().configurationSource(corsConfigurationSource());
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        corsConfiguration.setAllowedOrigins(Arrays.asList("https://sap-o5z9bo4d1-blblemos.vercel.app"));
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
