package com.caiorian.api.clothingStory.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(

        @NotBlank(message = "O email informado não pode ser nulo ou vazio.")
        @Email
        String email,

        @NotBlank(message = "A senha informada não pode ser nula ou vazia.")
        String senha
) {
}
