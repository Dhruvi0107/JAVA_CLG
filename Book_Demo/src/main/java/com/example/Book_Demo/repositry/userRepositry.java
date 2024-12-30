package com.example.Book_Demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Book_Demo.Entity.user;

public interface userRepositry extends JpaRepository<user, String>{
	
	user findUserByEmailid(String emailid);

}
