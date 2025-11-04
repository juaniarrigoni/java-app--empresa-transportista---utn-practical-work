package com.tpi.catalogos.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "depositos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaDepositoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String direccion;
    
    @Column(nullable = false)
    private BigDecimal lat;
    
    @Column(nullable = false)
    private BigDecimal lng;
    
    @Column(nullable = false)
    private boolean activo = true;
}