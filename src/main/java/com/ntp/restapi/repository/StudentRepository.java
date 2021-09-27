package com.ntp.restapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ntp.restapi.model.Student;


public interface StudentRepository extends JpaRepository <Student, Long>{

	Student findBystudentEmail(String studentEmail);
}