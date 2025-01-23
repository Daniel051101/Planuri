//package ro.upt.ac.planuri.utilizatori;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration; 
//
//@Configuration
//public class SecurityConfig {
//
//    private final UserService userService;
//
//    public SecurityConfig(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                .anyRequest().permitAll()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/dashboard", true)
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> userService.findByUsername(username);
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }
//
//	public UserService getUserService() {
//		return userService;
//	}
//}
//
