package com.example.SPRING_EXAM_MAVEN.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SPRING_EXAM_MAVEN.Entity.MobileEntity;
import com.example.SPRING_EXAM_MAVEN.Repositry.MobileRepositry;

@Controller
public class HomeController 
{
	
	@Autowired
	private MobileRepositry mobileRepositry;
	
	@GetMapping("/")
	public String home()
	{
		return "Home";
	}
	
	@GetMapping("/addmobile")
	public String mobileadd()
	{
		return "Add_Mobile";
	}
	
	@PostMapping("/addMobile")
	public String addmobile(MobileEntity mobile)
	{
		try
		{
			mobileRepositry.save(mobile);
			return "record_added";
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}
	
	@GetMapping("/showmobile")
	public String showmobile(Model model) 
	{
	    Iterable<MobileEntity> mobileList = mobileRepositry.findAll();
	    model.addAttribute("mobiles", mobileList);
	    
	    return "show_Mobiles";
	}
	
	@GetMapping("/deleteMobile")
	public String deleteMobile(@RequestParam Integer id)
	{
	    mobileRepositry.deleteById(id);
	    return "redirect:/showmobile"; 
	}
	
	@GetMapping("/updateMobile")
	public String updateMobile(@RequestParam Integer id,Model model)
	{
		MobileEntity mobile = mobileRepositry.findById(id).orElse(null);
		model.addAttribute("mobile",mobile);
		
		return "update_Mobile"; 
	}
	
//	@PostMapping("/updateMobile")
//	public String updatedmobile(MobileEntity mobile)
//	{
//		try
//		{
//			mobileRepositry.save(mobile);
//			return "redirect:/showmobile";
//		}
//		catch(Exception ex)
//		{
//			return ex.getMessage();
//		}
//	}
	
	@PostMapping("/updateMobile")
	public String updatedmobile(MobileEntity mobile)
	{
		mobileRepositry.save(mobile);
		return "redirect:/showmobile";
	}
	
}
