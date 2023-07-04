package com.unoveo.security;

import com.unoveo.security.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.unoveo")
public class ApplicationConfiguration {
//    @Bean
//    public AuthenticationManager authenticationManager(){
//        return new AuthenticationManager() {
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                String username = authentication.getName();
//                String password = authentication.getCredentials().toString();
//                // to add more logic
//                ArrayList<GrantedAuthority> grantedAuths = new ArrayList<>();
//                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
//                return new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
//            }
//        };
//    }
//    @Bean
//    public JwtResponseModel jwtResponseModel(){
//        return new JwtResponseModel(jwtResponseModel().getToken());
//    }








}