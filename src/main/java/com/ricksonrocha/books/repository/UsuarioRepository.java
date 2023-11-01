package com.ricksonrocha.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricksonrocha.books.model.usuario.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long>{
    
}
