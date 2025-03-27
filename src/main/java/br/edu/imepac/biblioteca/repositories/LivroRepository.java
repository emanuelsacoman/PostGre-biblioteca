package br.edu.imepac.biblioteca.repositories;

import br.edu.imepac.biblioteca.domain.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Livro entities.
 * This interface extends JpaRepository to provide CRUD operations for Livro entities.
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}