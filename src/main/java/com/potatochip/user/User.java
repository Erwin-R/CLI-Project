package com.potatochip.user;

import com.potatochip.booking.Bookings;
import com.potatochip.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;

    private int capacity = 2;
    private int nextAvailableSlot = 0;
    private static List<Car> userCars = new ArrayList<>();
    public User() {
    }

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
//        this.userCars = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNextAvailableSlot() {
        return nextAvailableSlot;
    }

    public void setNextAvailableSlot(int nextAvailableSlot) {
        this.nextAvailableSlot = nextAvailableSlot;
    }

    public static List<Car> getUserCars() {
        return userCars;
    }

    public void setUserCars(List<Car> userCars) {
        User.userCars = userCars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public void saveCar(Car car){
        if(userCars.size() <= capacity){
            userCars.add(car);
        } else{
            System.out.println("User cannot book more cars.");
        }

    }
}
