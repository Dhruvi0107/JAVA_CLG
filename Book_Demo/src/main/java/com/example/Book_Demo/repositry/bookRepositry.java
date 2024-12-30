package com.example.Book_Demo.repositry;

import java.util.Optional;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Book_Demo.Entity.book;

public interface bookRepositry extends JpaRepository<book, String> {
	
	public Optional<book> findById(String Id);


}
