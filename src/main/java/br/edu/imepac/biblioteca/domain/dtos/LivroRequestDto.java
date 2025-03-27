package br.edu.imepac.biblioteca.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for creating a Livro.
 * This class is used to transfer data between processes.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroRequestDto {

    /**
     * The title of the Livro.
     */
    private String titulo;

    /**
     * The ISBN of the Livro.
     */
    private String isbn;
}