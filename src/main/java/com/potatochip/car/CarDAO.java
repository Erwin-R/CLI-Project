package com.potatochip.car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarDAO{
    private static final List<Car> cars = Arrays.asList(
            new Car("1234", 89.00, "TESLA", true),
            new Car("5678", 50.00, "AUDI", false),
            new Car("2468", 77.00, "MERCEDES", false)
    );

    public List<Car> selectAllCars() {
        return cars;
    }



}

