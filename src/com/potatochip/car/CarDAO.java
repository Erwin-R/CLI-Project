package com.potatochip.car;

public class CarDAO {
    private static final Car[] cars;
    private static final Car[] electricCars;
    private static int nextAvailableSlot = 0;

    static{
        cars = new Car[]{
                new Car(1234, 79.99, "Honda", false),
                new Car(2345, 129.99, "Tesla", true),
                new Car(5342, 59.99, "Toyota", false),
                new Car(3424, 159.99, "BMW", false)
        };

        electricCars = new Car[]{
                new Car(2345, 129.99, "Tesla", true)
        };
    }

    public Car[] selectAllCars() {
        return cars;
    }

    public Car[] selectAllElectricCars(){
        return electricCars;
    }



}
