package com.potatochip.user;


import com.potatochip.car.Car;

public class UserService {
    private final UserArrayDataAccessService userArrayDataAccessService;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public User[] getUsers(){
        return userArrayDataAccessService.getAllUsers();
    }

    public User getOneUser(String userId){

        User[] users = userArrayDataAccessService.getAllUsers();
        for(User user: users){
            if(user.getId().toString().equals(userId)){
                return user;
            }
        }

        throw new RuntimeException("Invalid user");
    }

    public Car[] getUserCars(String userId){
        for(User user: userArrayDataAccessService.getAllUsers()){
            if(user.getId().toString().equals(userId)){
                return userArrayDataAccessService.getCars();
            }
        }
        throw new RuntimeException("invalid user");
    }


}
