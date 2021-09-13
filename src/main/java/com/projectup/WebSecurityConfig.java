package com.projectup;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("usuarioDetailsService")
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/js/**", "/css/**").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/inicio/**").hasAnyAuthority("Administrador")
                .antMatchers("/inicio/**").hasAuthority("Administrador")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/inicio/", true)
                .permitAll()
                .and()
                .logout().permitAll();
    }

}



    /*

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("SELECT username, password, EstaUsua FROM usuario WHERE username= ?")
        .authoritiesByUsernameQuery("SELECT u.username, r.Tiporol FROM rol r INNER JOIN usuario u ON r.IdRol=u.FkIdRol WHERE u.username= ?");
   }

}
*/
