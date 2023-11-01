package com.ricksonrocha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricksonrocha.books.model.autor.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long>{
    
}
