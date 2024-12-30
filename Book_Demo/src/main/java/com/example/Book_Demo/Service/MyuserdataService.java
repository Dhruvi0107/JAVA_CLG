package com.example.Book_Demo.Service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Book_Demo.Entity.user;

public class MyuserdataService implements UserDetails {
	
	private user User;
	
	public MyuserdataService(user User)
	{
		this.User = User;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority auth = new SimpleGrantedAuthority(User.getRole());
		return Arrays.asList(auth);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return User.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return User.getEmailid();
	}

}
