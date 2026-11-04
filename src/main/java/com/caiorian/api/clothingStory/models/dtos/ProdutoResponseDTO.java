package com.caiorian.api.clothingStory.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProdutoResponseDTO(
        UUID id,
        String nome,
        String descricao,
        LocalDateTime dataCriacao,
        BigDecimal preco,
        Integer estoque,
        Boolean ativo
) {

    public ProdutoResponseDTO(
            UUID id, String nome, String descricao, LocalDateTime dataCriacao,
            BigDecimal preco, Integer estoque, Boolean ativo
    ) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.preco = preco;
        this.estoque = estoque;
        this.ativo = ativo;
    }
}
