package com.ntp.restapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private long studentId;
	
	@Column(name = "student_avatar", nullable = false, length = 150)
	@NotEmpty
	@Pattern(regexp = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#()?&=]*)")
	private String studentAvatar;
	
	@Column(name = "student_name", nullable = false, length = 50)
	@NotEmpty
	@Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+\\w", message = "El campo nombre debe de tener un formato valido")
	@Size(min = 3, max = 50, message = "El campo apellido debe tener al menos 3 letras")
	private String studentName;
	
	@Column(name = "student_lastname", nullable = false, length = 60)
	@NotEmpty
	@Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+\\w", message = "El campo apellido debe de tener un formato valido")
	@Size(min = 5, max = 60, message = "El campo apellido debe tener al menos 5 letras")
	private String studentLastName;
	
	@Column(name = "student_dob", nullable = false, length = 4)
	@Range(min = 1900, max = 2006, message = "El campo año debe tener solo el año de nacimiento")
	private int studentDob;
	
	@Column(name = "student_email ", unique = true, nullable = false, length = 50)
	@NotEmpty
	@Email(message = "Debe introducir un correo valido")
	private String studentEmail;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
	
    Set<Course> studentCourses = new HashSet<>();

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentAvatar() {
		return studentAvatar;
	}

	public void setStudentAvatar(String studentAvatar) {
		this.studentAvatar = studentAvatar;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}
	
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public int getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(int studentDob) {
		this.studentDob = studentDob;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Set<Course> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<Course> studentCourses) {
		this.studentCourses = studentCourses;
	}
	
}