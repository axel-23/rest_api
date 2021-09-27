package com.ntp.restapi.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntp.restapi.exception.ResourceNotFoundException;
import com.ntp.restapi.model.Student;
import com.ntp.restapi.repository.StudentRepository;
import com.ntp.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student findBystudentEmail(String studentEmail) {
		return studentRepository.findBystudentEmail(studentEmail);
	}
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long studentId) {
		return studentRepository.findById(studentId).orElseThrow(() ->
						new ResourceNotFoundException("Student", "studentId", studentId));
	}
	
	@Override
	public Student updateStudent(Student student, long studentId) {
		
		// Comprobar si existe en estudiante en la base de datos
		Student existingStudent = studentRepository.findById(studentId).orElseThrow(
				() -> new ResourceNotFoundException("Student", "studentId", studentId)); 
		
		// Guardar los datos actualizados
		existingStudent.setStudentAvatar(student.getStudentAvatar());
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setStudentLastName(student.getStudentLastName());
		existingStudent.setStudentEmail(student.getStudentEmail());
		existingStudent.setStudentDob(student.getStudentDob());
		studentRepository.save(existingStudent);
		return existingStudent;
	}
	
	@Override
	public void deleteStudent(long studentId) {
		studentRepository.findById(studentId).orElseThrow(() ->
							new ResourceNotFoundException("Student", "studentId", studentId));
		studentRepository.deleteById(studentId);
	}

	
	
}