package com.school.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.school.Dto.StudentDto;
import com.school.entity.Student;
public interface StudentService {
	public Student addStudent(StudentDto studentDto);
	
	Page<Student>list();
	
	Student findById(Integer id);
	
	StudentDto delete(Integer id);
	Page<Student>list(Integer pageNumber, Integer pageSize);

}
