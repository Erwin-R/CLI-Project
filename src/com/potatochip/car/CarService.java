package com.potatochip.car;
import com.potatochip.car.CarDAO;

public class CarService {
    private  CarDAO carDAO;

    public CarService() {
        this.carDAO = new CarDAO();
    }

    public void registerNewCar(Car car){
        Car[] cars = carDAO.selectAllCars();
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
        return carDAO.selectAllCars();
    }

    public void registerElectricCar(Car car){
        if(car.isElectric()){
            ;
        }
    }

    public Car getOneCar(int carRegNumber){
        Car[] cars = carDAO.selectAllCars();
        for(Car car: cars){
            if(car.getRegNumber() == carRegNumber){
                return car;
            }
        }

        throw new RuntimeException("Invalid Car Registration Number");
    }

    public void removeCar(Car bookedCar){
        Car[] cars = carDAO.selectAllCars();
        for(int i = 0; i < cars.length; i++){
            if(cars[i].equals(bookedCar)){
                cars[i] = null;
            }
        }
    }

}
