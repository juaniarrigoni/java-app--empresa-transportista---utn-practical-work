package com.tpi.catalogos.domain.model;

import java.util.List;

public interface CatalogoService {
    // Camion operations
    List<Camion> getAllCamiones();
    Camion crearCamion(Camion camion);

    // Deposito operations
    List<Deposito> getAllDepositos();

    // Tarifa operations
    Tarifa crearTarifa(Tarifa tarifa);
}