package com.example.john.gestion_centro_educativo.configuracion;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class securityConfiguration {
     @Autowired
        private DataSource dataSource;

        // Podemos crear nuestra propia clase para autenticar a los usuarios
        // o bien usar un AuthenticationManagerBuilder.

        @Autowired
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.jdbcAuthentication()
                                .dataSource(dataSource)
                                .usersByUsernameQuery("select username, password, enabled "
                                                + "from user "
                                                + "where username = ?")
                                .authoritiesByUsernameQuery("select username, rol.nombre from user, rol "
                                                +"where user.rol_id= rol.id  and  username = ?");
        }

        /*
         * @Bean UserDetailsService userDetailsService(){
         * return new MyCustomUserDetailsService();
         * }
         */
        @Bean
        public PasswordEncoder encoder() {
                return new BCryptPasswordEncoder();
        }
         

        @Bean
        public SecurityFilterChain filter(HttpSecurity http) throws Exception {
                
                // Con Spring Security 6.2 y 7: usando Lambda DSL

                http
                        .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/webjars/**", "/img/**", "/js/**", "/register/**", "/ayuda/**", "/login")
                                .permitAll() 
                                .requestMatchers("/alumnos/**", "/profesores/**", "/asignaturas/**")
                                //.authenticated()
                                .hasAuthority("alumno")
                        ).authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/webjars/**", "/img/**", "/js/**", "/register/**", "/ayuda/**", "/login")
                                .permitAll() 
                                .requestMatchers("/alumnos/**", "/profesores/**", "/asignaturas/**")
                                //.authenticated()
                                .hasAuthority("profesor")
                        ).authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/webjars/**", "/img/**", "/js/**", "/register/**", "/ayuda/**", "/login")
                                .permitAll() 
                                .requestMatchers("/usuarios/**", "/alumnos/**", "/profesores/**", "/asignaturas/**",
                                        "/matriculaAlumnos/**", "/matriculaProfesores/**")
                                //.authenticated()
                                .hasAuthority("gestor")
                        ).formLogin((formLogin) -> formLogin
                                .permitAll()
                        ).rememberMe(
                            Customizer.withDefaults()
                        ).logout((logout) -> logout
                                .invalidateHttpSession(true)
                                .logoutSuccessUrl("/")
                                // .deleteCookies("JSESSIONID") // no es necesario, JSESSIONID se hace por defecto
                                .permitAll()                                
                       
                        );
                return http.build();

        }

}
