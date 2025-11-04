package com.tpi.catalogos.infrastructure.persistence;

import com.tpi.catalogos.domain.model.Camion;
import com.tpi.catalogos.domain.model.Deposito;
import com.tpi.catalogos.domain.model.Tarifa;
import com.tpi.catalogos.domain.model.CatalogoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogoRepositoryAdapter implements CatalogoService {
    private final CamionJpaRepository camionRepository;
    private final DepositoJpaRepository depositoRepository;
    private final TarifaJpaRepository tarifaRepository;

    public CatalogoRepositoryAdapter(
            CamionJpaRepository camionRepository,
            DepositoJpaRepository depositoRepository,
            TarifaJpaRepository tarifaRepository) {
        this.camionRepository = camionRepository;
        this.depositoRepository = depositoRepository;
        this.tarifaRepository = tarifaRepository;
    }

    // Camion mappings and operations
    private Camion mapToDomain(JpaCamionEntity entity) {
        return new Camion(
                entity.getId(),
                entity.getPatente(),
                entity.getModelo(),
                entity.getCapacidadCarga(),
                entity.getEstado()
        );
    }

    private JpaCamionEntity mapToEntity(Camion domain) {
        return new JpaCamionEntity(
                domain.getId(),
                domain.getPatente(),
                domain.getModelo(),
                domain.getCapacidadCarga(),
                domain.getEstado()
        );
    }

    @Override
    public List<Camion> getAllCamiones() {
        return camionRepository.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Camion> getCamionById(Long id) {
        return camionRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Camion saveCamion(Camion camion) {
        JpaCamionEntity entity = mapToEntity(camion);
        return mapToDomain(camionRepository.save(entity));
    }

    @Override
    public void deleteCamion(Long id) {
        camionRepository.deleteById(id);
    }

    // Deposito mappings and operations
    private Deposito mapToDomain(JpaDepositoEntity entity) {
        return new Deposito(
                entity.getId(),
                entity.getNombre(),
                entity.getDireccion(),
                entity.getCapacidadMaxima(),
                entity.getEstado()
        );
    }

    private JpaDepositoEntity mapToEntity(Deposito domain) {
        return new JpaDepositoEntity(
                domain.getId(),
                domain.getNombre(),
                domain.getDireccion(),
                domain.getCapacidadMaxima(),
                domain.getEstado()
        );
    }

    @Override
    public List<Deposito> getAllDepositos() {
        return depositoRepository.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Deposito> getDepositoById(Long id) {
        return depositoRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Deposito saveDeposito(Deposito deposito) {
        JpaDepositoEntity entity = mapToEntity(deposito);
        return mapToDomain(depositoRepository.save(entity));
    }

    @Override
    public void deleteDeposito(Long id) {
        depositoRepository.deleteById(id);
    }

    // Tarifa mappings and operations
    private Tarifa mapToDomain(JpaTarifaEntity entity) {
        return new Tarifa(
                entity.getId(),
                entity.getTipo(),
                entity.getPrecio(),
                entity.getDescripcion(),
                entity.getEstado()
        );
    }

    private JpaTarifaEntity mapToEntity(Tarifa domain) {
        return new JpaTarifaEntity(
                domain.getId(),
                domain.getTipo(),
                domain.getPrecio(),
                domain.getDescripcion(),
                domain.getEstado()
        );
    }

    @Override
    public List<Tarifa> getAllTarifas() {
        return tarifaRepository.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Tarifa> getTarifaById(Long id) {
        return tarifaRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Tarifa saveTarifa(Tarifa tarifa) {
        JpaTarifaEntity entity = mapToEntity(tarifa);
        return mapToDomain(tarifaRepository.save(entity));
    }

    @Override
    public void deleteTarifa(Long id) {
        tarifaRepository.deleteById(id);
    }
}