package com.tpi.catalogos.application.request;

import lombok.Data;

@Data
public class DepositoRequest {
    private String nombre;
    private String direccion;
    private Double capacidadMaxima;
    private String estado;
}