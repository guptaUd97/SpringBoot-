package com.spring.imgupload.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.imgupload.Model.ImageData;

@Repository
public interface StroageRepo extends JpaRepository<ImageData, Integer> {
	
	Optional<ImageData> findByName(String fileName);

}
