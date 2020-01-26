package com.company.studentControl.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.studentControl.model.Aluno;
import com.company.studentControl.repository.AlunoRepository;
import com.company.studentControl.service.exception.ResourceNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public List<Aluno> findAll() {
		return repo.findAll();
	}
	
	public Aluno findById(Integer id) {
		try {
			return repo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
	
	public Aluno insert(Aluno aluno) {
		return repo.save(aluno);
	}

}
