package com.bbd.Covid19_App.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT [login],[password],[enabled] FROM [COVID].[dbo].[covid_users] WHERE [login] = ?")
                .authoritiesByUsernameQuery("SELECT [login],[role] FROM [COVID].[dbo].[covid_users] WHERE [login] = ?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/","/patient/**","/export/excel").hasAnyAuthority("admin","user")
                .antMatchers("/admin/**").hasAuthority("admin") // TODO: only admin can have access to /user/add, /user/save, /user/all, /user/edit
                .and()
                .formLogin()
                    .loginPage("/login");
    }
}
