package com.ntp.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntp.restapi.model.Student;
import com.ntp.restapi.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/students")
@ControllerAdvice
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// Método post para agregar un nuevo estudiante
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED); 
		
	}

	// Método get para listar a lo estudiantes
	@GetMapping()
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	// Método get para listar a un estudiante por su ID
	@GetMapping("{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") long studentId) {
		return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
	}
	
	@PutMapping("{studentId}")
	public ResponseEntity<Student> updateStudent(@Valid @PathVariable("studentId") long studentId ,@Valid @RequestBody Student student){
        	
        return new ResponseEntity<Student>(studentService.updateStudent(student, studentId), HttpStatus.OK);
		
	}
	
	@DeleteMapping("{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") long studentId){
		
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Estudiante eliminado exitosamente!.", HttpStatus.OK);
	}


}
