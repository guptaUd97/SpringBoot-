package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.User;
import com.rest.service.UserService;import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("user/api")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/saveInfo")
	public User saveInfo(@RequestBody User user){
		return service.createUser(user);
	}
	
	@GetMapping("/getInfo")
	public List<User> allUserList(){
		return service.findAllUser();
	}
	
	@GetMapping("{userId}")
	public User getUserById(@PathVariable Integer userId) {
		return service.findUserById(userId);
	}
	
	@PutMapping("/updateData/{userId}")
	public User updateUserInfo(@RequestBody User user,@PathVariable Integer userId) {
		return service.updateData(user);
	}
	
	@DeleteMapping("{userId}")
	public Integer deleteInfo(@PathVariable Integer userId) {
		service.deleteUserData(userId);
		return userId;
	}
	
	@GetMapping("/byCityName/{city}")
	public User getInfoByCity(@PathVariable String city) {
		return service.findDataByCityName(city);
	}
	
	@GetMapping("/byName")
	public User getInfoByName(@RequestParam String name) {
		return service.findByName(name);
	}
	
	
}
