package com.nicolas.Booksore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicolas.Booksore.Exception.ObjectNotFoundException;
import com.nicolas.Booksore.domain.Categoria;
import com.nicolas.Booksore.domain.Livro;
import com.nicolas.Booksore.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository repository;
	@Autowired
	CategoriaService CatService;

	public Livro findById(Integer id) {

		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Object não encontrado ID " + id + " Tipo " + Livro.class.getName()));
	}

	

	public Livro update(Integer id, Livro objDto) {
		Livro obj = findById(id);
		//obj.setCategoria(objDto.getCategoria());
		obj.setNome_autor(objDto.getNome_autor());
		obj.setTexto(objDto.getTexto());
		obj.setTitulo(objDto.getTitulo());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Livro obj = findById(id);

		try {
			repository.delete(obj);
		} catch (DataIntegrityViolationException e) {
			throw new com.nicolas.Booksore.Exception.DataIntegrityViolationException(
					"Livro não de ser deletado, possui Categorias Associados");
		}

	}



	public List<Livro> findAll(Integer id_cat) {
		CatService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}



	public Livro create(Integer id_cat,Livro obj) {
		obj.setId(null);
		Categoria cat =CatService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}



	public List<Livro> Listar() {
		
		return repository.findAll();
	}

}
