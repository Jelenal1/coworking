package ch.speercoding.coworking.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authz) -> authz.anyRequest().authenticated()
        )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
