package com.bezkoder.spring.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.login.models.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long>{
	List<Curso> findByNameContaining(String name);

}
