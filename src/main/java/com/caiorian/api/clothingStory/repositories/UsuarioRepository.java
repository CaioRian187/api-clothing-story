package com.caiorian.api.clothingStory.repositories;

import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import com.caiorian.api.clothingStory.models.entities.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    @Query("SELECT u FROM UsuarioEntity u WHERE u.email = :email")
    Optional<UsuarioEntity> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM UsuarioEntity u WHERE u.id = :id")
    Optional<UsuarioEntity> findEntityById(@Param("id") UUID id);

    @Query("""
        SELECT new com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO(
            u.id,
            u.nome,
            u.telefone,
            u.dataCriacao,
            u.email
        )
        FROM UsuarioEntity u
        WHERE u.isDeleted = false
        ORDER BY u.nome ASC
    """)
    Page<UsuarioResponseDTO> findAllUsuarios(Pageable pageable);
}
