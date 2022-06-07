package com.bezkoder.spring.login.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
@Entity
@Table(name = "cursos_users")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.user",
        joinColumns = @JoinColumn(name = "user_id")),
    @AssociationOverride(name = "primaryKey.curso",
        joinColumns = @JoinColumn(name = "curso_id")) })
*/
@Entity
@Table(name = "curso_user")
public class CursoUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "nota1")
	private double nota1;
	@Column(name = "nota2")
	private double nota2;  
	@Column(name = "nota3")
	private double nota3;
	@Column(name = "promedio")
	private double promedio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	@Override
	public String toString() {
		return "CursoUser [id=" + id + ", curso=" + curso + ", user=" + user + ", nota1=" + nota1 + ", nota2=" + nota2
				+ ", nota3=" + nota3 + ", promedio=" + promedio + "]";
	}
	
}
