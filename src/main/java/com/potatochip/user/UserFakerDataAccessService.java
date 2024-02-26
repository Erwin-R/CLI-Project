package com.potatochip.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserFakerDataAccessService implements UserDAO{

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for(int i = 0; i < 3; i++){
//            UUID id = UUID.randomUUID();
//            String name = faker.name().firstName();
//            users.add(new User(id, name));
            users.add(new User(UUID.randomUUID(), "hello"));
        }
        return users;
    }
}
