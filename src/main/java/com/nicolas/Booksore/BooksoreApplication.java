package com.nicolas.Booksore;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nicolas.Booksore.domain.Categoria;
import com.nicolas.Booksore.domain.Livro;
import com.nicolas.Booksore.repositories.CategoriRepository;
import com.nicolas.Booksore.repositories.LivroRepository;

@SpringBootApplication
public class BooksoreApplication implements CommandLineRunner {
	@Autowired
	CategoriRepository cate;
	@Autowired
	LivroRepository livro;

	public static void main(String[] args) {
		SpringApplication.run(BooksoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	 Categoria cat1 = new Categoria(null,"Infoemática","Poesia nua e Crua");
	 Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsun", cat1);
	 cat1.getLivros().addAll(Arrays.asList(l1));
	 this.cate.saveAll(Arrays.asList(cat1));
	 this.livro.saveAll(Arrays.asList(l1));
		
	}

}
