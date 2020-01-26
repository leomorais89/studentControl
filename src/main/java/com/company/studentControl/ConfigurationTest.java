package com.company.studentControl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.company.studentControl.model.Aluno;
import com.company.studentControl.repository.AlunoRepository;

@Configuration
public class ConfigurationTest implements CommandLineRunner {
	
	//Classe para popular o banco H2

	@Autowired
	private AlunoRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		
		Aluno aluno1 = new Aluno(null, "Leonardo", 30);
		Aluno aluno2 = new Aluno(null, "Leandro", 32);
		Aluno aluno3 = new Aluno(null, "Rafael", 36);
		
		repo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
		
	}
	
}
