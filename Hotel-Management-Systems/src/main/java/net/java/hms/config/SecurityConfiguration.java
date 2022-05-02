//package net.java.hms.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import net.java.hms.service.UserDetailsService;
//import net.java.hms.service.impl.UserDetailsServiceImpl;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
//{
//
//@Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable().authorizeRequests().antMatchers(
////                "/registration**",
////               "/js/**",
////                "/css/**",
////                "/img/**").permitAll()
////            .anyRequest().authenticated()
////            .and()
////            .formLogin()
////            .loginPage("/login")
////            .permitAll()
////            .and()
////            .logout()
////            .invalidateHttpSession(true)
////            .clearAuthentication(true)
////            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////            .logoutSuccessUrl("/login?logout")
////            .permitAll();
////    }
//
//@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//            .antMatchers("/").hasAnyAuthority("RECEPTIONIST", "ADMIN", "PHYSICIAN")
//            .antMatchers("/fetchUsers", "/saveUser").hasAnyAuthority("RECEPTIONIST", "ADMIN", "PHYSICIAN")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll()
//            .and()
//            .logout().permitAll()
//            .and()
//            .exceptionHandling().accessDeniedPage("/403")
//            ;
//    }
//
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userDetailsService());
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//	@Bean
//    public AuthenticationManager customAuthenticationManager() throws Exception {
//        return authenticationManager();
//    }
//
//}