package br.edu.imepac.biblioteca.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for the response of creating a Livro.
 * This class is used to transfer data between processes.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {

    /**
     * The unique identifier of the Livro.
     */
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