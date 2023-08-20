package com.dictionary.transport.transportdictionary.dto;
import lombok.Data;
import lombok.Setter;

@Data
public class VehicleDto {
    private long id;
    private String brand;
    private String model;
    private String category;
    private String gosNumber;
    private String productionYear;
    private String vehicleType;
}
