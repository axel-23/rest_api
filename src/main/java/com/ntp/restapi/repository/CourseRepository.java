package com.ntp.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntp.restapi.model.Course;

public interface CourseRepository extends JpaRepository <Course, Long> {

}
