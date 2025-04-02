package com.web22025.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web22025.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findByNomeContainingIgnoreCase(String nome);

    public List<Curso> findByCategoriaId(Long categoriaId);

    public List<Curso> findByNomeContaining(String nome);

    public List<Curso> findByNomeContaining(String nome);

    public Object findById(Long cursoId);
}
