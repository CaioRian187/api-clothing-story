package com.caiorian.api.clothingStory.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class TokenProvider {

    @Value("${jwt.expiration}")
    private long expirationTime;

    @Value("${jwt.key}")
    private String key;

    // gerar token
    public String gerarToken(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return buildToken(userDetails.getUsername());
    }

    private String buildToken(String username){
        Date dataNow = new Date();
        Date expiration = new Date(dataNow.getTime() + expirationTime);

        return Jwts.builder()
                .subject(username)
                .issuedAt(dataNow)
                .expiration(expiration)
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(key.getBytes());
    }

    // validar token
    public boolean isTokenValid(String token){
        try {
            getClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    // extrair informações do token
    public String getUsernameByToken(String token){
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey()) // Validar assinatura do token
                .build()
                .parseSignedClaims(token)    // Validar expiração do token
                .getPayload();
    }

}
