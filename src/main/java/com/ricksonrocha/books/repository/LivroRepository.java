package com.ricksonrocha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricksonrocha.books.model.livro.Livro;

public interface LivroRepository extends JpaRepository<Livro,Long> {
    
}
