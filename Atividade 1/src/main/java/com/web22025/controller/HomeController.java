package com.web22025.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.web22025.model.Categoria;
import com.web22025.model.Curso;
import com.web22025.model.Professor;
import com.web22025.repository.CategoriaRepository;
import com.web22025.repository.CursoRepository;
import com.web22025.repository.ProfessorRepository;


@Controller
public class HomeController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "home"; // Página inicial
    }

    @GetMapping("/buscar")
    public String buscarCursos(@RequestParam("nome") String nome, Model model) {
        List<Curso> cursos = cursoRepository.findByNomeContaining(nome);
        model.addAttribute("cursos", cursos);
        return "home"; // Retorna para a página inicial com os cursos encontrados
    }

    @GetMapping("/cursos/{categoriaId}")
    public String cursosPorCategoria(@PathVariable Long categoriaId, Model model) {
        List<Curso> cursos = cursoRepository.findByCategoriaId(categoriaId);
        model.addAttribute("cursos", cursos);
        return "cursos"; // Página com cursos de uma categoria específica
    }

    @GetMapping("/curso/{cursoId}")
    public String detalhesCurso(@PathVariable Long cursoId, Model model) {
        Curso curso = cursoRepository.findById(cursoId).orElse(null);
        model.addAttribute("curso", curso);
        return "cursoDetalhes"; // Página de detalhes do curso
    }

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "categorias"; // Página de lista de categorias
    }


    @GetMapping("/professores")
    public String listarProfessores(Model model) {
        List<Professor> professores = professorRepository.findAll();
        model.addAttribute("professores", professores);
        return "professores"; // Página de lista de professores
    }
}
