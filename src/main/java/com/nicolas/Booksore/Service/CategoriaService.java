package com.nicolas.Booksore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.Booksore.Exception.ObjectNotFoundException;
import com.nicolas.Booksore.domain.Categoria;
import com.nicolas.Booksore.dtos.CategoriaDTO;
import com.nicolas.Booksore.repositories.CategoriRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriRepository categoriRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj= categoriRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Object não encontrado ID " + id + " Tipo " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriRepository.findAll();
	}
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return categoriRepository.save(obj);
		
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return categoriRepository.save(obj);
		
		
	}

	public void delete(Integer id) {
		Categoria obj = findById(id);
		categoriRepository.delete(obj);
		
	}
}
