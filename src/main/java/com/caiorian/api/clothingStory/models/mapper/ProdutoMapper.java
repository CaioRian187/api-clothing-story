package com.caiorian.api.clothingStory.models.mapper;

import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import com.caiorian.api.clothingStory.models.entities.ProdutoEntity;

public abstract class ProdutoMapper {

    public static ProdutoEntity toEntityFromDto(ProdutoRequestDTO dto){
        return new ProdutoEntity(
                dto.nome(),
                dto.descricao(),
                dto.preco(),
                dto.estoque(),
                dto.ativo()
        );
    }

    public static ProdutoResponseDTO toDtoFromEntity(ProdutoEntity produtoEntity){
        return new ProdutoResponseDTO(
                produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getDataCriacao(),
                produtoEntity.getPreco(),
                produtoEntity.getEstoque(),
                produtoEntity.getAtivo()
        );
    }
}
