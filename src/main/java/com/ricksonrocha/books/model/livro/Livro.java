package com.ricksonrocha.books.model.livro;

import java.time.LocalDate;

import com.ricksonrocha.books.model.autor.Autor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="livro")
@Table(name="livro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String titulo;

    @NotBlank
    private String Isbn;
    
    @NotBlank
    private LocalDate anoPubli;

    @NotBlank
    private Integer copiasDispo;

    private Autor autor;
}
