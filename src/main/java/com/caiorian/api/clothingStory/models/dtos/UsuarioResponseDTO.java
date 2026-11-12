package com.caiorian.api.clothingStory.models.dtos;

import com.caiorian.api.clothingStory.models.enums.RoleTypeEnum;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record UsuarioResponseDTO(
        UUID id,
        String nome,
        String telefone,
        LocalDateTime dataCriacao,
        String email,
        Set<RoleTypeEnum> roles
) {
}
