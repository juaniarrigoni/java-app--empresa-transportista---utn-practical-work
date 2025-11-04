package com.tpi.catalogos.application.response;

import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class DepositoResponse {
    private UUID id;
    private String nombre;
    private String direccion;
    private BigDecimal lat;
    private BigDecimal lng;
    private boolean activo;
}