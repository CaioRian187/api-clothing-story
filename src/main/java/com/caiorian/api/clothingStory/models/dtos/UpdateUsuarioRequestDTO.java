package com.caiorian.api.clothingStory.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateUsuarioRequestDTO(

        @NotBlank(message = "O nome não pode ser nulo ou vazio.")
        String nome,

        @NotBlank(message = "O número de telefone não pode ser nulo ou vazio.")
        String telefone,

        @NotBlank(message = "O email não pode ser nulo ou vazio.")
        String email
) {
}
