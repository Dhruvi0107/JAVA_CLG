package com.example.Book_Demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Book_Demo.Entity.user;
import com.example.Book_Demo.repositry.userRepositry;

@Service
public class userService implements UserDetailsService {
	
	@Autowired
	private userRepositry UserRepositry;

	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		user User = UserRepositry.findUserByEmailid(username);
		
		if(User == null)
		{
			throw new UsernameNotFoundException("User Not Found");
		}
		return new MyuserdataService(User);
	}
	
	public void saveDetails(user User) {
		User.setPassword(passwordEncoder.encode(User.getPassword()));
		UserRepositry.save(User);
	}
}
