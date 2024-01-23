package com.potatochip.user;


import com.potatochip.user.UserDAO;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public User[] getUsers(){
        return userDAO.getAllUsers();
    }

    public User getOneUser(String userId){

        User[] users = userDAO.getAllUsers();
        for(User user: users){
            if(user.getId().toString().equals(userId)){
                return user;
            }
        }

        throw new RuntimeException("Invalid user");
    }

}
