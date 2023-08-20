package com.dictionary.transport.transportdictionary.controller;

import com.dictionary.transport.transportdictionary.dto.VehicleDto;
import com.dictionary.transport.transportdictionary.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class VehicleController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @GetMapping("/vehicles")
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto dto) {
            return ResponseEntity.ok( vehicleService.createUniqueGosNumberVehicle(dto));
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable long id) {
        return ResponseEntity.ok(vehicleService.getVehicleDtoById(id));
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable long id, @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDto));
    }
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVehicle(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.deleteVehicle(id));
    }

}
