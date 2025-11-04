package com.tpi.catalogos.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "camiones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaCamionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String patente;
    
    @Column(nullable = false)
    private String modelo;
    
    @Column(name = "capacidad_carga", nullable = false)
    private Double capacidadCarga;
    
    @Column(nullable = false)
    private String estado;
}