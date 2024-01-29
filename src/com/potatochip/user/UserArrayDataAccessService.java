package com.potatochip.user;

import com.potatochip.car.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO{
    private static final User[] users = new User[4];
    private Car[] userCars;

    static{
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/potatochip/user/users.csv"));
            String line;
            int i = 0;
            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                users[i] = new User(UUID.fromString(fields[0]), fields[1]);
                i++;
            }

        } catch (IOException e) {
            System.out.println("An error occured: " + e);;
        }
    }
    @Override
    public User[] getAllUsers() {
        return users;
    }

    public Car[] getCars(){return User.getUserCars();}

}
