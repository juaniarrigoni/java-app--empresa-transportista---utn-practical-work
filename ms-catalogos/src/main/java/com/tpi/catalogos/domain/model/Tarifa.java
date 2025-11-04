package com.tpi.catalogos.domain.model;

import lombok.Builder;
import lombok.Value;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
@Builder
public class Tarifa {
    UUID id;
    String nombre;
    BigDecimal precioBase;
    BigDecimal precioKm;
    BigDecimal precioKg;
    BigDecimal precioM3;
    LocalDate vigenciaDesde;
    LocalDate vigenciaHasta;
    boolean activa;

    public static Tarifa crearNueva(
            String nombre,
            BigDecimal precioBase,
            BigDecimal precioKm,
            BigDecimal precioKg,
            BigDecimal precioM3,
            LocalDate vigenciaDesde,
            LocalDate vigenciaHasta) {
        return Tarifa.builder()
                .nombre(nombre)
                .precioBase(precioBase)
                .precioKm(precioKm)
                .precioKg(precioKg)
                .precioM3(precioM3)
                .vigenciaDesde(vigenciaDesde)
                .vigenciaHasta(vigenciaHasta)
                .activa(true)
                .build();
    }

    public boolean isVigente(LocalDate fecha) {
        return activa &&
               (fecha.isEqual(vigenciaDesde) || fecha.isAfter(vigenciaDesde)) &&
               (vigenciaHasta == null || fecha.isEqual(vigenciaHasta) || fecha.isBefore(vigenciaHasta));
    }
}