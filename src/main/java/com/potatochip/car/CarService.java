package com.potatochip.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getAllCars(){
        return carDAO.selectAllCars();
    }
    public List<Car> getAllElectricCars(){
        List<Car> cars = getAllCars();

        // Imperative Solution
//        if(cars.isEmpty()){
//            return Collections.emptyList();
//        }
//        List<Car> electricCars = new ArrayList<>();
//
//        for(Car car: cars){
//            if(car.isElectric()){
//                electricCars.add(car);
//            }
//        }
//        return electricCars;


        //Declarative Solution
        return cars.stream().filter(Car::isElectric).collect(Collectors.toList());

    }


    public Car getOneCar(String carRegNumber){
        for(Car car: getAllCars()){
            if(car.getRegNumber().equals(carRegNumber)){
                return car;
            }
        }

        throw new IllegalStateException("Invalid Car Registration Number");
    }


}
