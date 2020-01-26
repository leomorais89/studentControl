package com.company.studentControl.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.studentControl.model.Aluno;
import com.company.studentControl.service.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> alunos = service.findAll();
		return ResponseEntity.ok().body(alunos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findAll(@PathVariable Integer id){
		Aluno aluno = service.findById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> insert(@Valid @RequestBody Aluno aluno) {
		aluno = service.insert(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(aluno);
	}

}
