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
}