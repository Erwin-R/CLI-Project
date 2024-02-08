package com.potatochip.user;

import com.potatochip.car.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFileDataAccessService implements UserDAO{

    @Override
    public List<User> getAllUsers() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/potatochip/user/users.csv"));
            List<User> users = new ArrayList<>();
            String line;
            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                users.add(new User(UUID.fromString(fields[0]), fields[1]));
            }
            return users;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


}
