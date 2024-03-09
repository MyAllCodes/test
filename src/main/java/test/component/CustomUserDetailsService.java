package test.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import test.beans.CustomUserDetails;
import test.daos.TestDao;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private TestDao testDao;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username in CustomUserDetailsService : "+username);
		return new CustomUserDetails(testDao.getDataByUsername(username));
	}

}
