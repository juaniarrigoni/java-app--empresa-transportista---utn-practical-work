package com.tpi.catalogos.application.request;

import lombok.Data;

@Data
public class CamionRequest {
    private String patente;
    private String modelo;
    private Double capacidadCarga;
    private String estado;
}