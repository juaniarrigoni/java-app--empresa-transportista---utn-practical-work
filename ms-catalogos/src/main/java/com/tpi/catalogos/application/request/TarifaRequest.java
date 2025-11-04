package com.tpi.catalogos.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TarifaRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El precio base es obligatorio")
    @Positive(message = "El precio base debe ser mayor a 0")
    private BigDecimal precioBase;

    @NotNull(message = "El precio por kilómetro es obligatorio")
    @Positive(message = "El precio por kilómetro debe ser mayor a 0")
    private BigDecimal precioKm;

    @NotNull(message = "El precio por kilogramo es obligatorio")
    @Positive(message = "El precio por kilogramo debe ser mayor a 0")
    private BigDecimal precioKg;

    @NotNull(message = "El precio por metro cúbico es obligatorio")
    @Positive(message = "El precio por metro cúbico debe ser mayor a 0")
    private BigDecimal precioM3;

    @NotNull(message = "La fecha de vigencia inicial es obligatoria")
    @FutureOrPresent(message = "La fecha de vigencia inicial debe ser hoy o posterior")
    private LocalDate vigenciaDesde;

    @FutureOrPresent(message = "La fecha de vigencia final debe ser hoy o posterior")
    private LocalDate vigenciaHasta;
}