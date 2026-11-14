package com.caiorian.api.clothingStory.controller.impl;

import com.caiorian.api.clothingStory.controller.UsuarioController;
import com.caiorian.api.clothingStory.models.dtos.UpdateUsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import com.caiorian.api.clothingStory.services.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Usuários")
@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @Override
    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> update(
            @PathVariable("usuarioId") UUID usuarioId,
            @RequestBody @Valid UpdateUsuarioRequestDTO dto
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(this.usuarioService.update(usuarioId, dto));
    }
}
