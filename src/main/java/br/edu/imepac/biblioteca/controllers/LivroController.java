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


    @PostMapping
    public LivroDto addLivro(@RequestBody LivroRequestDto livroUpdateDto) throws Exception {
        return livroService.saveLivro(livroUpdateDto);
    }

    @GetMapping("/{id}")
    public LivroDto getLivroById(@PathVariable Long id) throws Exception {
        return livroService.getLivroById(id);
    }

    @PutMapping("/{id}")
    public LivroDto updateLivro(@PathVariable Long id, @RequestBody LivroRequestDto livroUpdateDto) throws Exception {
        return livroService.updateLivro(id, livroUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivro(@PathVariable Long id) throws Exception {
        livroService.deleteLivro(id);
    }
}