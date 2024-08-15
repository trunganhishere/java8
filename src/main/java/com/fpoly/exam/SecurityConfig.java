package com.fpoly.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
//        http.csrf().disable(); // ???
//        http.authorizeHttpRequests(r ->
//            r.requestMatchers("/nhan-vien/danh-sach").authenticated()
//                .anyRequest().permitAll()
//        ).formLogin();
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService myservice(){
//        PasswordEncoder pe = new BCryptPasswordEncoder();
//        UserDetails user = User
//                .builder()
//                .username("HangNT169")
//                .password("{bcrypt}" + pe.encode("123@123"))
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(r -> r.requestMatchers("/nhan-vien/danh-sach").authenticated().anyRequest().permitAll())
                .formLogin();
        return http.build();
    }

    @Bean
    public UserDetailsService usDetail(){
        PasswordEncoder pe = new BCryptPasswordEncoder();
        UserDetails userDetails = User
                .builder()
                .username("trunganhishere")
                .password("{bcrypt}"+pe.encode("123"))
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
