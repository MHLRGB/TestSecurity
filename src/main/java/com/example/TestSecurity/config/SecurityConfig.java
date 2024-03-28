package com.example.TestSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public RoleHierarchy roleHierarchy() {
//
//        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
//
//        // C는 B보다 권한이 높고, B는 A보다 권한이 높다.
//        hierarchy.setHierarchy("ROLE_C > ROLE_B\n" +
//                "ROLE_B > ROLE_A");
//
//        return hierarchy;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // CORS 오류 대응
        http.cors(httpSecurityCorsConfigurer ->
                httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource())
        );
//
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.GET, "/index*", "/static/**", "/*.js", "/*.json", "/*.ico", "/rest",
                                "/test","/login","/join","/joinProc","/")
                        .permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );
//
//        // C는 B보다 권한이 높고, B는 A보다 권한이 높다.
////        http
////                .authorizeHttpRequests((auth) -> auth
////                        .requestMatchers("/login").permitAll()
////                        .requestMatchers("/").hasAnyRole("A")
////                        .requestMatchers("/manager").hasAnyRole("B")
////                        .requestMatchers("/admin").hasAnyRole("C")
////                        .anyRequest().authenticated()
////                );
//
        http
                .formLogin((auth) -> auth.loginPage("/login") // 오류 페이지 접근 시 자동으로 login 페이지로 리다이렉션
                        .loginProcessingUrl("/loginProc") // 프론트에서 넘겨준 login 정보를 Scurity가 받게 됨
                        .permitAll()
                );
//
        http
                .csrf((auth) -> auth.disable()); // csrf토큰을 보내지 않으면 로그인이 진행되지 않기 때문에 잠시 disable
//
//        http
//                .sessionManagement((auth) -> auth
//                        .maximumSessions(1) // 하나의 아이디에서 동시 접속 중복 로그인 수
//                        .maxSessionsPreventsLogin(true)); // 위의 값을 초과했을 경우
//                                                          // true : 새로운 로그인 차단
//                                                          // false : 기존 로그인 세션 하나 삭제 후 새로운 로그인 진행
//        http
//                .sessionManagement((auth) -> auth
//                        .sessionFixation().changeSessionId());
//                        // sessionFixation().changeSessionId : 세션 고정 보호. 로그인 시 동일한 세션을 유지하지만, 발급되는 id를 바꿔줌. 보안용 설정


        return http.build();
    }

    // CORS 오류 대응
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowedOriginPatterns(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // 모든 경로에 대해서 CORS 설정을 적용

        return source;
    }


}