package com.company.studentControl.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		
	}

	public ValidationError(Instant timestamp, Integer status, String erro, String message, String path) {
		super(timestamp, status, erro, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

}
