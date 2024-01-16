package com.potatochip.car;

public class CarDOA {
    private static final Car[] cars;

    static{
        cars = new Car[]{
                new Car(1234, 79.99, "Honda", false),
                new Car(2345, 129.99, "Tesla", true),
                new Car(5342, 59.99, "Toyota", false),
                new Car(3424, 159.99, "BMW", false),
        };
    }

    public static Car[] getCars() {
        return cars;
    }
}
