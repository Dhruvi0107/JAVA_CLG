package com.example.Book_Demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Book_Demo.Entity.book;
import com.example.Book_Demo.Entity.user;
import com.example.Book_Demo.Service.bookService;
import com.example.Book_Demo.Service.userService;
import com.example.Book_Demo.repositry.userRepositry;


@Controller
public class MainController {
	
	@Autowired
	private bookService BookService;
	
	@Autowired
	private userRepositry UserRepositry; 
	
	@Autowired
	public userService UserService;
	
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping("/signup")
	public String signupPage(Model m , user User)
	{	
		m.addAttribute("Users", User);
		
		return "registration";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("User") user Users , Model m)
	{
		Users.setRole("USER");
        UserService.saveDetails(Users);
        m.addAttribute("successMessage", "User Registered Successfully!");
        
        return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String loginPage(@RequestParam(value="error",required = false) String error,@RequestParam(value = "logout",required = false)String logout,Model m) {
		if(error!=null) {
			m.addAttribute("error","Invalid Login");
		}
		else if(logout!=null) {
			m.addAttribute("logout","Logout Successfullyy");
		}
		return "login";
	}
	
	 @RequestMapping("/success")
	 public String successPage()
	 {
		 return "success"; 
	 }
	
	@RequestMapping("/addbook")
	public String addbook()
	{
		return "add_book";
	}

	
	@PostMapping("/addbook")
	public String saveBookDetails(Model m,book Books) 
	{
		BookService.saveBook(Books);
		
		if(Books != null)
		{
			m.addAttribute("succMsg", "Book Added Sucessfully..!");
			return "redirect:/showbooks";
		}
		else
		{
			m.addAttribute("errorMsg","Somthing Wrong On Server..!");
		}
		return "add_book";		
	}
	
	@RequestMapping("/editbook/{id}")
	public String editbook(@PathVariable String id, Model m)
	{
	    book books = BookService.getBookByID(id);
	    if (books != null)
	    {
	        m.addAttribute("book", books);
	        return "edit_book";
	    } else
	    {
	        m.addAttribute("errorMsg", "Book not found");
	        return "redirect:/showbooks";
	    } 
	}
	
	@PostMapping("/updatebook")
	public String updatebook(@ModelAttribute book Books , Model m) throws Exception
	{
		book updateBooks = BookService.updateBook(Books);
		
		if(!ObjectUtils.isEmpty(updateBooks))
		{
			m.addAttribute("succmsg","Book Updated Sucessfully..!");
		}
		else
		{
			m.addAttribute("errorMsg", "Somthing Wrong on Server..!");
		}
		
		 return "redirect:/showbooks";
	}
	
	@GetMapping("/showbooks")
	public String showbooks(Model m)
	{
		List<book> Books = BookService.getAllBooks();
		m.addAttribute("books", Books);
		
		return "show_books";
	}
	
	@GetMapping("/deletebook/{id}")
	public String deletebook(@PathVariable String id, Model m)
	{
		boolean deleteBook = BookService.deletebook(id);
		
		if(deleteBook)
		{
			m.addAttribute("succMsg","Book Sucessfully Delete..!");
		}
		else
		{
			m.addAttribute("errorMsg","Somthing Wrong On Server..!");
		}
		
		 return "redirect:/showbooks";
	}
}
