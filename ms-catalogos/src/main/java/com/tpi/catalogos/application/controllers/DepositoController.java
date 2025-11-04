package com.tpi.catalogos.application.controllers;

import com.tpi.catalogos.application.response.DepositoResponse;
import com.tpi.catalogos.domain.model.Deposito;
import com.tpi.catalogos.domain.model.CatalogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/depositos")
public class DepositoController {
    private final CatalogoService catalogoService;

    public DepositoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    private DepositoResponse mapToResponse(Deposito deposito) {
        DepositoResponse response = new DepositoResponse();
        response.setId(deposito.getId());
        response.setNombre(deposito.getNombre());
        response.setDireccion(deposito.getDireccion());
        response.setLat(deposito.getLat());
        response.setLng(deposito.getLng());
        response.setActivo(deposito.isActivo());
        return response;
    }

    @GetMapping
    public ResponseEntity<List<DepositoResponse>> getAllDepositos() {
        List<DepositoResponse> responses = catalogoService.getAllDepositos().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}