package com.caiorian.api.clothingStory.controller;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ProdutoController {

    @Operation(
            summary = "Criar um produto.",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "500")
            }
    )
    ResponseEntity<ProdutoResponseDTO> create(ProdutoRequestDTO dto);

    @Operation(
            summary = "Buscar produtos com paginação.",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "500")
            }
    )
    ResponseEntity<Page<ProdutoResponseDTO>> findAllProdutos(int page, int size);

    @Operation(
            summary = "Buscar produto por Id.",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "500")
            }
    )
    ResponseEntity<ProdutoResponseDTO> findProdutoById(UUID id);

    @Operation(
            summary = "Atualizar Produto.",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "500")
            }
    )
    ResponseEntity<ProdutoResponseDTO> update(UUID produtoId, ProdutoRequestDTO dto);
}
