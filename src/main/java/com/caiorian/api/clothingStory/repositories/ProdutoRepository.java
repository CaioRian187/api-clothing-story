package com.caiorian.api.clothingStory.repositories;

import com.caiorian.api.clothingStory.models.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
