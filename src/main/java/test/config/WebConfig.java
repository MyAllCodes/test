//package test.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import test.component.CustomAuthenticationProvider;
//
//@Configuration
//@EnableWebSecurity
//public class WebConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    CustomAuthenticationProvider customAuthenticationProvider;
//
//    @Override
//    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.authenticationProvider(customAuthenticationProvider);
//    }
//}
