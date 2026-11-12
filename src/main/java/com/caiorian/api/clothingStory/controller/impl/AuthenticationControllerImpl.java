package com.caiorian.api.clothingStory.controller.impl;

import com.caiorian.api.clothingStory.controller.AuthenticationController;
import com.caiorian.api.clothingStory.models.dtos.LoginRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.TokenResponseDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.UsuarioResponseDTO;
import com.caiorian.api.clothingStory.services.AuthenticationService;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Table(name = "Usuários")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    @Override
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@RequestBody @Valid UsuarioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.authenticationService.cadastrar(dto));
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(LoginRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.authenticationService.login(dto));
    }
}
