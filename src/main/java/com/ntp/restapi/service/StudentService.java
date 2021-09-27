package com.ntp.restapi.service;

import java.util.List;

import com.ntp.restapi.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(long studentId);

	Student updateStudent(Student student, long studentId);
	
	void deleteStudent(long studentId);

	Student findBystudentEmail(String studentEmail);

}