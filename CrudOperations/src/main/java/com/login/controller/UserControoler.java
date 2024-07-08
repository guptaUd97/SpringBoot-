package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.entity.User;
import com.login.repository.UserRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/rrr")
public class UserControoler {
	
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user)
	{
		return repo.save(user);
	}
	
	@GetMapping("/getAllUser")
	List<User> getAllUser(){
		return repo.findAll();
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable Integer id) {
		return repo.getById(id);
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String DeleteUser(@PathVariable Integer id) {
		 repo.deleteById(id);
		 return "Deleted";
	}
	
	

}
