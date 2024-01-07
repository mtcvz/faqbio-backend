package io.faqb.auth.model;

import io.faqb.auth.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class User implements UserDetails {

	private int userId;
	private String userName;
	private String password;
	private String mail;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public User(UserEntity entity){
		this.userName = entity.getUserName();
		this.userId = entity.getUserId();
		this.password = entity.getPassword();
		this.active = entity.isActive();
		this.mail = entity.getMail();
		this.authorities = Arrays.stream(entity.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public User(int userId, String username){
		this.userId = userId;
		this.userName = username;
	}

	public User(int userId, String username, String mail){
		this.userId = userId;
		this.userName = username;
		this.mail = mail;
	}

	public User(String username, String password){
		this.userName = username;
		this.password = password;
	}

	public User(){
	}

	public int getUserId() { return userId; }

	@Override public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override public String getPassword() {
		return password;
	}

	@Override public String getUsername() {
		return userName;
	}

	@Override public boolean isAccountNonExpired() {
		return true;
	}

	@Override public boolean isAccountNonLocked() {
		return true;
	}

	@Override public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override public boolean isEnabled() {
		return true;
	}

	public String getMail(){ return this.mail; }
}
