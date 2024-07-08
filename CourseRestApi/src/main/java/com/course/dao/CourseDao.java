package com.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entites.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
