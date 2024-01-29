package com.potatochip.car;

public interface CarDAO {
    Car[] selectAllCars();
    Car[] selectAllElectricCars();
}
