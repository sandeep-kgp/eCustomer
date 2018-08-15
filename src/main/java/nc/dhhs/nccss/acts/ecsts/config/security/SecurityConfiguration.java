package nc.dhhs.nccss.acts.ecsts.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomAuthenticationProvider authProvider;

//	@Autowired
//	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userDetailsService);
//		auth.authenticationProvider(authProvider);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/welcome*").authenticated()
			.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
			.loginProcessingUrl("/login").defaultSuccessUrl("/welcome", true).successHandler(authSuccessHandler()).permitAll()
			.and().logout().invalidateHttpSession(true).logoutUrl("/logout").logoutSuccessUrl("/logout-success").permitAll()
			.and().csrf().and().exceptionHandling().accessDeniedPage("/accessdenied");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

//	@Bean
//	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
//		PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
//				"remember-me", userDetailsService, tokenRepository);
//		return tokenBasedservice;
//	}
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
