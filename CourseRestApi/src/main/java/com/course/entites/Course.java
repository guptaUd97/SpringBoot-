package com.course.entites;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EntityScan
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {
	
	private int id;
	private String coursename;
	private String discription;

}
