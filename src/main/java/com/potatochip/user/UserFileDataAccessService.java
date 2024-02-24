package com.potatochip.user;

import com.potatochip.car.Car;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Repository("fileData")
public class UserFileDataAccessService implements UserDAO{

    @Override
    public List<User> getAllUsers() {
        File file = new File(getClass().getClassLoader().getResource("users.csv").getPath());
        try {
            Scanner scanner = new Scanner(file);
            List<User> users = new ArrayList<>();
            while(scanner.hasNext()){
                String[] fields = scanner.nextLine().split(",");
                users.add(new User(UUID.fromString(fields[0]), fields[1]));
            }
            return users;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


}
