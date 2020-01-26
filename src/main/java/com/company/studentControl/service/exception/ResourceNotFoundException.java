package com.company.studentControl.service.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//Classe para tratar exceção
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
