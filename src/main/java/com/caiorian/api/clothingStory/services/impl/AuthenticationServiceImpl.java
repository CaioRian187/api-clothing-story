package com.caiorian.api.clothingStory.services.impl;

import com.caiorian.api.clothingStory.models.dtos.UsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import com.caiorian.api.clothingStory.models.entities.RoleEntity;
import com.caiorian.api.clothingStory.models.entities.UsuarioEntity;
import com.caiorian.api.clothingStory.models.enums.RoleTypeEnum;
import com.caiorian.api.clothingStory.models.mapper.UsuarioMapper;
import com.caiorian.api.clothingStory.repositories.RoleRepository;
import com.caiorian.api.clothingStory.repositories.UsuarioRepository;
import com.caiorian.api.clothingStory.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {

        if (this.usuarioRepository.existsByEmail(dto.email())){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Já existe usuário cadastrado com esse e-mail na base de dados."
            );
        }

        RoleEntity role = this.roleRepository.findByNome(RoleTypeEnum.ROLE_USER)
                .orElseGet( () -> this.roleRepository.save(new RoleEntity(RoleTypeEnum.ROLE_USER)));

        String senhaCrypto = this.passwordEncoder.encode(dto.senha());

        UsuarioEntity usuario = UsuarioMapper.toEntityFromDto(dto, senhaCrypto, role);

        this.usuarioRepository.save(usuario);

        return UsuarioMapper.toDtoFromEntity(usuario);
    }
}
