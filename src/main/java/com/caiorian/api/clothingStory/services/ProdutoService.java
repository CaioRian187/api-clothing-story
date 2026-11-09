package com.caiorian.api.clothingStory.services;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import com.caiorian.api.clothingStory.models.entities.ProdutoEntity;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ProdutoService {
    ProdutoResponseDTO create(ProdutoRequestDTO dto);
    Page<ProdutoResponseDTO> findAllProdutos(int page, int size);
    ProdutoResponseDTO findProdutoById(UUID id);
    ProdutoEntity findEntityById(UUID id);
    ProdutoResponseDTO update(UUID produtoId, ProdutoRequestDTO dto);
    void deleteById(UUID produtoId);
}
