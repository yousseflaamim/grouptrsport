package com.example.grupptransportcars.controller;

import com.example.grupptransportcars.modell.Cars;
import com.example.grupptransportcars.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Cars> getCarById(@PathVariable Long carId) {
        Cars car = carService.getCarById(carId);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/getAllCars")
    public ResponseEntity<List<Cars>> getAllCars() {
        List<Cars> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/addCar")
    public ResponseEntity<List<Cars>> addCar(@RequestBody Cars cars) {
        carService.addCar(cars);
        List<Cars> addCars = carService.getAllCars();
        return ResponseEntity.status(HttpStatus.CREATED ).body(addCars);

    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Cars> deleteCarById(@PathVariable Long carId) {
        carService.deleteCarById(carId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAllCars")
    public ResponseEntity<Cars> deleteAllCars() {
        carService.deleteAllCars();
        return ResponseEntity.noContent().build();
    }
    

}
