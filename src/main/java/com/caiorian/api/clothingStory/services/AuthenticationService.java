package com.caiorian.api.clothingStory.services;

import com.caiorian.api.clothingStory.models.dtos.UsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;

public interface AuthenticationService {

    UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto);
}
