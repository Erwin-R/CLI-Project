package com.potatochip.car;

import com.potatochip.user.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CarArrayDataAccessService implements CarDAO {
    private static final List<Car> cars = new ArrayList<>();
    private static final List<Car> electricCars = new ArrayList<>();

    static{
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/potatochip/car/cars.csv"));
            String line;
            int i = 0;
            int j = 0;
            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                Arrays.setAll(fields, k -> fields[k].strip());
                int carRegNum = Integer.parseInt(fields[0]);
                double rentalPrice = Double.parseDouble(fields[1]);
                String carBrand = fields[2];
                boolean isElectric = Boolean.valueOf(fields[3]);
                cars.add(new Car(carRegNum, rentalPrice, carBrand, isElectric));
                for(Car car: cars){
                    System.out.println(car.toString());
                }
                if(cars.get(i).isElectric()){
                    electricCars.add(cars.get(i));
                }
                i++;
            }

        } catch (IOException e) {
            System.out.println("An error occured: " + e);;
        }
    }
    @Override
    public List<Car> selectAllCars() {
        return cars;
    }
    @Override
    public List<Car> selectAllElectricCars(){
        return electricCars;
    }



}
