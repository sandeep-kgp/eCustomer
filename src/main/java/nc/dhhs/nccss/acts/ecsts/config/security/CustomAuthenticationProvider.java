package nc.dhhs.nccss.acts.ecsts.config.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 
 * Customized Authenticator to handle the credentials validation.
 * @author sandeep
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private final Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		String encodedPassword = passwordEncoder.encode(password);
		
		if (shouldAuthenticateAgainstThirdPartySystem(name, password)) {
			return createAuthenticationToken(name, encodedPassword);
		} else {
			throw new BadCredentialsException("Login Failed");
		}
	}

	Authentication createAuthenticationToken(String name, String encodedPassword) {
		// use the credentials and authenticate against the third-party system
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new UsernamePasswordAuthenticationToken(name, encodedPassword, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	public boolean shouldAuthenticateAgainstThirdPartySystem(String name, String rawPassword){
		logger.info("User:"+name+", Pass:"+rawPassword);
		return "test".equals("test") && "test123".equals(rawPassword);
	}

}

