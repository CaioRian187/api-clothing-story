package com.caiorian.api.clothingStory.services;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;

public interface ProdutoService {
    ProdutoResponseDTO create(ProdutoRequestDTO dto);
}
