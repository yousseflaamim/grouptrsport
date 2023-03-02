package com.example.grupptransportcars.service;


import com.example.grupptransportcars.error.CarNotFoundException;
import com.example.grupptransportcars.modell.Cars;
import com.example.grupptransportcars.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Cars> getAllCars() {
        return carRepository.findAll();
    }



       public Cars getCarById(@PathVariable Long id) {
            Optional<Cars> car = carRepository.findById(id);
            if (car.isPresent()) {
                return car.get();
            } else {
                throw new CarNotFoundException("Car not found with ID " + id);
            }


    }

    public Cars addCar(Cars cars) {

        return carRepository.save(cars);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
