package com.nicolas.Booksore.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.Booksore.domain.Categoria;
import com.nicolas.Booksore.domain.Livro;
import com.nicolas.Booksore.repositories.CategoriRepository;
import com.nicolas.Booksore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	CategoriRepository cate;
	@Autowired
	LivroRepository livro;

	
	
	public void InstaciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Matemática", "Calculos de Integrais");
		Categoria cat4 = new Categoria(null, "Testando Eliminat", "Teste");
		Categoria cat5 = new Categoria(null, "Testando Eliminat", "Teste1");
		Livro l1 = new Livro(null, "Testes", "Nic", "Lorem Ipsun", cat1);

		Categoria cat2 = new Categoria(null, "Infoemática", "Poesia nua e Crua");
		Livro l2 = new Livro(null, "Tec", "Robert Martin", "Lorem Ipsun", cat2);
		Categoria cat3 = new Categoria(null, "TI", "Poesia nua e Crua");
		Livro l3 = new Livro(null, "Over Day", "Robert Martin", "Lorem Ipsun", cat3);
		Livro l0 = new Livro(null, "PP", "Nic", "Lorem Ipsun", cat2);
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l3));
		cat2.getLivros().addAll(Arrays.asList(l0));
		cat1.getLivros().addAll(Arrays.asList(l1));
		this.cate.saveAll(Arrays.asList(cat2, cat3,cat1,cat4,cat5));
		this.livro.saveAll(Arrays.asList(l0, l2, l3,l1));
	}

}
