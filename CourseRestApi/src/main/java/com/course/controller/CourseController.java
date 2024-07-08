package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.entites.Course;
import com.course.serviceInterface.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping("/home")
	public String home() {
		return "this is rest api";
	}
	
	@GetMapping("/course")
	public List<Course> getAllCourse(){
		return this.service.getCourse();
	}
	
	//using requestmapping
	//@RequestMapping(path="/course", method = RequestMethod.GET)
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		return this.service.getCourse(courseId);
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return this.service.addCourse(course);
	}
	
	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		return this.service.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.service.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
