package com.caiorian.api.clothingStory.models.mapper;

import com.caiorian.api.clothingStory.models.dtos.UsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import com.caiorian.api.clothingStory.models.entities.RoleEntity;
import com.caiorian.api.clothingStory.models.entities.UsuarioEntity;
import com.caiorian.api.clothingStory.models.enums.RoleTypeEnum;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class UsuarioMapper {

    public static UsuarioEntity toEntityFromDto(UsuarioRequestDTO dto, String senhaCrypto, RoleEntity role){
        return new UsuarioEntity(
                dto.nome(),
                dto.telefone(),
                dto.email(),
                senhaCrypto,
                Set.of(role)
        );
    }

    public static UsuarioResponseDTO toDtoFromEntity(UsuarioEntity usuario){
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getDataCriacao(),
                usuario.getEmail(),
                usuario.getRoles().stream().map(RoleEntity::getNome).collect(Collectors.toSet())
        );
    }
}
