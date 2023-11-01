package com.ricksonrocha.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricksonrocha.books.model.emprestimo.Emprestimo;
import com.ricksonrocha.books.model.usuario.Usuario;
import com.ricksonrocha.books.repository.EmprestimoRepository;


@Service
public class EmprestimoService {
    private static final int NUM_MAX_EMPRESTIMOS_PERMITIDOS = 3; 

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    
    public Emprestimo getEmprestimoById(Long emprestimoId) {
        return emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
    }

    public Emprestimo createdEmprestimo(Emprestimo emprestimo) {
        Usuario usuario = emprestimo.getUsuario();

        if (isUsuarioAtEmprestimoLimit(usuario)) {
            throw new RuntimeException("O usuário atingiu o limite de empréstimos permitidos.");
        }
       
        return emprestimoRepository.save(emprestimo);
    }

    private boolean isUsuarioAtEmprestimoLimit(Usuario usuario) {
        
        List<Emprestimo> emprestimosUsuario = emprestimoRepository.findByUsuario(usuario);
        if (emprestimosUsuario.size() >= NUM_MAX_EMPRESTIMOS_PERMITIDOS){
            return true;
        }
        return false;
        
       
    }
}
