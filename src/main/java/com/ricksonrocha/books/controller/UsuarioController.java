package com.ricksonrocha.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.ricksonrocha.books.model.autor.Autor;
import com.ricksonrocha.books.repository.AutorRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

public class UsuarioController {
    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid Autor autor,
      UriComponentsBuilder  uriBuilder) {
        Autor autorLocal = repository.save(autor);
        var uri = uriBuilder.path("/autor/{id}").buildAndExpand(autorLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detalhar(@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        return ResponseEntity.ok(autor);
    }

    @GetMapping
    public ResponseEntity<Page<Autor>>listar(@PageableDefault(size = 4, sort = { "nome" }) Pageable paginacao) {
        var autor = repository.findAll(paginacao);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        repository.delete(autor);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Autor> atualizar(@RequestBody @Valid Autor autor) {
        Autor autorLocal = repository.findById(autor.getId()).get();

        autorLocal.setNome(autor.getNome());

        return ResponseEntity.ok(autorLocal);
    }
}
