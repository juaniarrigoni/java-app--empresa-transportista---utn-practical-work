package com.tpi.catalogos.application.controllers;

import com.tpi.catalogos.application.request.TarifaRequest;
import com.tpi.catalogos.application.response.TarifaResponse;
import com.tpi.catalogos.domain.model.Tarifa;
import com.tpi.catalogos.domain.model.CatalogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {
    private final CatalogoService catalogoService;

    public TarifaController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    private TarifaResponse mapToResponse(Tarifa tarifa) {
        TarifaResponse response = new TarifaResponse();
        response.setId(tarifa.getId());
        response.setTipo(tarifa.getTipo());
        response.setPrecio(tarifa.getPrecio());
        response.setDescripcion(tarifa.getDescripcion());
        response.setEstado(tarifa.getEstado());
        return response;
    }

    private Tarifa mapToDomain(TarifaRequest request) {
        return new Tarifa(
                null,
                request.getTipo(),
                request.getPrecio(),
                request.getDescripcion(),
                request.getEstado()
        );
    }

    @GetMapping
    public ResponseEntity<List<TarifaResponse>> getAllTarifas() {
        List<TarifaResponse> responses = catalogoService.getAllTarifas().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarifaResponse> getTarifaById(@PathVariable Long id) {
        return catalogoService.getTarifaById(id)
                .map(this::mapToResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TarifaResponse> createTarifa(@RequestBody TarifaRequest request) {
        Tarifa tarifa = mapToDomain(request);
        Tarifa savedTarifa = catalogoService.saveTarifa(tarifa);
        return ResponseEntity.ok(mapToResponse(savedTarifa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarifaResponse> updateTarifa(@PathVariable Long id, @RequestBody TarifaRequest request) {
        return catalogoService.getTarifaById(id)
                .map(existing -> {
                    Tarifa tarifa = mapToDomain(request);
                    tarifa.setId(id);
                    return ResponseEntity.ok(mapToResponse(catalogoService.saveTarifa(tarifa)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarifa(@PathVariable Long id) {
        if (!catalogoService.getTarifaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        catalogoService.deleteTarifa(id);
        return ResponseEntity.ok().build();
    }
}