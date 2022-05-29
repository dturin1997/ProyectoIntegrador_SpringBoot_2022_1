package com.bezkoder.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.login.exception.ResourceNotFoundException;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.repository.CursoRepository;
import com.bezkoder.spring.login.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/cursos/{cursoId}/users")
	public ResponseEntity<User> addUser(@PathVariable(value = "cursoId") Long cursoId,
			@RequestBody User userRequest) {
		User user = cursoRepository.findById(cursoId).map(curso -> {
			long userId = userRequest.getId();

			// tag is existed
			if (userId != 0L) {
				User _user = userRepository.findById(userId)
						.orElseThrow(() -> new ResourceNotFoundException("Not found user with id = " + userId));
				curso.addUser(_user);
				cursoRepository.save(curso);
				return _user;
			}

			// add and create new Tag
			curso.addUser(userRequest);
			return userRepository.save(userRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Not found Curso with id = " + cursoId));

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}
