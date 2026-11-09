package com.caiorian.api.clothingStory.repositories;

import com.caiorian.api.clothingStory.models.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
}
