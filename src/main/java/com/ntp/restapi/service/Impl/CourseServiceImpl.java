package com.ntp.restapi.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntp.restapi.exception.ResourceNotFoundException;
import com.ntp.restapi.model.Course;
import com.ntp.restapi.repository.CourseRepository;
import com.ntp.restapi.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}
	
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(long courseId) {
		return courseRepository.findById(courseId).orElseThrow(() ->
						new ResourceNotFoundException("Course", "courseId", courseId));
	}
	
	@Override
	public Course updateCourse(Course course, long courseId) {
		
		// Comprobar si existe en estudiante en la base de datos
		Course existingCourse = courseRepository.findById(courseId).orElseThrow(() -> 
						new ResourceNotFoundException("Course", "courseId", courseId));
		
		// Guardar los datos actualizados
		existingCourse.setCourseName(course.getCourseName());
		existingCourse.setCourseDescription(course.getCourseDescription());
		existingCourse.setCourseLanguaje(course.getCourseLanguaje());
		existingCourse.setCourseDuration(course.getCourseDuration());
		courseRepository.save(existingCourse);
		return existingCourse;
	}
	
	@Override
	public void deleteCourse(long courseId) {
		courseRepository.findById(courseId).orElseThrow(() ->
							new ResourceNotFoundException("Course", "courseId", courseId));
		courseRepository.deleteById(courseId);
	}
	
}