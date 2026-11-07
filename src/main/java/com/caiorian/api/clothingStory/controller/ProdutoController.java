package com.caiorian.api.clothingStory.controller;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface ProdutoController {

    @Operation(
            summary = "Criar um produto.",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "500")
            }
    )
    ResponseEntity<ProdutoResponseDTO> create(ProdutoRequestDTO dto);
}
