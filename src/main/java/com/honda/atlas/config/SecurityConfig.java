package com.honda.atlas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcUserDetailsManager userDetailsManager() {
        return new JdbcUserDetailsManager(this.dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
//                .authorizeRequests()
//                .antMatchers("/css/**","/img/**", "/signup", "/logout").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/userAuth")
//                .loginPage("/login")
//                .failureUrl("/login-error")
//                .defaultSuccessUrl("/home")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//                .deleteCookies("JSESSIONID")
//                .invalidateHttpSession(true)
//                .and()
//                .csrf   ().disable();

    }
}
