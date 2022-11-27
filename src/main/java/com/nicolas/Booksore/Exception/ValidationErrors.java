package com.nicolas.Booksore.Exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors extends StandardError {
	 
	private List<FieldMessage> errors= new ArrayList<>();

	public ValidationErrors() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationErrors(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
