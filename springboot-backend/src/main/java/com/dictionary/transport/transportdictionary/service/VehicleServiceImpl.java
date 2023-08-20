package com.dictionary.transport.transportdictionary.service;

import com.dictionary.transport.transportdictionary.dto.VehicleDto;
import com.dictionary.transport.transportdictionary.exception.ResourceNotFoundException;
import com.dictionary.transport.transportdictionary.model.VehicleEntity;
import com.dictionary.transport.transportdictionary.repository.VehicleRepository;
import com.dictionary.transport.transportdictionary.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private MappingUtils mappingUtils;

    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(mappingUtils::mapToVehicleDto)
                .collect(Collectors.toList());
    }

    public VehicleDto getVehicleDtoById(long id) {
        return mappingUtils.mapToVehicleDto(vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ТС не найдено - id: " + id)));
    }
    public VehicleDto createUniqueGosNumberVehicle(VehicleDto dto) {
        if(vehicleRepository.findByGosNumberEquals(dto.getGosNumber()).isEmpty()) {
            return mappingUtils.mapToVehicleDto(vehicleRepository.save(mappingUtils.mapToVehicleEntity(dto)));
        } else throw new ResourceNotFoundException("Vehicle not exist with id: ");
    }
    public VehicleDto updateVehicle (long id, VehicleDto dto) {
        VehicleDto vehicleDto = getVehicleDtoById(id);
        vehicleDto.setBrand(dto.getBrand());
        vehicleDto.setModel(dto.getModel());
        vehicleDto.setCategory(dto.getCategory());
        vehicleDto.setGosNumber(dto.getGosNumber());
        vehicleDto.setProductionYear(dto.getProductionYear());
        vehicleDto.setVehicleType(dto.getVehicleType());
       VehicleEntity updatedVehicleEntity = vehicleRepository.save(mappingUtils.mapToVehicleEntity(vehicleDto));
       return mappingUtils.mapToVehicleDto(updatedVehicleEntity);
    }

    public Map<String,Boolean> deleteVehicle (long id) {
        VehicleDto vehicleDto = getVehicleDtoById(id);
        vehicleRepository.delete(mappingUtils.mapToVehicleEntity(vehicleDto));
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

    public List<VehicleDto> getVehiclesDtoByBrandFilter(String brand) {
        return vehicleRepository.findByBrandContainingIgnoreCase(brand).stream()
                .map(mappingUtils::mapToVehicleDto)
                .collect(Collectors.toList());

    }

    public List<VehicleDto> getVehiclesDtoByModelFilter(String model) {
        return vehicleRepository.findByModelContainingIgnoreCase(model).stream()
                .map(mappingUtils::mapToVehicleDto)
                .collect(Collectors.toList());

    }

    public List<VehicleDto> getVehiclesDtoByCategoryFilter(String category) {
        return vehicleRepository.findByCategoryContainingIgnoreCase(category).stream()
                .map(mappingUtils::mapToVehicleDto)
                .collect(Collectors.toList());

    }

    public List<VehicleDto> getVehiclesDtoByGosNumberFilter(String gosNumber) {
        return vehicleRepository.findByGosNumberContainingIgnoreCase(gosNumber).stream()
                .map(mappingUtils::mapToVehicleDto)
                .collect(Collectors.toList());

    }

    public List<VehicleDto> getVehiclesDtoByProductionYearFilter(String productionYear) {
        return vehicleRepository.findByProductionYearContainingIgnoreCase(productionYear).stream()
                .map(mappingUtils::mapToVehicleDto)
                .collect(Collectors.toList());

    }

    public List<VehicleDto> getVehiclesDtoByVehicleTypeFilter(String vehicleType) {
        return vehicleRepository.findByVehicleTypeContainingIgnoreCase(vehicleType).stream()
                .map(mappingUtils::mapToVehicleDto)
                .collect(Collectors.toList());

    }


}
