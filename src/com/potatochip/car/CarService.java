package com.potatochip.car;

public class CarService {
    private final CarArrayDataAccessService carArrayDataAccessService;

    public CarService(CarArrayDataAccessService carArrayDataAccessService) {
        this.carArrayDataAccessService = carArrayDataAccessService;
    }

    public void registerNewCar(Car car){
        Car[] cars = carArrayDataAccessService.selectAllCars();
        if(car != null){
            for(int i = 0; i < cars.length; i++){
                if(car.getRegNumber() == cars[i].getRegNumber()){
                    System.out.println("Car reg number is already taken!");
                    break;
                }
                if(cars[i + 1] == null){
                    cars[i + 1] = car;
                }
            }

        }
    }

    public Car[] getCars(){
        return carArrayDataAccessService.selectAllCars();
    }
    public Car[] getElectricCars(){
        return carArrayDataAccessService.selectAllElectricCars();
    }


    public Car getOneCar(int carRegNumber){
        Car[] cars = carArrayDataAccessService.selectAllCars();
        for(Car car: cars){
            if(car.getRegNumber() == carRegNumber){
                return car;
            }
        }

        throw new RuntimeException("Invalid Car Registration Number");
    }

    public void removeCar(Car bookedCar){
        Car[] cars = carArrayDataAccessService.selectAllCars();
        Car[] electricCars = carArrayDataAccessService.selectAllElectricCars();
        for(int i = 0; i < cars.length; i++){
            if(cars[i].equals(bookedCar)){
                cars[i] = null;
            }
        }

        for(int i = 0; i < electricCars.length; i++){
            if(bookedCar.isElectric() && bookedCar.equals(electricCars[i])){
                electricCars[i] = null;
            }
        }
    }

}
