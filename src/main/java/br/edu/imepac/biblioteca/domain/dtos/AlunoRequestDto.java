package br.edu.imepac.biblioteca.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequestDto {
    private String nome;
    private String matricula;
    private String email;
}
