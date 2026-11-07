package com.caiorian.api.clothingStory.services;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProdutoService {
    ProdutoResponseDTO create(ProdutoRequestDTO dto);
    Page<ProdutoResponseDTO> findAllProdutos(int page, int size);
    ProdutoResponseDTO findProdutoById(UUID id);
}
