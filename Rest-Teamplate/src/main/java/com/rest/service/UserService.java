package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	public List<User> findAllUser(){
		return repo.findAll();
	}
	
	public User findUserById(Integer userId) {
		return repo.findById(userId).orElse(null);
	}
	
	public User updateData(User user) {
		return repo.save(user);
	}
	
	public int deleteUserData(Integer userId) {
		 repo.deleteById(userId);
		 return userId;
	}
	
	public User findDataByCityName(String city) {
		return repo.findByCity(city);
	}
	
	public User findByName(String name) {
		return repo.findByUserName(name);
	}
	
	
}
