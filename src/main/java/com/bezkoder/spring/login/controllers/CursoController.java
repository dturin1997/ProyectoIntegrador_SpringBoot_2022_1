package com.bezkoder.spring.login.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bezkoder.spring.login.models.Curso;
import com.bezkoder.spring.login.repository.CursoRepository;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CursoController {
	@Autowired
	  CursoRepository cursoRepository;
	
	@GetMapping("/cursos")
	  public ResponseEntity<List<Curso>> getAllCursos(@RequestParam(required = false) String name) {
	    List<Curso> cursos = new ArrayList<Curso>();

	    if (name == null)
	      cursoRepository.findAll().forEach(cursos::add);
	    else
	      cursoRepository.findByNameContaining(name).forEach(cursos::add);

	    if (cursos.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(cursos, HttpStatus.OK);
	  }
	
	@PostMapping("/cursos")
	  public ResponseEntity<Curso> createTutorial(@RequestBody Curso curso) {
	    Curso _curso = cursoRepository.save(new Curso(curso.getName(), curso.getPrecio(),curso.getDescription()));
	    return new ResponseEntity<>(_curso, HttpStatus.CREATED);
	  }
}
