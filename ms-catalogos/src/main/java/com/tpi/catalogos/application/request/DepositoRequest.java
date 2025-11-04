package com.tpi.catalogos.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class DepositoRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @NotNull(message = "La latitud es obligatoria")
    @DecimalMin(value = "-90", message = "La latitud debe ser mayor o igual a -90")
    @DecimalMax(value = "90", message = "La latitud debe ser menor o igual a 90")
    private BigDecimal lat;

    @NotNull(message = "La longitud es obligatoria")
    @DecimalMin(value = "-180", message = "La longitud debe ser mayor o igual a -180")
    @DecimalMax(value = "180", message = "La longitud debe ser menor o igual a 180")
    private BigDecimal lng;
}