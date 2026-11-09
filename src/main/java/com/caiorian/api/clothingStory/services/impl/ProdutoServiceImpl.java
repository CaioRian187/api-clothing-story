package com.caiorian.api.clothingStory.services.impl;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import com.caiorian.api.clothingStory.models.entities.ProdutoEntity;
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

        ProdutoEntity produtoEntity = ProdutoMapper.toEntityFromDto(dto);

        this.produtoRepository.save(produtoEntity);

        return ProdutoMapper.toDtoFromEntity(produtoEntity);
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

    @Override
    public ProdutoEntity findEntityById(UUID id) {
        return this.produtoRepository.findEntityById(id)
                .orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Produto não encontrado na base de dados."
                ));
    }

    @Override
    public ProdutoResponseDTO update(UUID produtoId, ProdutoRequestDTO dto) {

        ProdutoEntity produtoEntity = this.findEntityById(produtoId);

        ProdutoEntity produtoEntityAtualizado = this.updateProdutoByDto(produtoEntity, dto);

        this.produtoRepository.save(produtoEntityAtualizado);

        return ProdutoMapper.toDtoFromEntity(produtoEntityAtualizado);
    }

    @Override
    public void deleteById(UUID produtoId) {
        this.findEntityById(produtoId);
        this.produtoRepository.deleteById(produtoId);
    }

    private ProdutoEntity updateProdutoByDto(ProdutoEntity produtoEntity, ProdutoRequestDTO dto){
        produtoEntity.setNome(dto.nome());
        produtoEntity.setDescricao(dto.descricao());
        produtoEntity.setPreco(dto.preco());
        produtoEntity.setEstoque(dto.estoque());
        produtoEntity.setAtivo(dto.ativo());

        return produtoEntity;
    }
}
