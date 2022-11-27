package com.nicolas.Booksore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nicolas.Booksore.domain.Categoria;

public class CategoriaDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "O campo NOME não pode ser Vazio!")
	@Length(min = 3, max = 100, message = "O campo  deve ter entre 3 e 100 caracteres")
	private String nome;
	@NotEmpty(message = "O campo DESCRIÇÂO não pode ser Vazio!")
	@Length(min = 3, max = 200, message = "O campo  deve ter entre 3 e 200 caracteres")
	private String descricao;
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	//unica diferença é q no construtor ele recebe o a Categoria do domain.
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}
	
}
