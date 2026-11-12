package com.caiorian.api.clothingStory.models.dtos;

public record TokenResponseDTO(
        String token,
        long expiresAt
) {
}
