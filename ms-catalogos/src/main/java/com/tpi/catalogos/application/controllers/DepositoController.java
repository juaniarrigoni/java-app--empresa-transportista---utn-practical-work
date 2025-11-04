package com.tpi.catalogos.application.controllers;

import com.tpi.catalogos.application.request.DepositoRequest;
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
        response.setCapacidadMaxima(deposito.getCapacidadMaxima());
        response.setEstado(deposito.getEstado());
        return response;
    }

    private Deposito mapToDomain(DepositoRequest request) {
        return new Deposito(
                null,
                request.getNombre(),
                request.getDireccion(),
                request.getCapacidadMaxima(),
                request.getEstado()
        );
    }

    @GetMapping
    public ResponseEntity<List<DepositoResponse>> getAllDepositos() {
        List<DepositoResponse> responses = catalogoService.getAllDepositos().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepositoResponse> getDepositoById(@PathVariable Long id) {
        return catalogoService.getDepositoById(id)
                .map(this::mapToResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DepositoResponse> createDeposito(@RequestBody DepositoRequest request) {
        Deposito deposito = mapToDomain(request);
        Deposito savedDeposito = catalogoService.saveDeposito(deposito);
        return ResponseEntity.ok(mapToResponse(savedDeposito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepositoResponse> updateDeposito(@PathVariable Long id, @RequestBody DepositoRequest request) {
        return catalogoService.getDepositoById(id)
                .map(existing -> {
                    Deposito deposito = mapToDomain(request);
                    deposito.setId(id);
                    return ResponseEntity.ok(mapToResponse(catalogoService.saveDeposito(deposito)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeposito(@PathVariable Long id) {
        if (!catalogoService.getDepositoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        catalogoService.deleteDeposito(id);
        return ResponseEntity.ok().build();
    }
}