package com.potatochip.user;


import com.potatochip.car.CarDAO;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User[] getUsers(){
        return UserDAO.getAllUsers();
    }
}
