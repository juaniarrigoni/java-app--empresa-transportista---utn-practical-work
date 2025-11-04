package com.tpi.catalogos.application.controllers;

import com.tpi.catalogos.application.request.CamionRequest;
import com.tpi.catalogos.application.response.CamionResponse;
import com.tpi.catalogos.domain.model.Camion;
import com.tpi.catalogos.domain.model.CatalogoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/camiones")
public class CamionController {
    private final CatalogoService catalogoService;

    public CamionController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    private CamionResponse mapToResponse(Camion camion) {
        CamionResponse response = new CamionResponse();
        response.setId(camion.getId());
        response.setPatente(camion.getPatente());
        response.setCapacidadKg(camion.getCapacidadKg());
        response.setVolumenM3(camion.getVolumenM3());
        response.setTipo(camion.getTipo());
        response.setActivo(camion.isActivo());
        return response;
    }

    @GetMapping
    public ResponseEntity<List<CamionResponse>> getAllCamiones() {
        List<CamionResponse> responses = catalogoService.getAllCamiones().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<CamionResponse> createCamion(@Valid @RequestBody CamionRequest request) {
        Camion camion = Camion.crearNuevo(
                request.getPatente(),
                request.getCapacidadKg(),
                request.getVolumenM3(),
                request.getTipo()
        );
        
        Camion savedCamion = catalogoService.crearCamion(camion);
        return ResponseEntity.ok(mapToResponse(savedCamion));
    }
}
