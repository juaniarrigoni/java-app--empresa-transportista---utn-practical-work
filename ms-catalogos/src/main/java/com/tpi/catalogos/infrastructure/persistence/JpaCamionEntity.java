package com.tpi.catalogos.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "camiones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaCamionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false, unique = true)
    private String patente;
    
    @Column(name = "capacidad_kg", nullable = false)
    private BigDecimal capacidadKg;
    
    @Column(name = "volumen_m3", nullable = false)
    private BigDecimal volumenM3;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private boolean activo = true;
}