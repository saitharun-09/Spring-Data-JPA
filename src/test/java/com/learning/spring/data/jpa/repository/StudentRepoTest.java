package com.learning.spring.data.jpa.repository;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.learning.spring.data.jpa.entity.Guardian;
import com.learning.spring.data.jpa.entity.Student;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudent() {
    	
        Student student = Student.builder()
                .emailId("sai@gmail.com")
                .firstName("Sai")
                .lastName("Tharun")
                .build();

        studentRepo.save(student);
    }
    
    @Test
    public void saveStudentWithGuardian() {
    	
    	Guardian guardian = Guardian.builder()
    			.name("Parvathi")
    			.email("Parvathi@gmail.com")
    			.mobile("0000000000")
    			.build();
    			
    	Student student = Student.builder()
				.emailId("sainihki@gmail.com")
				.firstName("Sai")
				.lastName("Nikhi")
				.guardian(guardian)
				.build();
    	
    	studentRepo.save(student);
    }
    
    @Test
    public void printAllStudents() {
    	List<Student> studentList = studentRepo.findAll();
    	
    	System.out.println("studnetList = " + studentList);
	}
    
    @Test
    public void printStudentByFirstName() {
    	List<Student> students = studentRepo.findByFirstName("Sai");
    			
   		System.out.println("Studnet = " + students);
    	
    }
    
    @Test
    public void printStudnetContaining() {
    	List<Student> stdContaining = studentRepo.findByFirstNameContaining("Sa");
    	
    	System.out.println("stdContaining = " + stdContaining);
    }
    
    @Test
    public void printgetStudentByEmailId() {
    	Student student = studentRepo.getStudentByEmailId("sainihki@gmail.com");
    	
    	System.out.println("Studnet = " + student);
    }
    
    @Test
    public void PrintgetStudentFirstNameByEmailId() {
    	String firstName = studentRepo.getStudentFirstNameByEmailId("sai@gmail.com");
    	
    	System.out.println("FirstName = " + firstName);
    }
    
    @Test
    public void updateFirstNameByEmailIdTest() {
    	studentRepo.updateFirstNameByEmailId("Pandu", "sai@gmail.com");
    }
}