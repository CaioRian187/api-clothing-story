package com.caiorian.api.clothingStory.models.entities;

import com.caiorian.api.clothingStory.models.enums.RoleTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nome", nullable = false, unique = true)
    private RoleTypeEnum nome;

    public RoleEntity(RoleTypeEnum roleTypeEnum) {
        this.nome = roleTypeEnum;
    }

    @Override
    public @Nullable String getAuthority() {
        return nome.name();
    }
}
