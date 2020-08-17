package com.example.controller;
import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(){
	  return "registration";
	} 	
	
	@RequestMapping("getuserdata") 
	public ModelAndView home(User use) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("obj", use);
		mv.setViewName("home"); 
		return mv; 
	}
}
