package com.tpi.catalogos.application.response;

import lombok.Data;

@Data
public class TarifaResponse {
    private Long id;
    private String tipo;
    private Double precio;
    private String descripcion;
    private String estado;
}