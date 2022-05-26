package com.bezkoder.spring.login.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.login.entity.Curso;
import com.bezkoder.spring.login.repository.CursosRepository;
import com.bezkoder.spring.login.service.ICursosService;

@Service
public class CursosService implements ICursosService {

	@Autowired
	private CursosRepository repocursos;
	public List<Curso> buscarTodos() {
		return repocursos.findAll();
	}

}
