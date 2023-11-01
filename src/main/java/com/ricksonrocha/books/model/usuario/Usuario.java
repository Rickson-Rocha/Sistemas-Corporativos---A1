package com.ricksonrocha.books.model.usuario;

import java.time.LocalDate;
import java.util.List;

import com.ricksonrocha.books.model.emprestimo.Emprestimo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="usuario")
@Table(name="usario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @NotBlank
    private String nome;
     
    @NotBlank
    private LocalDate dataRegistro;
     
    @OneToMany (mappedBy = "usuario")
    private List<Emprestimo> emprestimos;
}
