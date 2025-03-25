package com.web22025.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

		if(result.hasErrors()){
			msg.addFlashAttribute("erroCadastrar", "Erro ao inserir");
			return "redirect:categoria/inserir";
		}
		var categoria = new Categoria();
		BeanUtils.copyProperties(dto, categoria);
		repository.save(categoria);
		msg.addFlashAttribute("sucessoCadastrar", "Categoria cadastrada");
		return "redirect:categoria/inserir";
    }
}
