package com.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

}
