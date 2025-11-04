package com.tpi.catalogos.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CatalogoService {
    // Camion operations
    List<Camion> getAllCamiones();
    List<Camion> getCamionesActivos();
    Optional<Camion> getCamionById(UUID id);
    Camion crearCamion(Camion camion);
    Camion actualizarCamion(UUID id, Camion camion);
    void desactivarCamion(UUID id);

    // Deposito operations
    List<Deposito> getAllDepositos();
    List<Deposito> getDepositosActivos();
    Optional<Deposito> getDepositoById(UUID id);
    Deposito crearDeposito(Deposito deposito);
    Deposito actualizarDeposito(UUID id, Deposito deposito);
    void desactivarDeposito(UUID id);

    // Tarifa operations
    List<Tarifa> getAllTarifas();
    List<Tarifa> getTarifasActivas();
    List<Tarifa> getTarifasVigentes(LocalDate fecha);
    Optional<Tarifa> getTarifaById(UUID id);
    Tarifa crearTarifa(Tarifa tarifa);
    Tarifa actualizarTarifa(UUID id, Tarifa tarifa);
    void desactivarTarifa(UUID id);
}