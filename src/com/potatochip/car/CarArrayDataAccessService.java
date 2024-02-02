package com.potatochip.car;

import com.potatochip.user.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class CarArrayDataAccessService implements CarDAO {
    private static final Car[] cars = new Car[4];
    private static final Car[] electricCars = new Car[1];

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
                boolean trueVal = Boolean.valueOf(fields[3]);
                boolean isElectric = trueVal;
                cars[i] = new Car(carRegNum, rentalPrice, carBrand, isElectric);
                System.out.println(cars[i].toString());
                if(cars[i].isElectric()){
                    electricCars[j] = cars[i];
                    j++;
                }
                i++;
            }

        } catch (IOException e) {
            System.out.println("An error occured: " + e);;
        }
    }
    @Override
    public Car[] selectAllCars() {
        return cars;
    }
    @Override
    public Car[] selectAllElectricCars(){
        return electricCars;
    }



}
