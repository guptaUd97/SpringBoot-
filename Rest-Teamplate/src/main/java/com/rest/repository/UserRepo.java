package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByCity(String city);
	public User findByUserName(String userName);
	
	@Query(value = "SELECT * FROM user_data rs WHERE rs.user_name LIKE '%mr%';", nativeQuery = true)
    public User findByDepartments(String userName);

}
