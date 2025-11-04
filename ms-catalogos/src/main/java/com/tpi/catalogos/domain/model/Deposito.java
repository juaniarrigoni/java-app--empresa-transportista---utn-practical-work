package com.tpi.catalogos.domain.model;

import lombok.Builder;
import lombok.Value;
import java.math.BigDecimal;
import java.util.UUID;

@Value
@Builder
public class Deposito {
    UUID id;
    String nombre;
    String direccion;
    BigDecimal lat;
    BigDecimal lng;
    boolean activo;

    public static Deposito crearNuevo(String nombre, String direccion, BigDecimal lat, BigDecimal lng) {
        return Deposito.builder()
                .nombre(nombre)
                .direccion(direccion)
                .lat(lat)
                .lng(lng)
                .activo(true)
                .build();
    }
}