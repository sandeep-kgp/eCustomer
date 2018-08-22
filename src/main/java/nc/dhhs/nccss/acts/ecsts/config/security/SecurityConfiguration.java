package nc.dhhs.nccss.acts.ecsts.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import nc.dhhs.nccss.acts.ecsts.web.service.AuthUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
//    private CustomAuthenticationProvider authProvider;
	private AuthUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/welcome*").authenticated()
			.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
			.loginProcessingUrl("/login").defaultSuccessUrl("/welcome", true).successHandler(authSuccessHandler()).permitAll()
			.and().logout().logoutUrl("/logout")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).clearAuthentication(true).invalidateHttpSession(true)
			.logoutSuccessUrl("/logout-success").permitAll()
			.and().exceptionHandling().accessDeniedPage("/accessdenied");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    return authProvider;
	}
	
	@Bean
	UrlAuthenticationSuccessHandler authSuccessHandler(){
		UrlAuthenticationSuccessHandler handler = new UrlAuthenticationSuccessHandler();
		return handler;
	}
	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}

}
