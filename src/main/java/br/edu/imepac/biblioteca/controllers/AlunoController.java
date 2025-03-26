package br.edu.imepac.biblioteca.controllers;

import br.edu.imepac.biblioteca.domain.Aluno;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @GetMapping
    public String[] getAlunos() {
        return new String[]{"Andrezao", "MP", "MD"};
    }

    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Aluno addAluno(@RequestBody Aluno aluno) {
        return aluno;
    }
}
