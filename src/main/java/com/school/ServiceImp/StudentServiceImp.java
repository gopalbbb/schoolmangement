package com.school.ServiceImp;







import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.school.Dto.StudentDto;
import com.school.Repository.StudentRepo;
import com.school.entity.Student;
import com.school.service.StudentService;



@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	StudentRepo studentRepo;
	

	@Override
	public Student addStudent(StudentDto studentDto) {
		Student student=new Student();
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setRollNo(studentDto.getRollNo());
		student.setHouse(studentDto.getHouse());
		student.setEmail(studentDto.getEmail());
		
		return studentRepo.save(student);
	}
// pageable helps us to dispaly our list on the page . in the page request we can define how many page 
	//And how many value want store we can give size .
	@Override
	public Page <Student> list() {
	   Pageable page=PageRequest.of(1, 5);
		Page<Student>student= studentRepo.findAll(page);
		return student;
	}

	@Override
	public Student findById(Integer id) {
		
		
		 return studentRepo.findById(id).get();
	}

	@Override
	public StudentDto delete(Integer id) {
		return null;}

	@Override
	public Page<Student> list(Integer pageNumber, Integer pageSize) {
		Pageable pageable =PageRequest.of(pageNumber -1, pageSize,Sort.by("firstName").descending());
		 Page<Student> student=studentRepo.findAll(pageable);	
		return student;
	
	}
	

}
