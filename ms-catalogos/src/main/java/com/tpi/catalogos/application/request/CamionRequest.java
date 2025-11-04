package com.tpi.catalogos.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class CamionRequest {
    @NotBlank(message = "La patente es obligatoria")
    private String patente;

    @NotNull(message = "La capacidad de carga es obligatoria")
    @Positive(message = "La capacidad de carga debe ser mayor a 0")
    private BigDecimal capacidadKg;

    @NotNull(message = "El volumen es obligatorio")
    @Positive(message = "El volumen debe ser mayor a 0")
    private BigDecimal volumenM3;

    @NotBlank(message = "El tipo es obligatorio")
    @Pattern(regexp = "^(Sider|Chasis|Tractor)$", message = "El tipo debe ser Sider, Chasis o Tractor")
    private String tipo;
}