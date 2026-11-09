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

import java.util.Optional;
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

    @Override
    public Produto findEntityById(UUID id) {
        return this.produtoRepository.findEntityById(id)
                .orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Produto não encontrado na base de dados."
                ));
    }

    @Override
    public ProdutoResponseDTO update(UUID produtoId, ProdutoRequestDTO dto) {

        Produto produto = this.findEntityById(produtoId);

        Produto produtoAtualizado = this.updateProdutoByDto(produto, dto);

        this.produtoRepository.save(produtoAtualizado);

        return ProdutoMapper.toDtoFromEntity(produtoAtualizado);
    }

    @Override
    public void deleteById(UUID produtoId) {
        this.findEntityById(produtoId);
        this.produtoRepository.deleteById(produtoId);
    }

    private Produto updateProdutoByDto(Produto produto, ProdutoRequestDTO dto){
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setEstoque(dto.estoque());
        produto.setAtivo(dto.ativo());

        return produto;
    }
}
