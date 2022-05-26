package com.bezkoder.spring.login.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "courses")
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name_course")
	@NotBlank
	@Size(max = 80)
	private String name_course;
	
	@Column(name="description")
	@NotBlank
	@Size(max = 200)
	private String description;
	
	@Column(name="price_course")
	@NotBlank
	private double price_course;
	
	@Column(name="image")
	private String image;
	
	@ManyToOne(optional = true, cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
	@JoinColumn(name = "users", referencedColumnName = "id")
	private User users_user_id;
	//private Integer users_user_id;

	public Course() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_course() {
		return name_course;
	}

	public void setName_course(String name_course) {
		this.name_course = name_course;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUsers_user_id() {
		return users_user_id;
	}

	public void setUsers_user_id(User users_user_id) {
		this.users_user_id = users_user_id;
	}

	
	
	
}
