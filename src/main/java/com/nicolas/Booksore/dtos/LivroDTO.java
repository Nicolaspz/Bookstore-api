package com.nicolas.Booksore.dtos;


import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nicolas.Booksore.domain.Categoria;
import com.nicolas.Booksore.domain.Livro;

public class LivroDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "O campo Titulo não pode ser Vazio!")
	@Length(min = 3, max =50, message = "O campo  deve ter entre 3 e 50 caracteres")
	private String titulo;
	
	
	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo =obj.getTitulo();
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
