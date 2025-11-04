package com.tpi.catalogos.application.response;

import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CamionResponse {
    private UUID id;
    private String patente;
    private BigDecimal capacidadKg;
    private BigDecimal volumenM3;
    private String tipo;
    private boolean activo;
}