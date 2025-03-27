package br.edu.imepac.biblioteca.services;

import br.edu.imepac.biblioteca.domain.dtos.LivroDto;
import br.edu.imepac.biblioteca.domain.dtos.LivroRequestDto;
import br.edu.imepac.biblioteca.domain.entidades.Livro;
import br.edu.imepac.biblioteca.repositories.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public LivroDto getLivroById(Long id) throws Exception {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado."));
        return new LivroDto(livro.getId(), livro.getTitulo(), livro.getIsbn());
    }

    public LivroDto updateLivro(Long id, LivroRequestDto livroUpdateDto) throws Exception {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado."));

        if (livroUpdateDto.getTitulo().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Titulo não pode ser vazio.");
        }

        if (livroUpdateDto.getIsbn().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ISBN não pode ser vazio.");
        }

        livro.setTitulo(livroUpdateDto.getTitulo());
        livro.setIsbn(livroUpdateDto.getIsbn());

        livroRepository.save(livro);

        return new LivroDto(livro.getId(), livro.getTitulo(), livro.getIsbn());
    }

    public void deleteLivro(Long id) throws Exception {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado."));
        livroRepository.delete(livro);
    }
}