package com.web22025.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web22025.model.Curso;
import com.web22025.repository.CursoRepository;

@Controller
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/pesquisar")
    public ModelAndView pesquisarCurso(@RequestParam("nome") String nome) {
        ModelAndView mv = new ModelAndView("index");

        // Corrigindo a chamada do repositório
        List<Curso> cursos = cursoRepository.findByNomeContainingIgnoreCase(nome);

        mv.addObject("cursos", cursos);
        return mv;
    }
}
