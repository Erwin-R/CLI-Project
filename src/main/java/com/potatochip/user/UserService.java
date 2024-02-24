package com.potatochip.user;


import com.potatochip.car.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserDAO userDAO;

    public UserService(@Qualifier("fileData") UserDAO userDAO) {
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
