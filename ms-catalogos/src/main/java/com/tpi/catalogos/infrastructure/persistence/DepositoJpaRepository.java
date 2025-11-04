package com.tpi.catalogos.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositoJpaRepository extends JpaRepository<JpaDepositoEntity, Long> {
}