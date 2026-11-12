package com.caiorian.api.clothingStory.repositories;

import com.caiorian.api.clothingStory.models.entities.RoleEntity;
import com.caiorian.api.clothingStory.models.enums.RoleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {

    @Query("SELECT r FROM RoleEntity r WHERE r.nome = :nomeRole")
    Optional<RoleEntity> findByNome(RoleTypeEnum nomeRole);
}
