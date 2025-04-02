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

import com.web22025.dto.CategoriaDTO;
import com.web22025.model.Categoria;
import com.web22025.repository.CategoriaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository repository;

    @GetMapping("/inserir")
    public String inserir() {
        return "categoria/inserir";
    }

    @PostMapping("/inserir")
    public String inserido(
            @ModelAttribute @Valid CategoriaDTO dto,
            BindingResult result, RedirectAttributes msg
    ) {
        if (result.hasErrors()) {
            msg.addFlashAttribute("erro", "Erro ao inserir");
            return "redirect:/categoria/inserir";
        }
        var categoria = new Categoria();
        BeanUtils.copyProperties(dto, categoria);
        repository.save(categoria);
        msg.addFlashAttribute("sucesso", "Categoria cadastrada!");
        return "redirect:/categoria/inserir";
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("categoria/listar");
        List<Categoria> lista = repository.findAll();
        mv.addObject("categorias", lista);
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable(value = "id") int id) {
        Optional<Categoria> categoria = repository.findById(id);
        if (categoria.isEmpty()) {
            return "redirect:/categoria/listar";
        }
        repository.deleteById(id);
        return "redirect:/categoria/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable(value = "id") int id) {
        ModelAndView mv = new ModelAndView("categoria/editar");
        Optional<Categoria> categoria = repository.findById(id);
        mv.addObject("id", categoria.get().getID());
        mv.addObject("nome", categoria.get().getNome());
        return mv;
    }

    @PostMapping("/editar/{id}")
    public String editado(
            @ModelAttribute @Valid CategoriaDTO dto,
            BindingResult result, RedirectAttributes msg,
            @PathVariable(value = "id") int id
    ) {

        if (result.hasErrors()) {
            msg.addFlashAttribute("erro", "Erro ao editar");
            return "redirect:/categoria/inserir";
        }
        Optional<Categoria> cat = repository.findById(id);

        var categoria = cat.get();
        BeanUtils.copyProperties(dto, categoria);
        repository.save(categoria);
        msg.addFlashAttribute("sucesso", "Categoria editada!");
        return "redirect:/categoria/listar";
    }

    @GetMapping("/menu")
    public ModelAndView exibirMenu() {
        ModelAndView mv = new ModelAndView("index"); 
        List<Categoria> categorias = repository.findAll();
        mv.addObject("categorias", categorias);
        return mv;
    }


