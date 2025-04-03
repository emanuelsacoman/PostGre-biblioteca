package br.edu.imepac.biblioteca.services;

import br.edu.imepac.biblioteca.domain.dtos.AlunoDto;
import br.edu.imepac.biblioteca.domain.dtos.AlunoRequestDto;
import br.edu.imepac.biblioteca.repositories.AlunoRepository;
import br.edu.imepac.biblioteca.domain.entidades.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public  AlunoDto getAlunoById(Long id) throws Exception{
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
        return new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getMatricula(), aluno.getEmail());
    }

    public AlunoDto updateAluno(Long id, AlunoRequestDto alunoUpdateDto) throws Exception {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));

        if (alunoUpdateDto.getNome().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser vazio.");
        }

        if (alunoUpdateDto.getMatricula().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Matricula não pode ser vazio.");
        }

        if (alunoUpdateDto.getEmail().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não pode ser vazio.");
        }

        aluno.setNome(alunoUpdateDto.getNome());
        aluno.setMatricula(alunoUpdateDto.getMatricula());
        aluno.setEmail(alunoUpdateDto.getEmail());

        alunoRepository.save(aluno);

        return new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getMatricula(), aluno.getEmail());
    }

    public AlunoDto saveAluno(AlunoRequestDto alunoRequestDto) {
        if (alunoRequestDto.getNome().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser vazio.");
        }

        if (alunoRequestDto.getMatricula().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Matricula não pode ser vazio.");
        }

        if (alunoRequestDto.getEmail().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não pode ser vazio.");
        }

        Aluno aluno = new Aluno();
        aluno.setNome(alunoRequestDto.getNome());
        aluno.setMatricula(alunoRequestDto.getMatricula());
        aluno.setEmail(alunoRequestDto.getEmail());

        alunoRepository.save(aluno);

        return new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getMatricula(), aluno.getEmail());
    }

    public void deleteAluno(Long id) throws Exception {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado."));
        alunoRepository.delete(aluno);
    }


}
