package com.caiorian.api.clothingStory.controller;

import com.caiorian.api.clothingStory.models.dtos.UsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {

    @Operation(
            summary = "Cadastrar Usuário.",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400"),
                    @ApiResponse(responseCode = "500")
            }
    )
    ResponseEntity<UsuarioResponseDTO> cadastrar(UsuarioRequestDTO dto);
}
