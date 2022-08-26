package com.example.webapp.config;

import com.example.webapp.service.Impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

    UserServiceImpl userService;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    WebSecurityConfig(UserServiceImpl userService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);

        return authProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                //Доступ только для не зарегистрированных пользователей
                                .antMatchers("/registration").not().fullyAuthenticated()
                                //Доступ только для пользователей с ролью Администратор
                                .antMatchers("/admin/**").hasRole("ADMIN")
                                .antMatchers("/user").authenticated()
                                //Доступ разрешен всем пользователей
                                .antMatchers("/", "/about/**", "/blog/**").permitAll()
                                //Все остальные страницы требуют аутентификации
                                .anyRequest().authenticated()
                )
                //Настройка для входа в систему
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/sign-in")
                                .successForwardUrl("/sign-in")
                                .permitAll())
                .logout(logout ->
                        logout
                                .permitAll()
                                .logoutSuccessUrl("/"));
        return http.build();
    }
}
