package com.company.studentControl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.studentControl.model.Aluno;
import com.company.studentControl.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public List<Aluno> findAll() {
		return repo.findAll();
	}

}
