package com.caiorian.api.clothingStory.repositories;

import com.caiorian.api.clothingStory.models.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
}
