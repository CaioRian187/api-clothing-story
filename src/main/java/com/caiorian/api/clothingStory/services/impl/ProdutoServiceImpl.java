package com.caiorian.api.clothingStory.services.impl;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import com.caiorian.api.clothingStory.models.entities.Produto;
import com.caiorian.api.clothingStory.models.mapper.ProdutoMapper;
import com.caiorian.api.clothingStory.repositories.ProdutoRepository;
import com.caiorian.api.clothingStory.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

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

    @Override
    public Page<ProdutoResponseDTO> findAllProdutos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.produtoRepository.findAllProdutos(pageable);
    }

    @Override
    public ProdutoResponseDTO findProdutoById(UUID id) {
        return this.produtoRepository.findProdutoById(id)
                .orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Produto não encontrado na base de dados."
                ));
    }
}
