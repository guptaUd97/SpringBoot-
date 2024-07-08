package com.course.serviceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.CourseDao;
import com.course.entites.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao dao;
	//hardcode List for try
	List<Course> list;
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(101,"spring boot","this is springboot rest api"));
		list.add(new Course(102,"java","basic of core java"));

	}
	
	@Override
	public List<Course> getCourse() {
		//return list;
		return dao.findAll();
	}

	@Override
	public Course getCourse(int courseId) {
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return dao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		dao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setCoursename(course.getCoursename());
//				e.setDiscription(course.getDiscription());
//			}
//		});
		dao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(int parseInteger) {
		//list=this.list.stream().filter(e->e.getId() !=parseInteger).collect(Collectors.toList());
	 Course entity=	dao.getOne(parseInteger);
	 dao.delete(entity);
	}

}
