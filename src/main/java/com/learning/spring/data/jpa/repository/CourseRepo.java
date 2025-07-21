package com.learning.spring.data.jpa.repository;

import org.springframework.data.domain.Pageable; 
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.learning.spring.data.jpa.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{
	
	Page<Course> findByTitleContaining(String title, Pageable pageable);


}