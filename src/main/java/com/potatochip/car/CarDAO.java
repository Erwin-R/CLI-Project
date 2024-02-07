package com.potatochip.car;

import java.util.List;

public interface CarDAO {
    List<Car> selectAllCars();
    List<Car> selectAllElectricCars();
}

