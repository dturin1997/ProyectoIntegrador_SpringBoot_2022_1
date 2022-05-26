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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "certificates")
public class Certificate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name_certificate")
	@NotBlank
	@Size(max = 200)
	private String name_certificate;
	
	@OneToOne(optional = false ,fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "courses", referencedColumnName = "id")
    private Course courses_idcourses;
	//private Integer courses_idcourses;

    @ManyToOne(optional = true,fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "users", referencedColumnName = "id")
    private User users_user_id;
    //private Integer users_user_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_certificate() {
		return name_certificate;
	}

	public void setName_certificate(String name_certificate) {
		this.name_certificate = name_certificate;
	}

	public Course getCourses_idcourses() {
		return courses_idcourses;
	}

	public void setCourses_idcourses(Course courses_idcourses) {
		this.courses_idcourses = courses_idcourses;
	}

	public User getUsers_user_id() {
		return users_user_id;
	}

	public void setUsers_user_id(User users_user_id) {
		this.users_user_id = users_user_id;
	}

	
    
    
}
