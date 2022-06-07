package com.bezkoder.spring.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.login.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
	//List<Curso> findByNameContaining(String name);
	//List<Curso> findCursosByUsersId(Long userId);

}
