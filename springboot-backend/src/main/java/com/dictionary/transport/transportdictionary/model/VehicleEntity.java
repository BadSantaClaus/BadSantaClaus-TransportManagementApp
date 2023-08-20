package com.dictionary.transport.transportdictionary.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "vehicles")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "category")
    private String category;
    @Column(name = "gos_number")
    private String gosNumber;
    @Column(name = "production_year")
    private String productionYear;
    @Column(name = "vehicle_type")
    private String vehicleType;

    public VehicleEntity() {
    }

    public VehicleEntity(String brand, String model, String category, String gosNumber, String productionYear) {
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.gosNumber = gosNumber;
        this.productionYear = productionYear;
    }
}
