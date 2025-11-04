package com.tpi.catalogos.domain.model;

import lombok.Builder;
import lombok.Value;
import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class Camion {
    UUID id;
    String patente;
    BigDecimal capacidadKg;
    BigDecimal volumenM3;
    String tipo;  // "Sider", "Chasis", "Tractor"
    boolean activo;

    public boolean isTipoValido() {
        return tipo != null && 
               (tipo.equals("Sider") || 
                tipo.equals("Chasis") || 
                tipo.equals("Tractor"));
    }
}