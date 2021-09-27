package com.ntp.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntp.restapi.model.Course;
import com.ntp.restapi.service.CourseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/courses")
public class CourseController {

	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@PostMapping()
	public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course course) {
		return new ResponseEntity<Course>(courseService.saveCourse(course), HttpStatus.CREATED);
	}
	
	// Método get para listar a lo estudiantes
	@GetMapping()
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}

	// Método get para listar a un estudiante por su ID
	@GetMapping("{courseId}")
	public ResponseEntity<Course> getStudentById(@PathVariable("courseId") long courseId) {
		return new ResponseEntity<Course>(courseService.getCourseById(courseId), HttpStatus.OK);
	}
	
	@PutMapping("{courseId}")
	public ResponseEntity<Course> updateStudent(@Valid @PathVariable("courseId") long courseId
			  ,@Valid @RequestBody Course course){
		return new ResponseEntity<Course>(courseService.updateCourse(course, courseId), HttpStatus.OK);
	}
	
	@DeleteMapping("{courseId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("courseId") long courseId){
		
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>("Estudiante eliminado exitosamente!.", HttpStatus.OK);
	}
	
}