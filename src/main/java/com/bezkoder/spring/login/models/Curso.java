package com.bezkoder.spring.login.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "precio")
	private double precio;

	@Column(name = "description")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "cursos_users", joinColumns = { @JoinColumn(name = "cursos_id") }, inverseJoinColumns = {
			@JoinColumn(name = "users_id") })
	private Set<User> users = new HashSet<>();
	
	public Curso() {
		
	}
	
	public Curso(String name, double precio, String description) {
		super();
		this.name = name;
		this.precio = precio;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
	    this.users.add(user);
	    user.getCursos().add(this);
	  }
	  
	  public void removeUser(long userId) {
	    User user = this.users.stream().filter(t -> t.getId() == userId).findFirst().orElse(null);
	    if (user != null) {
	      this.users.remove(user);
	      user.getCursos().remove(this);
	    }
	  }

	@Override
	public String toString() {
		return "Curso [id=" + id + ", name=" + name + ", precio=" + precio + ", description=" + description + ", users="
				+ users + "]";
	}
	

}
