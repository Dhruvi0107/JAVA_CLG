package com.example.Book_Demo.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Book_Demo.Entity.book;
import com.example.Book_Demo.repositry.bookRepositry;

@Service
public class bookService {
	
	@Autowired
	private bookRepositry BookRepositry;
	
	public void saveBook(book Books)
	{
		BookRepositry.save(Books);
	}
	
	public List<book> getAllBooks()
	{
		return BookRepositry.findAll();
	}
	
	public book getBookByID(String Id) {
		
		book Books = BookRepositry.findById(Id).orElse(null);
		
		return Books;
	}
	
	public book getbook(String id)
	{
		book Books = BookRepositry.findById(id).orElse(null);
		
		return Books;
	}
	
	public book updateBook(book Books) throws IOException
	{
		book oldBooks = getBookByID(Books.getBid());
		
		oldBooks.setBook_name(Books.getBook_name());
		oldBooks.setBook_price(Books.getBook_price());
		oldBooks.setBook_pages(Books.getBook_pages());
		oldBooks.setAuthor_name(Books.getAuthor_name());
		
		book updateBooks = BookRepositry.save(oldBooks);
		
		if(!ObjectUtils.isEmpty(updateBooks))
		{
			return updateBooks;
		}
		
		return null;
		
	}
	
	public boolean deletebook(String id)
	{
		book Books = BookRepositry.findById(id).orElse(null);
		
		if(!ObjectUtils.isEmpty(Books))
		{
			BookRepositry.delete(Books);
			return true;
		}
		return false;
	}

}
