package ro.upt.ac.planuri.utilizatori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SuppressWarnings("unused")
	@Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Dezactivare CSRF pentru API
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/home", "/login", "/signup").permitAll() // Permite accesul la pagina de login
                    .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login") // Specifică ruta paginii de login
                .defaultSuccessUrl("/home", true)
                .permitAll()
            )
            .logout(logout -> logout
        	    .logoutUrl("/logout")
        	    .logoutSuccessUrl("/home") // După logout, redirecționează către /home
        	    .permitAll()
            );

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


