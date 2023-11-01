package com.ricksonrocha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricksonrocha.books.model.emprestimo.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {
    
}
