package com.caiorian.api.clothingStory.services.impl;

import com.caiorian.api.clothingStory.models.dtos.UpdateUsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import com.caiorian.api.clothingStory.models.entities.UsuarioEntity;
import com.caiorian.api.clothingStory.models.mapper.UsuarioMapper;
import com.caiorian.api.clothingStory.repositories.UsuarioRepository;
import com.caiorian.api.clothingStory.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDTO update(UUID usuarioId, UpdateUsuarioRequestDTO dto) {

        UsuarioEntity usuario = this.usuarioRepository.findEntityById(usuarioId)
                .orElseThrow( () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado na base de dados!"
                ));

        UsuarioEntity usuarioAtualizado = this.updateUsuarioByDto(usuario, dto);

        this.usuarioRepository.save(usuarioAtualizado);

        return UsuarioMapper.toDtoFromEntity(usuarioAtualizado);
    }

    private UsuarioEntity updateUsuarioByDto(UsuarioEntity usuario, UpdateUsuarioRequestDTO dto){
        usuario.setNome(dto.nome());
        usuario.setTelefone(dto.telefone());
        usuario.setEmail(dto.email());

        return usuario;
    }
}
