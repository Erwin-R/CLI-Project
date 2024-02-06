package com.potatochip.user;


import com.potatochip.car.Car;

import java.util.List;

public class UserService {
    private final UserArrayDataAccessService userArrayDataAccessService;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public List<User> getUsers(){
        return userArrayDataAccessService.getAllUsers();
    }

    public User getOneUser(String userId){

        List<User> users = userArrayDataAccessService.getAllUsers();
        for(User user: users){
            if(user.getId().toString().equals(userId)){
                return user;
            }
        }

        throw new RuntimeException("Invalid user");
    }

    public List<Car> getUserCars(String userId){
        for(User user: userArrayDataAccessService.getAllUsers()){
            if(user.getId().toString().equals(userId)){
                return userArrayDataAccessService.getCars();
            }
        }
        throw new RuntimeException("invalid user");
    }


}
