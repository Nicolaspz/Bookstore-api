package com.nicolas.Booksore.Exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fieldNme;
	private String fieldMessage;
	public FieldMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FieldMessage(String fieldNme, String fieldMessage) {
		super();
		this.fieldNme = fieldNme;
		this.fieldMessage = fieldMessage;
	}
	public String getFieldNme() {
		return fieldNme;
	}
	public void setFieldNme(String fieldNme) {
		this.fieldNme = fieldNme;
	}
	public String getFieldMessage() {
		return fieldMessage;
	}
	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}

}
