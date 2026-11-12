package com.caiorian.api.clothingStory.services;

import com.caiorian.api.clothingStory.models.dtos.LoginRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.TokenResponseDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;

public interface AuthenticationService {

    UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto);
    TokenResponseDTO login(LoginRequestDTO dto);
    UsuarioResponseDTO findLogedUser();
}
