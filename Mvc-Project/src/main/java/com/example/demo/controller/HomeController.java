package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
public class HomeController {

	@Autowired
	public UserRepository repo;

	@RequestMapping("/home")
	public String home() {
		return "registration";
	}

	@RequestMapping("userdata")
	public ModelAndView userdata(User us) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("us", us);
		mv.setViewName("home");
		repo.save(us);
		return mv;
	}
	 
	/*
	 * @RequestMapping("getuserdata") 
	 * public ModelAndView getAlien(@RequestParam int id) 
	 * { 
	 * ModelAndView mv = new ModelAndView("home");
	 *  User user= repo.findById(id).orElse(new User());
	 * 
	 * 
	 * System.out.println(repo.findByFname("Ravi")); 
	 * System.out.println(repo.findByIdGreaterThan(1)); 
	 * System.out.println(repo.findByFnameSorted("Ravi", "Khat")); 
	 * System.out.println(repo.findByLnameSorted("Khat")); mv.addObject(user);
	 * return mv;
	 *  }
	 */
	
	  @PostMapping(path="/user" ,consumes= {"application/json"})
	  public User addUser(@RequestBody User user) {
		  repo.save(user);
		  return user;
	  }
	
	  @GetMapping(path="/users") 
	  public List<User> getUsers() 
	  {
		  return repo.findAll();
	  }
	 
	  @RequestMapping("/user/{id}") 
	  public Optional<User> getUser(@PathVariable("id")int id) 
	  {
		  return repo.findById(id);
	  }

}




