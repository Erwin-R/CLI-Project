package com.potatochip;

import com.potatochip.booking.Bookings;
import com.potatochip.booking.BookingsService;
import com.potatochip.car.Car;
import com.potatochip.car.CarService;
import com.potatochip.user.User;
import com.potatochip.user.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        UserService userService = new UserService();
        BookingsService bookingsService = new BookingsService();


        System.out.println("Hello world!");
        System.out.println("""
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View all users 
                7️⃣ - Exit
                """);

        //completed number 3
        //completed number 6
        Scanner scanner = new Scanner(System.in);

        while(true){
            int input = scanner.nextInt();
            if(input == 1){
                for(Car car: carService.getCars()){
                    System.out.println(car);
                }
                System.out.println("➡\uFE0F select car reg number");
                int carRegNum = scanner.nextInt();
                for(User user: userService.getUsers()){
                    System.out.println(user);
                }
                System.out.println("➡\uFE0F select user id");
                String userId = scanner.next();
                User foundUser = userService.getOneUser(userId);
                Car foundCar = carService.getOneCar(carRegNum);
                Bookings newBooking = bookingsService.bookACar(foundUser, foundCar, LocalDate.now());

                System.out.println(
                        "\uD83C\uDF89 succeffully booked car with reg number " + carRegNum
                        + "for user " + foundUser + "\n Booking ref: " + newBooking.getBookingId()
                );

            }
            else if(input == 2){
                System.out.println();
            }
            else if(input == 3){
                System.out.println(Arrays.toString(bookingsService.getBookings()));
            }
            else if(input == 4){
                for(Car car: carService.getCars()){
                    System.out.println(car);
                }
            }
            else if(input == 5){
                for(Car car: carService.getElectricCars()){
                    System.out.println(car);
                }
            }
            else if(input == 6){
                for(User user: userService.getUsers()){
                    System.out.println(user);
                }
            }
            else if(input == 7){
                break;
            } else{
                System.out.println("Invalid number: " + input);
            }

        }


    }
}