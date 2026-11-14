package com.caiorian.api.clothingStory.services;

import com.caiorian.api.clothingStory.models.dtos.UpdateUsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {

    UsuarioResponseDTO update(UUID usuarioId, UpdateUsuarioRequestDTO dto);
    void delete(UUID usuarioId);
    Page<UsuarioResponseDTO> findAllUsuarios(Pageable pageable);
}
