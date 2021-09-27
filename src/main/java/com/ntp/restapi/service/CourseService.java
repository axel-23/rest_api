package com.ntp.restapi.service;

import java.util.List;

import com.ntp.restapi.model.Course;

public interface CourseService {

	Course saveCourse(Course course);

	List<Course> getAllCourses();

	Course getCourseById(long courseId);

	Course updateCourse(Course course, long courseId);

	void deleteCourse(long courseId);
}