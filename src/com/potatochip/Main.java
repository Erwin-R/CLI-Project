package com.potatochip;

import com.potatochip.booking.Bookings;
import com.potatochip.booking.BookingsArrayDataAccessService;
import com.potatochip.booking.BookingsService;
import com.potatochip.car.Car;
import com.potatochip.car.CarArrayDataAccessService;
import com.potatochip.car.CarService;
import com.potatochip.user.User;
import com.potatochip.user.UserArrayDataAccessService;
import com.potatochip.user.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserArrayDataAccessService userArrayDataAccessService = new UserArrayDataAccessService();
        UserService userService = new UserService(userArrayDataAccessService);
        CarArrayDataAccessService carArrayDataAccessService = new CarArrayDataAccessService();
        CarService carService = new CarService(carArrayDataAccessService);
        BookingsArrayDataAccessService bookingsArrayDataAccessService = new BookingsArrayDataAccessService();
        BookingsService bookingsService = new BookingsService(bookingsArrayDataAccessService);


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
                carService.removeCar(foundCar);

                System.out.println(
                        "\uD83C\uDF89 succeffully booked car with reg number " + carRegNum
                        + "for user " + foundUser + "\n Booking ref: " + newBooking.getBookingId()
                );

            }
            else if(input == 2){
                for(User user: userService.getUsers()){
                    System.out.println(user);
                }
                System.out.println("Select user id");
                String userId = scanner.next();
                System.out.println(userService.getUserCars(userId));
            }
            else if(input == 3){
                if (!bookingsService.getBookings().isEmpty()) {
                    List<Bookings> bookings = bookingsService.getBookings();
                    for(Bookings booking: bookings){
                        System.out.println("booking = " + booking);
                    }
                } else{
                    System.out.println("Currently no bookings");
                }
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