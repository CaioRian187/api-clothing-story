package com.caiorian.api.clothingStory.repositories;

import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import com.caiorian.api.clothingStory.models.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    @Query("""
        SELECT new com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO(
            p.id,
            p.nome,
            p.descricao,
            p.dataCriacao,
            p.preco,
            p.estoque,
            p.ativo
        )
        FROM Produto p
        ORDER BY p.nome ASC
    """)
    Page<ProdutoResponseDTO> findAllProdutos(Pageable pageable);

    @Query("""
        SELECT new com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO(
            p.id,
            p.nome,
            p.descricao,
            p.dataCriacao,
            p.preco,
            p.estoque,
            p.ativo
        )
        FROM Produto p
        WHERE p.id = :id
    """)
    Optional<ProdutoResponseDTO> findProdutoById(@Param("id") UUID id);

    @Query("""
        SELECT p FROM Produto p WHERE p.id = :id
    """)
    Optional<Produto> findEntityById(@Param("id") UUID id);
}
