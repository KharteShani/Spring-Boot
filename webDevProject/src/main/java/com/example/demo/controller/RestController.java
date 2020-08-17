package com.example.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
@SpringBootApplication
@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {
		@Autowired
		private UserService service;
		
		@PostMapping("/save-user")
		@Transactional
		public String registerUser(@RequestBody User user) {
			service.saveMyUser(user);
			return "Hello "+user.getFname()+" your registration is successful";
		}
		
		@GetMapping("/all-users")
		public Iterable<User> showAllUsers() {
			return service.showAllUsers();
		}
		
		@GetMapping("/delete/{username}")
		@Transactional
		public Iterable<User> deleteUsers(@PathVariable String username){
			return service.deleteUser(username);
		}
		
		@GetMapping("/search/{username}")
		@Transactional
		public User usersName(@PathVariable String username){
			return service.findByUsername(username);
		}
		
}
