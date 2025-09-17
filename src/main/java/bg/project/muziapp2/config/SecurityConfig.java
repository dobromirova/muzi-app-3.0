package bg.project.muziapp2.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        authorizeRequest -> {
                            authorizeRequest
                                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                    .requestMatchers("/", "/login", "login-error","/register","/scss/**","/style.css","/fonts/**").permitAll()
                                    .anyRequest().authenticated();
                        }
                )
                .formLogin(
                        formLogin -> {
                            formLogin.loginPage("/login");
                            formLogin.usernameParameter("username");
                            formLogin.passwordParameter("password");
                            formLogin.defaultSuccessUrl("/", true);
                            formLogin.failureUrl("/login-error");
                        }
                )
                .logout(
                        logout -> {
                            logout.logoutUrl("/logout");
                            logout.logoutSuccessUrl("/");
                            logout.invalidateHttpSession(true);
                        }
                )
                        .build();

    }






}
