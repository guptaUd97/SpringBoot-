package com.course.serviceInterface;

import java.util.List;

import com.course.entites.Course;

public interface CourseService {
	
	List<Course> getCourse();
	
	public Course getCourse(int courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(int parseInteger);

}
