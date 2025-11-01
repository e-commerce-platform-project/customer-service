package ru.ivanov.ecommerceplatformproject.userservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
//
//    private final JWTFilter jwtFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .cors(cors -> cors.disable())
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers(HttpMethod.POST, "/api/v1/users").authenticated() // вызов из другого сервиса
////                        .requestMatchers(HttpMethod.POST, "/api/v1/users/verify-credentials").authenticated() // вызов из другого сервиса
////                        .requestMatchers(HttpMethod.GET, "/api/v1/users").authenticated()// вызов из другого сервиса
////                        .requestMatchers(HttpMethod.PATCH, "/api/v1/users").authenticated()
////                        .requestMatchers(HttpMethod.DELETE, "/api/v1/users").authenticated()
////                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/actuator/health").permitAll()
////                        .anyRequest().denyAll()
//                                .requestMatchers("/api/v1/users/verify-code").hasAuthority("ROLE_user-service.role-internal-access")
//                                .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
