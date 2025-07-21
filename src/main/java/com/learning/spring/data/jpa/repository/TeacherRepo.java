package com.learning.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.learning.spring.data.jpa.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long>{

}
