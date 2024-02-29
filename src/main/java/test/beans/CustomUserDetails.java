package test.beans;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails{
	
	private String username;
	private String password;
	private List<GrantedAuthority> roles;
	
	public CustomUserDetails(UserModel user) {
		super();
		this.username = user.getUsername();
		this.password = user.getPassword();
		String[] roleArray = user.getRoles().split(",");
		for(String role:roleArray) {
			roles.add(new SimpleGrantedAuthority(role));
		}
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return username;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return password;
	}
	
	

}
