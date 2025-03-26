package br.edu.imepac.biblioteca.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    private Long id;
    private String nome;
    private String matricula;
    private String email;
}
