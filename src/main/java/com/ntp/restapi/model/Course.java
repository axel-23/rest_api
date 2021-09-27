package com.ntp.restapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;
	
	@Column(name = "course_image", nullable = false, length = 150)
	@NotEmpty
	@Pattern(regexp = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#()?&=]*)")
	private String courseImage;
	
	@ManyToMany(mappedBy = "studentCourses")
	@JsonIgnore
	private Set<Student> courses = new HashSet<>();
	
	@Column(name = "course_name", nullable = false, length = 150)
	@NotEmpty
	@Size(min = 5, max = 150, message = "El campo nombre debe tener al menos 3 letras")
	@Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+\\w", message = "El campo nombre debe de tener un formato valido")
	private String courseName;
	
	@Column(name = "course_description", nullable = false)
	@NotEmpty
	@Size(min = 5, max = 60, message = "El campo descripción debe tener al menos 10 letras")
	@Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+\\w", message = "El campo descripción debe de tener un formato valido")
	private String courseDescription;
	
	@Column(name = "course_languaje", nullable = false, length = 2)
	@NotEmpty
	@Size(min = 2, max = 2, message = "El campo lenguaje debe tener el formato de ISO 639-1")
	@Pattern(regexp = "[a-zA-z{2}]+\\S")
	private String courseLanguaje;
	
	@Column(name = "course_duration", nullable = false, length = 10)
	private String courseDuration;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(String courseImage) {
		this.courseImage = courseImage;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseLanguaje() {
		return courseLanguaje;
	}

	public void setCourseLanguaje(String courseLanguaje) {
		this.courseLanguaje = courseLanguaje;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Set<Student> getCourses() {
		return courses;
	}

	public void setCourses(Set<Student> courses) {
		this.courses = courses;
	}
	
    public void addStudent(Student student){
        this.courses.add(student);
    }
	
}