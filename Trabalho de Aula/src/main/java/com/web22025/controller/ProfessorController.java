package com.web22025.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web22025.dto.ProfessorDTO;
import com.web22025.model.Professor;
import com.web22025.repository.ProfessorRepository;

import jakarta.validation.Valid;
@Controller
    @RequestMapping("/professor")
    public class ProfessorController {

        @Autowired
        ProfessorRepository repository;

        @GetMapping("/inserir")
        public String inserir() {
            return "professor/inserir";
        }

        @PostMapping("/inserir")
        public String inserido(
                @ModelAttribute @Valid ProfessorDTO dto,
                BindingResult result, RedirectAttributes msg
        ) {
            if (result.hasErrors()) {
                msg.addFlashAttribute("erro", "Erro ao inserir");
                return "redirect:/professor/inserir";
            }
            var professor = new Professor();
            BeanUtils.copyProperties(dto, professor);
            repository.save(professor);
            msg.addFlashAttribute("sucesso", "Professor cadastrado!");
            return "redirect:/professor/inserir";
        }

        @GetMapping("/listar")
        public ModelAndView listar() {
            ModelAndView mv = new ModelAndView("professor/listar");
            List<Professor> lista = repository.findAll();
            mv.addObject("professores", lista);
            return mv;
        }

        @GetMapping("/excluir/{id}")
        public String excluir(@PathVariable(value = "id") int id) {
            Optional<Professor> professor = repository.findById(id);
            if (professor.isEmpty()) {
                return "redirect:/professor/listar";
            }
            repository.deleteById(id);
            return "redirect:/professor/listar";
        }

        @GetMapping("/editar/{id}")
        public ModelAndView editar(@PathVariable(value = "id") int id) {
            ModelAndView mv = new ModelAndView("professor/editar");
            Optional<Professor> professor = repository.findById(id);
            mv.addObject("id", professor.get().getID());
            mv.addObject("nome", professor.get().getNome());
            mv.addObject("email", professor.get().getEmail());
            return mv;
        }

        @PostMapping("/editar/{id}")
        public String editado(
                @ModelAttribute @Valid ProfessorDTO dto,
                BindingResult result, RedirectAttributes msg,
                @PathVariable(value = "id") int id
        ) {

            if (result.hasErrors()) {
                msg.addFlashAttribute("erro", "Erro ao editar");
                return "redirect:/professor/inserir";
            }
            Optional<Professor> prof = repository.findById(id);

            var professor = prof.get();
            BeanUtils.copyProperties(dto, professor);
            repository.save(professor);
            msg.addFlashAttribute("sucesso", "Professor editado!");
            return "redirect:/professor/listar";
        }
    }



