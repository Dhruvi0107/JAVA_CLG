package com.example.Book_Demo.Entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class book {
	@Id
	private String bid;
	
	private String book_name;
	
	private String book_price;
	
	private String book_pages;
	
	private String author_name;

	public book() {
		super();
		this.bid = UUID.randomUUID().toString();
		// TODO Auto-generated constructor stub
	}

	public book(String bid, String book_name, String book_price, String book_pages, String author_name) {
		super();
		this.bid = bid;
		this.book_name = book_name;
		this.book_price = book_price;
		this.book_pages = book_pages;
		this.author_name = author_name;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_price() {
		return book_price;
	}

	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}

	public String getBook_pages() {
		return book_pages;
	}

	public void setBook_pages(String book_pages) {
		this.book_pages = book_pages;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

}
