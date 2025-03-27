package br.edu.imepac.biblioteca.domain.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a Livro (Book).
 * This class is mapped to the "livros" table in the database.
 */
@Entity
@Table(name = "livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    /**
     * The unique identifier of the Livro.
     * This value is generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The title of the Livro.
     */
    private String titulo;

    /**
     * The ISBN of the Livro.
     */
    private String isbn;
}