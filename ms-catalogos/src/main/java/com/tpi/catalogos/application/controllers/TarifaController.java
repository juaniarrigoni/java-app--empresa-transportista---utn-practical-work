package com.tpi.catalogos.application.controllers;

import com.tpi.catalogos.application.request.TarifaRequest;
import com.tpi.catalogos.application.response.TarifaResponse;
import com.tpi.catalogos.domain.model.Tarifa;
import com.tpi.catalogos.domain.model.CatalogoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        response.setNombre(tarifa.getNombre());
        response.setPrecioBase(tarifa.getPrecioBase());
        response.setPrecioKm(tarifa.getPrecioKm());
        response.setPrecioKg(tarifa.getPrecioKg());
        response.setPrecioM3(tarifa.getPrecioM3());
        response.setVigenciaDesde(tarifa.getVigenciaDesde());
        response.setVigenciaHasta(tarifa.getVigenciaHasta());
        response.setActiva(tarifa.isActiva());
        return response;
    }

    @PostMapping
    public ResponseEntity<TarifaResponse> createTarifa(@Valid @RequestBody TarifaRequest request) {
        Tarifa tarifa = Tarifa.crearNueva(
                request.getNombre(),
                request.getPrecioBase(),
                request.getPrecioKm(),
                request.getPrecioKg(),
                request.getPrecioM3(),
                request.getVigenciaDesde(),
                request.getVigenciaHasta()
        );
        
        Tarifa savedTarifa = catalogoService.crearTarifa(tarifa);
        return ResponseEntity.ok(mapToResponse(savedTarifa));
    }
}