package com.tpi.catalogos.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tarifas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaTarifaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(name = "precio_base", nullable = false)
    private BigDecimal precioBase;
    
    @Column(name = "precio_km", nullable = false)
    private BigDecimal precioKm;
    
    @Column(name = "precio_kg", nullable = false)
    private BigDecimal precioKg;
    
    @Column(name = "precio_m3", nullable = false)
    private BigDecimal precioM3;
    
    @Column(name = "vigencia_desde", nullable = false)
    private LocalDate vigenciaDesde;
    
    @Column(name = "vigencia_hasta")
    private LocalDate vigenciaHasta;
    
    @Column(nullable = false)
    private boolean activa = true;
}