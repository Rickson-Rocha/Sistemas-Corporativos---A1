package com.ricksonrocha.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ricksonrocha.books.model.emprestimo.Emprestimo;
import com.ricksonrocha.books.repository.EmprestimoRepository;
import com.ricksonrocha.books.service.EmprestimoService;

public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private EmprestimoRepository repository;

    @GetMapping("/{Id}")
    public Emprestimo getEmprestimoById(@PathVariable Long emprestimoId) {
        return emprestimoService.getEmprestimoById(emprestimoId);
    }

    @PostMapping
    public Emprestimo createEmprestimo(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.createdEmprestimo(emprestimo);
    }
   
    
}
