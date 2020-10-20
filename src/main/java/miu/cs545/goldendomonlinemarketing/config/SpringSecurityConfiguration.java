package miu.cs545.goldendomonlinemarketing.config;

import miu.cs545.goldendomonlinemarketing.UserAccount.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
/*
    @Autowired
    DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
////                .dataSource(dataSource)
////                .withDefaultSchema()
////                .withUser(
////                        Person.withUsername("user")
////                        .password("user")
////                        .roles("USER")
////                )
////                .withUser(
////                        Person.withUsername("admin")
////                        .password("admin")
////                        .roles("ADMIN")
////                );

        *//**
         * When the schema is the default, match Spring Security doc
         *//*
//        auth.jdbcAuthentication()
//                .dataSource(dataSource);

        *//**
         * If your schema isn't default, override query
         *//*
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");


    }*/

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/", "/h2-console/**").permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
//                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error=true")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/perform_logout") //change default /logout url to /perform_logout
                    .logoutSuccessUrl("/login?logout=true")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .permitAll()
                .and()
                .exceptionHandling()
                    .accessDeniedPage("/denied");

        //Those two settings below is to enable access h2 database via browser
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}