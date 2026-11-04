package com.caiorian.api.clothingStory.models.mapper;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import com.caiorian.api.clothingStory.models.entities.Produto;

public abstract class ProdutoMapper {

    public static Produto toEntityFromDto(ProdutoRequestDTO dto){
        return new Produto(
                dto.nome(),
                dto.descricao(),
                dto.preco(),
                dto.estoque(),
                dto.ativo()
        );
    }

    public static ProdutoResponseDTO toDtoFromEntity(Produto produto){
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getDataCriacao(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getAtivo()
        );
    }
}
