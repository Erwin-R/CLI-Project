package com.potatochip.user;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserFakerDataAccessService implements UserDAO{

    @Override
    public List<User> getAllUsers() {
        Faker faker = new Faker();
        List<User> users = new ArrayList<>();
        for(int i = 0; i < 3; i++){
//            UUID id = UUID.randomUUID();
//            String name = faker.name().firstName();
//            users.add(new User(id, name));
            users.add(new User(UUID.randomUUID(), faker.name().name()));
        }
        return users;
    }
}
