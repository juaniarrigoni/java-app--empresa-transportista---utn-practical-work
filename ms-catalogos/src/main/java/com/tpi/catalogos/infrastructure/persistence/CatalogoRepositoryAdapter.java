package com.tpi.catalogos.infrastructure.persistence;

import com.tpi.catalogos.domain.model.Camion;
import com.tpi.catalogos.domain.model.Deposito;
import com.tpi.catalogos.domain.model.Tarifa;
import com.tpi.catalogos.domain.model.CatalogoService;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return Camion.builder()
                .id(entity.getId())
                .patente(entity.getPatente())
                .capacidadKg(entity.getCapacidadKg())
                .volumenM3(entity.getVolumenM3())
                .tipo(entity.getTipo())
                .activo(entity.isActivo())
                .build();
    }

    private JpaCamionEntity mapToEntity(Camion domain) {
        return new JpaCamionEntity(
                domain.getId(),
                domain.getPatente(),
                domain.getCapacidadKg(),
                domain.getVolumenM3(),
                domain.getTipo(),
                domain.isActivo()
        );
    }

    @Override
    public List<Camion> getAllCamiones() {
        return camionRepository.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Camion crearCamion(Camion camion) {
        JpaCamionEntity entity = mapToEntity(camion);
        return mapToDomain(camionRepository.save(entity));
    }

    // Deposito mappings and operations
    private Deposito mapToDomain(JpaDepositoEntity entity) {
        return Deposito.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .direccion(entity.getDireccion())
                .lat(entity.getLat())
                .lng(entity.getLng())
                .activo(entity.isActivo())
                .build();
    }

    @Override
    public List<Deposito> getAllDepositos() {
        return depositoRepository.findAll().stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    // Tarifa mappings and operations
    private Tarifa mapToDomain(JpaTarifaEntity entity) {
        return Tarifa.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .precioBase(entity.getPrecioBase())
                .precioKm(entity.getPrecioKm())
                .precioKg(entity.getPrecioKg())
                .precioM3(entity.getPrecioM3())
                .vigenciaDesde(entity.getVigenciaDesde())
                .vigenciaHasta(entity.getVigenciaHasta())
                .activa(entity.isActiva())
                .build();
    }

    private JpaTarifaEntity mapToEntity(Tarifa domain) {
        return new JpaTarifaEntity(
                domain.getId(),
                domain.getNombre(),
                domain.getPrecioBase(),
                domain.getPrecioKm(),
                domain.getPrecioKg(),
                domain.getPrecioM3(),
                domain.getVigenciaDesde(),
                domain.getVigenciaHasta(),
                domain.isActiva()
        );
    }

    @Override
    public Tarifa crearTarifa(Tarifa tarifa) {
        JpaTarifaEntity entity = mapToEntity(tarifa);
        return mapToDomain(tarifaRepository.save(entity));
    }
}