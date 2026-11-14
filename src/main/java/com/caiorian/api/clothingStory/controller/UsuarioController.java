package com.caiorian.api.clothingStory.controller;

import com.caiorian.api.clothingStory.models.dtos.UpdateUsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UsuarioController {

    @Operation(
            summary = "Atualizar Usuário",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400"),
                    @ApiResponse(responseCode = "404"),
                    @ApiResponse(responseCode = "500")
            }
    )
    ResponseEntity<UsuarioResponseDTO> update(UUID usuarioId, UpdateUsuarioRequestDTO dto);

}
