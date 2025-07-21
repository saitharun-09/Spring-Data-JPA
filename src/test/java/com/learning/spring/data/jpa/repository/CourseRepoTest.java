package com.learning.spring.data.jpa.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.learning.spring.data.jpa.entity.Course;
import com.learning.spring.data.jpa.entity.Student;
import com.learning.spring.data.jpa.entity.Teacher;

@SpringBootTest
class CourseRepoTest {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Test
	public void printCourse() {
		
		List<Course> course = courseRepo.findAll();
		System.out.println("Courses = " + course );
	}

	@Test
	public void saveCourseWithTeacher() {
		
		Teacher teacher = Teacher.builder()
								 .firstName("Parvathi")
								 .lastName("Jadam")
								 .build();
		
		Course course = Course.builder()
							  .credit(6)
							  .title(".Net")
							  .teacher(teacher)
							  .build();
		
		courseRepo.save(course);
		
	}
	
	@Test
	public void findAllPagination() {
		
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		//Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		
		List<Course> courses = courseRepo.findAll(firstPageWithThreeRecords).getContent();
		
		Long totalElements = courseRepo.findAll(firstPageWithThreeRecords).getTotalElements();
		
		int totalpages = courseRepo.findAll(firstPageWithThreeRecords).getTotalPages();
		
		System.out.println("Total Pages = " + totalpages);
		System.out.println("Total Elements = " + totalElements);
		System.out.println("Courses = " + courses);
		
	}
	
	@Test
	public void findAllSorting() {
		
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending()
														.and(Sort.by("credit")).descending());	
		
		List<Course> courseSortByTitle = courseRepo.findAll(sortByTitle).getContent();
		List<Course> courseSortByCreditDesc = courseRepo.findAll(sortByCreditDesc).getContent();
		List<Course> courseSortByTitleAndCreditDesc = courseRepo.findAll(sortByTitleAndCreditDesc).getContent();
		
		System.out.println("Courses SortByTitle = " + courseSortByTitle);
		System.out.println("Courses SortByCreditDesc = " + courseSortByCreditDesc);
		System.out.println("Courses SortByTitleAndCreditDesc = " + courseSortByTitleAndCreditDesc);

	}
	
	@Test
	public void printFindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		
		List<Course> courses = courseRepo.findByTitleContaining("S", firstPageTenRecords).getContent();
	
		System.out.println("Courses with String = " + courses);
	}
	
	@Test
	public void saveCourseWithStudentAndteacher() {
		Student student = Student.builder()
								 .firstName("lahari")
								 .lastName("jadam")
								 .emailId("jadam.lahari@gmail.com")
								 .build();
		
		Teacher teacher = Teacher.builder()
								 .firstName("kiran")
								 .lastName("bedi")
								 .build();
		
		Course course = Course.builder()
							  .credit(10)
							  .title("AI")
							  .teacher(teacher)
							  .build();
		
		course.addStudents(student);
		
		courseRepo.save(course);
		
								 
		
		
	}
}