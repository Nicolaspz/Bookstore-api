package com.nicolas.Booksore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicolas.Booksore.Service.LivroService;

import com.nicolas.Booksore.domain.Livro;

import com.nicolas.Booksore.dtos.LivroDTO;
;

@RestController
@RequestMapping(value = "livros")
public class LivroResource {
	@Autowired
	LivroService Service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro obj= Service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "Categoria", defaultValue = "0") Integer id_cat){
		List<Livro> list = Service.findAll(id_cat);
		List<LivroDTO> listDTO= list.stream().map(obj-> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat, @RequestBody Livro obj){
		Livro newObj =  Service.create(id_cat,obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("lovros/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();  
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id,@RequestBody Livro objDto){
		Livro newObj = Service.update(id, objDto);
		return ResponseEntity.ok().body(newObj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		Service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
