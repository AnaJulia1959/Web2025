package com.web22025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web22025.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
