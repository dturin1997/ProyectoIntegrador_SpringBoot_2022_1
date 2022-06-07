package com.bezkoder.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.login.models.CursoUser;
import com.bezkoder.spring.login.models.CursoUserId;

public interface CursoUserRepository extends JpaRepository<CursoUser, Integer>{

}

