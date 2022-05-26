package com.bezkoder.spring.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.login.entity.Curso;
import com.bezkoder.spring.login.service.ICursosService;

@RestController
@RequestMapping("/api")
public class CursosController {
	
	@Autowired
	private ICursosService serviceCurscos;
	
	@GetMapping("/cursos")
	public List<Curso> buscarTodos(){
		return serviceCurscos.buscarTodos();
	}
}
