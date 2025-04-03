package br.edu.imepac.biblioteca.repositories;

import br.edu.imepac.biblioteca.domain.entidades.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno, Long> {

}
