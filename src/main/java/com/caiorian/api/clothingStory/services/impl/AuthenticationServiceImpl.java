package com.caiorian.api.clothingStory.services.impl;

import com.caiorian.api.clothingStory.config.security.TokenProvider;
import com.caiorian.api.clothingStory.models.dtos.LoginRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.TokenResponseDTO;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Value("${jwt.expiration}")
    private long expirationTime;

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

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

    @Override
    public TokenResponseDTO login(LoginRequestDTO dto) {
        try{
            Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.senha()));

            String token = this.tokenProvider.gerarToken(authentication);

            return new TokenResponseDTO(token, expirationTime);

        }catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credenciais inválidas.");
        }
    }

    @Override
    public UsuarioResponseDTO findLogedUser(){
        UsuarioEntity usuario = this.getUsuarioLogadoEntity();
        return UsuarioMapper.toDtoFromEntity(usuario);
    }

    private UsuarioEntity getUsuarioLogadoEntity() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            return usuarioRepository.findByEmail(userDetails.getUsername())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario logado não encontrado na base de dados!"));
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario logado não encontrado na base de dados!");
    }
}
