package com.nicolas.Booksore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.Booksore.domain.Categoria;

@Repository
public interface CategoriRepository extends JpaRepository<Categoria, Integer> {

}
