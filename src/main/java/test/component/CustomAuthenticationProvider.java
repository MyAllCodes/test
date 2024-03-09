package test.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import test.beans.CustomUserDetails;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("authenticate method called");
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        CustomUserDetails user = customUserDetailsService.loadUserByUsername(username);
        if(user!=null&&password.equalsIgnoreCase(user.getPassword())) {
        	return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        }else {
        	throw new BadCredentialsException("Authentication failed");
        }
    }
	

    @Override
    public boolean supports(Class<?> authentication) {
    	System.out.println("support method called");
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
