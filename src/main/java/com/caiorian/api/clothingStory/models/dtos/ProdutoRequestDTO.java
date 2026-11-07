package com.caiorian.api.clothingStory.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequestDTO(

        @NotBlank(message = "O nome do produto não pode ser nulo ou vazio.")
        String nome,

        @NotBlank(message = "A descrição do produto não pode ser nulo ou vazio.")
        String descricao,

        @NotNull(message = "O preço do produto não pode ser nulo.")
        BigDecimal preco,

        @NotNull(message = "A quantidade de produtos em estoque não pode ser nula.")
        Integer estoque,

        @NotNull(message = "É preciso informar se o produto está ativo.")
        Boolean ativo

) {
}
