package com.learning.spring.data.jpa.repository;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.learning.spring.data.jpa.entity.Course;
import com.learning.spring.data.jpa.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepoTest {
	
	@Autowired
	private CourseMaterialRepo courseMaterialRepo;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
							  .title("C#")
							  .credit(6)
							  .build();
				
		CourseMaterial courseMaterial = CourseMaterial.builder()
										.url("www.chatGPT.com")
										.course(course)
										.build();
		
		courseMaterialRepo.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterial() {
		
		List<CourseMaterial> courseMaterial = courseMaterialRepo.findAll();
		
		System.out.println("courseMaterial = " + courseMaterial);
		
	}

}