package com.bezkoder.spring.login.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcourses;
	private String name_course;
	private String description;
	private double price_course;

	public Integer getIdcourses() {
		return idcourses;
	}

	public void setIdcourses(Integer idcourses) {
		this.idcourses = idcourses;
	}

	public String getName_course() {
		return name_course;
	}

	public void setName_courses(String name_courses) {
		this.name_course = name_courses;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice_course() {
		return price_course;
	}

	public void setPrice_course(double price_course) {
		this.price_course = price_course;
	}

	@Override
	public String toString() {
		return "Curso [idcourse=" + idcourses + ", name_courses=" + name_course + ", decripion=" + description
				+ ", price_course=" + price_course + "]";
	}

}
