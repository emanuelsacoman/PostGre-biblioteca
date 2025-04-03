package br.edu.imepac.biblioteca.controllers;

import br.edu.imepac.biblioteca.domain.dtos.AlunoRequestDto;
import br.edu.imepac.biblioteca.domain.dtos.AlunoDto;
import br.edu.imepac.biblioteca.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDto addAluno(@RequestBody AlunoRequestDto alunoRequestDto) throws Exception {
        return alunoService.saveAluno(alunoRequestDto);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public AlunoDto getAlunoById(@PathVariable Long id) throws Exception {
        return alunoService.getAlunoById(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public AlunoDto updateAluno(@PathVariable Long id, @RequestBody AlunoRequestDto alunoRequestDto) throws Exception {
        return alunoService.updateAluno(id, alunoRequestDto);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable Long id) throws Exception {
        alunoService.deleteAluno(id);
    }
}
