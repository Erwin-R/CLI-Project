package com.potatochip.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        if(cars.isEmpty()){
            return Collections.emptyList();
        }
        List<Car> electricCars = new ArrayList<>();

        for(Car car: cars){
            if(car.isElectric()){
                electricCars.add(car);
            }
        }
        return electricCars;
    }


    public Car getOneCar(int carRegNumber){
        for(Car car: getAllCars()){
            if(car.getRegNumber() == carRegNumber){
                return car;
            }
        }

        throw new IllegalStateException("Invalid Car Registration Number");
    }


}
