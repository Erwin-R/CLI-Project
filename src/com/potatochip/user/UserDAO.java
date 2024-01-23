package com.potatochip.user;

import java.util.UUID;

public class UserDAO {
    private static final User[] users;

    static{
        users = new User[]{
                new User(UUID.fromString("6cb4e600-f818-46e7-aece-d63f9b295b7a"), "Erwin"),
                new User(UUID.fromString("6fdaa2a2-ff02-4653-be93-0159d47fe83d"), "Gabriel")
        };
    }

    public User[] getAllUsers() {
        return users;
    }
}
