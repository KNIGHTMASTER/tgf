package id.co.telkomsigma.tgf.web.admin.vaadin.config;

import com.vaadin.spring.annotation.EnableVaadin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * Created on 10/26/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@EnableWebSecurity
@EnableVaadin
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private AppAccessDeniedHandler appAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login/**").anonymous()
                .antMatchers("/THEME", "/VAADIN/**", "/PUSH/**", "/UIDL/**", "/error/**", "/403/**", "/vaadinServlet/**").permitAll()
                .antMatchers("/admin**").fullyAuthenticated()
                .and()
                    .logout()
                    .permitAll();
        http.csrf().disable();
        http.exceptionHandling().accessDeniedHandler(appAccessDeniedHandler);
        http.exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("CONFIGURE GLOBAL");
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("password")
            .roles("ADMIN");
    }
}
