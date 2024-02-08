package com.potatochip.user;


import com.potatochip.car.Car;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsers(){
        return userDAO.getAllUsers();
    }

    public User getOneUser(UUID userId){
        for(User user: getUsers()){
            if(user.getId().equals(userId)){
                return user;
            }
        }

        return null;
    }


}
