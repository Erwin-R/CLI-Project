package com.potatochip.car;

public class CarService {
    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void registerNewCar(Car car){
        Car[] cars = CarDAO.selectAllCars();
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
        return CarDAO.selectAllCars();
    }

    public void registerElectricCar(Car car){
        if(car.isElectric()){
            System.out.println();
        }
    }

}
