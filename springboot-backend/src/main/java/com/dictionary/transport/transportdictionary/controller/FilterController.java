package com.dictionary.transport.transportdictionary.controller;

import com.dictionary.transport.transportdictionary.dto.VehicleDto;
import com.dictionary.transport.transportdictionary.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @GetMapping("/brand/{brand}")
    public List<VehicleDto> getVehiclesByBrandFilter(@PathVariable String brand) {
        return vehicleService.getVehiclesDtoByBrandFilter(brand);

    }
    @GetMapping("/model/{model}")
    public List<VehicleDto> getVehiclesByModelFilter(@PathVariable String model) {
        return vehicleService.getVehiclesDtoByModelFilter(model);

    }
    @GetMapping("/category/{category}")
    public List<VehicleDto> getVehiclesByCategoryFilter(@PathVariable String category) {
        return vehicleService.getVehiclesDtoByCategoryFilter(category);

    }
    @GetMapping("/gosNumber/{gosNumber}")
    public List<VehicleDto> getVehiclesByGosNumberFilter(@PathVariable String gosNumber) {
        return vehicleService.getVehiclesDtoByGosNumberFilter(gosNumber);

    }
    @GetMapping("/productionYear/{productionYear}")
    public List<VehicleDto> getVehiclesByProductionYearFilter(@PathVariable String productionYear) {
        return vehicleService.getVehiclesDtoByProductionYearFilter(productionYear);

    }
    @GetMapping("/vehicleType/{vehicleType}")
    public List<VehicleDto> getVehiclesByVehicleTypeFilter(@PathVariable String vehicleType) {
        return vehicleService.getVehiclesDtoByVehicleTypeFilter(vehicleType);

    }

}
