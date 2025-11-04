package com.tpi.catalogos.application.response;

import lombok.Data;

@Data
public class DepositoResponse {
    private Long id;
    private String nombre;
    private String direccion;
    private Double capacidadMaxima;
    private String estado;
}