package com.dictionary.transport.transportdictionary.utils;

import com.dictionary.transport.transportdictionary.dto.VehicleDto;
import com.dictionary.transport.transportdictionary.model.VehicleEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public VehicleDto mapToVehicleDto(VehicleEntity entity){
        VehicleDto dto = new VehicleDto();
        dto.setId(entity.getId());
        dto.setModel(entity.getModel());
        dto.setBrand(entity.getBrand());
        dto.setCategory(entity.getCategory());
        dto.setGosNumber(entity.getGosNumber());
        dto.setProductionYear(entity.getProductionYear());
        dto.setVehicleType(entity.getVehicleType());
        return dto;
    }
    public VehicleEntity mapToVehicleEntity(VehicleDto dto){
        VehicleEntity entity = new VehicleEntity();
        entity.setId(dto.getId());
        entity.setModel(dto.getModel());
        entity.setBrand(dto.getBrand());
        entity.setCategory(dto.getCategory());
        entity.setGosNumber(dto.getGosNumber());
        entity.setProductionYear(dto.getProductionYear());
        entity.setVehicleType(dto.getVehicleType());
        return entity;
    }
}
