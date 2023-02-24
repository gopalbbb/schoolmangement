package com.school.Dto;

import com.school.customValidation.CustomValidation;
import com.school.customValidation.NameValidator;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentDto{

	/* for validation first put dependency in pom  and in post method put @valid annotation)
	 * @NotEmpty Can cover not null vallidation . in validation we can fix size too
	 * . like (@Size (min=4,message = ".. most be 4 character ")LikeEscapeContext )
	 * in Password sometime we can generate patterm too like ABcde1@ like that we can 
	 * use @pattern  annotation
	 */ 

private Integer studentId;

	 @NotEmpty(message = "First name can't empty  ")
	 @NameValidator
	private String firstName;
	 @NotEmpty (message = "Last name can't empty  ")
	private String lastName;
	
	
	 @NotNull (message = "Roll no can't empty")
	private int rollNo;
	 @NotEmpty (message = "House can't empty  ")
	private String house;
	
	 @CustomValidation (message = "Email format invilade")
	 private String email;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	

}
