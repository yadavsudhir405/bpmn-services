package test.sudhir.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author sudhir
 *         Date:7/11/16
 *         Time:5:48 PM
 *         Project:demo
 */
@Configuration
public class WebSecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {
    /*protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/triggerEmail").hasAuthority("photoReviewers")
                .antMatchers("/approve").hasAuthority("photoReviewers")
                .antMatchers("/").authenticated()
                .and()
                .csrf().disable()
                .httpBasic();
    }*/
}
