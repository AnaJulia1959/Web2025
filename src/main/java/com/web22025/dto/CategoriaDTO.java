package com.web22025.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(@NotBlank String nome) {

}
