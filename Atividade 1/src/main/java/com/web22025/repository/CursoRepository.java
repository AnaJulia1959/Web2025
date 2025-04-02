package com.web22025.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web22025.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNomeContaining(String nome); 
    List<Curso> findByCategoriaId(Long categoriaId); 
}
