package com.bezkoder.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.login.entity.Curso;

public interface CursosRepository extends JpaRepository<Curso, Integer> {

}
