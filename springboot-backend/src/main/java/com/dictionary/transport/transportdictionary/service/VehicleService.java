package com.dictionary.transport.transportdictionary.service;

import com.dictionary.transport.transportdictionary.dto.VehicleDto;
import java.util.List;
import java.util.Map;

public interface VehicleService {

    List<VehicleDto> getAllVehicles();
    VehicleDto getVehicleDtoById(long id);
    VehicleDto createUniqueGosNumberVehicle(VehicleDto dto);
    VehicleDto updateVehicle (long id, VehicleDto dto);
    Map<String,Boolean> deleteVehicle (long id);
    List<VehicleDto> getVehiclesDtoByBrandFilter(String brand);
    List<VehicleDto> getVehiclesDtoByModelFilter(String model);
    List<VehicleDto> getVehiclesDtoByCategoryFilter(String category);
    List<VehicleDto> getVehiclesDtoByGosNumberFilter(String gosNumber);
    List<VehicleDto> getVehiclesDtoByProductionYearFilter(String productionYear);
    List<VehicleDto> getVehiclesDtoByVehicleTypeFilter(String vehicleType);
}
