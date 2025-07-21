package com.learning.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.learning.spring.data.jpa.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepo extends JpaRepository<CourseMaterial, Long>{

}
