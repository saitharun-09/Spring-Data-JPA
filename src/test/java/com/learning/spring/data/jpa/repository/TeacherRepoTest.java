package com.learning.spring.data.jpa.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.learning.spring.data.jpa.entity.Course;
import com.learning.spring.data.jpa.entity.Teacher;

@SpringBootTest
class TeacherRepoTest {
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	@Test
	public void saveTeacher() {
		
//		 Course course1 = Course.builder().title("DB").credit(3).build();
//		 Course course2 = Course.builder().title("Hibernate").credit(4).build();
		
		Course course1 = Course.builder()
							  .credit(5)
							  .title("Hibernate")
							  .build();
		
		Course course2 = Course.builder()
				  .credit(5)
				  .title("DB")
				  .build();
		
		Teacher teacher = Teacher.builder()
								 .firstName("Prathibha")
								 .lastName("Jadam")
								 //2q3.courses(List.of(course1,course2))
								 .build();
		
//		teacher.addCourse(course1);
//		teacher.addCourse(course2);
		
		teacherRepo.save(teacher);
	}

}