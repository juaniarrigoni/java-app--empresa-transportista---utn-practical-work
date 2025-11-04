package com.tpi.catalogos.application.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class TarifaResponse {
    private UUID id;
    private String nombre;
    private BigDecimal precioBase;
    private BigDecimal precioKm;
    private BigDecimal precioKg;
    private BigDecimal precioM3;
    private LocalDate vigenciaDesde;
    private LocalDate vigenciaHasta;
    private boolean activa;
}