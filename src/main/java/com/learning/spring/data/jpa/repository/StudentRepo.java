package com.learning.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.learning.spring.data.jpa.entity.Student;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByFirstNameContaining(String name);
	
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmailId(String emailId);
	
	@Query("select s.firstName from Student s where s.emailId=?1")
	String getStudentFirstNameByEmailId(String emailId);
	
	@Modifying
	@Transactional
	@Query(value = "update table_student set first_name = ?1 where email_address = ?2 ",
			nativeQuery = true)
	int updateFirstNameByEmailId(String firstName, String emailId);
}