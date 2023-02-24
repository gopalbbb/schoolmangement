package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.Dto.StudentDto;
import com.school.ServiceImp.StudentServiceImp;
import com.school.entity.Student;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentServiceImp studentServiceImp;
	
	@GetMapping("/add")
	public String allStudent(Model model) {
		StudentDto studentdto=new StudentDto();
		
		
		//if you want transfar 
		model.addAttribute("student",studentdto);
		
		return "addstudent";
	}
	
	@GetMapping("/lists/")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	
	public ResponseEntity<Page<Student>>list(@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
	Page<Student> studentlist= studentServiceImp.list(pageNumber,pageSize);
	return new ResponseEntity<Page<Student>>(studentlist,HttpStatus.CREATED);
	}
	/* only render list we can use responce entity format like that 
	 * @GetMapping("/user") // @RequestMapping(name="/user", method =
	 * RequestMethod.GET) public ResponseEntity<List<User>> list() { List<User>
	 * users = userService.list(); return new ResponseEntity<List<User>>(users,
	 * HttpStatus.CREATED); }
	 */

	
	
	@PostMapping("/add")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String addStudent( Model model,@ModelAttribute StudentDto student )
	{
				Student students=studentServiceImp.addStudent(student);
		return "added successfull";	
	}
	
	//Using RequestBody and Dto   
	@PostMapping("/new-student")
	public String put(@Valid @RequestBody StudentDto studentDto) {
		studentServiceImp.addStudent(studentDto);
		return "new student added successfully";
	}
	// using ResponseEntity which helps us to send combine result and we can also change 
	//status code like 201,200 etc whit change CREATE,OK etc
	
	
	@PostMapping("/create-new")
	public ResponseEntity<String>createStudent(@Valid @RequestBody  StudentDto student){
		studentServiceImp.addStudent(student);
		return new ResponseEntity<String>("New Student added Successfull",HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/{id}")
	public Student Id(@PathVariable Integer id) {
		Student student=studentServiceImp.findById(id);
		return student;
	}

}
