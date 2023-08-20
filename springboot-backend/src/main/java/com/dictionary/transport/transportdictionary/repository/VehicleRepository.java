package com.dictionary.transport.transportdictionary.repository;

import com.dictionary.transport.transportdictionary.model.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findByGosNumberEquals(String gosNumber);
   List<VehicleEntity> findByBrandContainingIgnoreCase(String brand);
    List<VehicleEntity> findByModelContainingIgnoreCase(String brand);
    List<VehicleEntity> findByCategoryContainingIgnoreCase(String brand);
    List<VehicleEntity> findByGosNumberContainingIgnoreCase(String brand);
    List<VehicleEntity> findByProductionYearContainingIgnoreCase(String brand);
    List<VehicleEntity> findByVehicleTypeContainingIgnoreCase(String brand);
}
