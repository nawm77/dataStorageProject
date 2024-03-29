package com.example.datastorageproject.Configuration;

import com.example.datastorageproject.Model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAuthority(Permission.ADMIN_PERMISSION_READ.getPermission())
                .antMatchers("/cars/**").permitAll()
                .antMatchers("/employee/**").hasAnyAuthority(Permission.ADMIN_PERMISSION_READ.getPermission())
                .antMatchers("/callback/list").hasAnyAuthority(Permission.ADMIN_PERMISSION_READ.getPermission(), Permission.EMPLOYEE_PERMISSION_READ.getPermission())
                .antMatchers("/callback/delete/**").hasAnyAuthority(Permission.ADMIN_PERMISSION_READ.getPermission(), Permission.EMPLOYEE_PERMISSION_READ.getPermission())
                .antMatchers("/customer/list/**").hasAnyAuthority(Permission.ADMIN_PERMISSION_READ.getPermission(), Permission.EMPLOYEE_PERMISSION_READ.getPermission())
                .antMatchers("/service/**").authenticated()
                .antMatchers("/testdrive/**").authenticated()
                .antMatchers("/orders/**").hasAnyAuthority(Permission.ADMIN_PERMISSION_READ.getPermission(), Permission.EMPLOYEE_PERMISSION_READ.getPermission())
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .permitAll()
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutUrl("/auth/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/");
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}