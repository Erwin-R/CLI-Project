package com.potatochip.car;

import java.util.List;

public class CarService {
    private final CarArrayDataAccessService carArrayDataAccessService;

    public CarService(CarArrayDataAccessService carArrayDataAccessService) {
        this.carArrayDataAccessService = carArrayDataAccessService;
    }

    public void registerNewCar(Car car){
        List<Car> cars = carArrayDataAccessService.selectAllCars();
        if(car != null){
            for(int i = 0; i < cars.size(); i++){
                if(car.getRegNumber() == cars.get(i).getRegNumber()){
                    System.out.println("Car reg number is already taken!");
                    break;
                }
            }
            cars.add(car);
        }
    }

    public List<Car> getCars(){
        return carArrayDataAccessService.selectAllCars();
    }
    public List<Car> getElectricCars(){
        return carArrayDataAccessService.selectAllElectricCars();
    }


    public Car getOneCar(int carRegNumber){
        List<Car> cars = carArrayDataAccessService.selectAllCars();
        for(Car car: cars){
            if(car.getRegNumber() == carRegNumber){
                return car;
            }
        }

        throw new RuntimeException("Invalid Car Registration Number");
    }

    public void removeCar(Car bookedCar){
        List<Car> cars = carArrayDataAccessService.selectAllCars();
        List<Car> electricCars = carArrayDataAccessService.selectAllElectricCars();
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).equals(bookedCar)){
                cars.remove(cars.get(i));
            }
        }

        for(int i = 0; i < electricCars.size(); i++){
            if(bookedCar.isElectric() && bookedCar.equals(electricCars.get(i))){
                electricCars.remove(cars.get(i));
            }
        }
    }

}
