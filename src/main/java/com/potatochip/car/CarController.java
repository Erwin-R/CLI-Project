package com.potatochip.car;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("api/cars")
    public List<Car> getCars (){
        return carService.getAllCars();
    }

    @GetMapping("api/cars/electric")
    public List<Car> getElectricCars (){
        return carService.getAllElectricCars();
    }


}
