package com.caiorian.api.clothingStory.controller.impl;

import com.caiorian.api.clothingStory.controller.ProdutoController;
import com.caiorian.api.clothingStory.models.dtos.ProdutoRequestDTO;
import com.caiorian.api.clothingStory.models.dtos.ProdutoResponseDTO;
import com.caiorian.api.clothingStory.services.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Produtos")
@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoControllerImpl implements ProdutoController {

    private final ProdutoService produtoService;

    @Override
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> create(@RequestBody @Valid ProdutoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoService.create(dto));
    }

    @Override
    @GetMapping("/findAll")
    public ResponseEntity<Page<ProdutoResponseDTO>> findAllProdutos(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.findAllProdutos(page, size));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> findProdutoById(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.findProdutoById(id));
    }
}
