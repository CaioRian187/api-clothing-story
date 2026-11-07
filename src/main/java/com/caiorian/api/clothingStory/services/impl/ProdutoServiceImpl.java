package com.caiorian.api.clothingStory.services.impl;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import com.caiorian.api.clothingStory.models.entities.Produto;
import com.caiorian.api.clothingStory.models.mapper.ProdutoMapper;
import com.caiorian.api.clothingStory.repositories.ProdutoRepository;
import com.caiorian.api.clothingStory.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponseDTO create(ProdutoRequestDTO dto) {

        Produto produto = ProdutoMapper.toEntityFromDto(dto);

        this.produtoRepository.save(produto);

        return ProdutoMapper.toDtoFromEntity(produto);
    }
}
