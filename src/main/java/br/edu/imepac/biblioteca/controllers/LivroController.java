package br.edu.imepac.biblioteca.controllers;

import br.edu.imepac.biblioteca.domain.dtos.LivroDto;
import br.edu.imepac.biblioteca.domain.dtos.LivroRequestDto;
import br.edu.imepac.biblioteca.services.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDto addLivro(@RequestBody LivroRequestDto livroUpdateDto) throws Exception {
        return livroService.saveLivro(livroUpdateDto);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public LivroDto getLivroById(@PathVariable Long id) throws Exception {
        return livroService.getLivroById(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public LivroDto updateLivro(@PathVariable Long id, @RequestBody LivroRequestDto livroUpdateDto) throws Exception {
        return livroService.updateLivro(id, livroUpdateDto);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivro(@PathVariable Long id) throws Exception {
        livroService.deleteLivro(id);
    }
}