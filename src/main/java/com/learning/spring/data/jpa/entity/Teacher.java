package com.learning.spring.data.jpa.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

	
	@Id
	@SequenceGenerator(	name = "teacher_sequence",
						sequenceName = "teacher_sequence",
						allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "teacher_sequence")
	private Long teacherId;
	private String firstName;
	private String lastName;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "teacher_Id",
//				referencedColumnName = "teacherId")
//	private List<Course> courses;
//	
//	public void addCourse(Course course) {
//        if (courses == null) {
//            courses = new ArrayList<>();
//        }
//        courses.add(course);
//    }
}