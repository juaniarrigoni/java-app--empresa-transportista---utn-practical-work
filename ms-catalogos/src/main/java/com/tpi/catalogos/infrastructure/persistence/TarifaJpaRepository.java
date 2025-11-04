package com.tpi.catalogos.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaJpaRepository extends JpaRepository<JpaTarifaEntity, Long> {
}