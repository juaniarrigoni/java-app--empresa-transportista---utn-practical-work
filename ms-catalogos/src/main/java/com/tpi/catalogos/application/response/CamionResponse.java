package com.tpi.catalogos.application.response;

import lombok.Data;

@Data
public class CamionResponse {
    private Long id;
    private String patente;
    private String modelo;
    private Double capacidadCarga;
    private String estado;
}