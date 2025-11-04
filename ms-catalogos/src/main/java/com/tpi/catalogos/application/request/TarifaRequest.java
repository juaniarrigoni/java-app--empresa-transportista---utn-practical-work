package com.tpi.catalogos.application.request;

import lombok.Data;

@Data
public class TarifaRequest {
    private String tipo;
    private Double precio;
    private String descripcion;
    private String estado;
}