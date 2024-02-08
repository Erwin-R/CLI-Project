package com.potatochip;

import com.potatochip.booking.CarBooking;
import com.potatochip.booking.CarBookingDAO;
import com.potatochip.booking.CarBookingService;
import com.potatochip.car.Car;
import com.potatochip.car.CarDAO;
import com.potatochip.car.CarService;
import com.potatochip.user.User;
import com.potatochip.user.UserDAO;
import com.potatochip.user.UserFileDataAccessService;
import com.potatochip.user.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserFileDataAccessService();
        UserService userService = new UserService(userDAO);
        CarDAO carDAO = new CarDAO();
        CarService carService = new CarService(carDAO);
        CarBookingDAO carBookingDAO = new CarBookingDAO();
        CarBookingService carBookingService = new CarBookingService(carBookingDAO, carService);


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
        boolean keepLooping = true;
        while(keepLooping){
            try {
                int input = scanner.nextInt();
                switch(input){
                    case 1 -> bookCar(userService, carBookingService, scanner);
                    case 2 -> displayAllUserBookedCars(userService, carBookingService, scanner);
                    case 3 -> displayAllBookings(carBookingService);
                    case 4 -> displayAvailableCars(carBookingService, false);
                    case 5 -> displayAvailableCars(carBookingService, true);
                    case 6 -> displayAllUsers(userService);
                    case 7 -> keepLooping = false;
                    default -> System.out.println(input + " not a valid option");
                }


            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }


    }

    private static void bookCar(UserService userService, CarBookingService carBookingService, Scanner scanner){
        displayAvailableCars(carBookingService, false);
        System.out.println("Select car reg number");
        int regNumber = scanner.nextInt();

        System.out.println("Select user id");
        String userId = scanner.nextLine();


        User user = userService.getOneUser(UUID.fromString(userId));
        if(user == null){
            System.out.println("No user found with id: " + userId);
        } else{
            UUID bookingId = carBookingService.bookACar(user, regNumber);
            String confirmationMessage = """
                Successfully booked car with reg number %s for user %s
                Booking ref: %s
            """.formatted(regNumber, user, bookingId);
            System.out.println(confirmationMessage);
        }

    }

    private static void displayAllUserBookedCars(UserService userService, CarBookingService carBookingService, Scanner scanner){
        displayAllUsers(userService);
        System.out.println("Select user id");
        String userId = scanner.nextLine();
        User user = userService.getOneUser(UUID.fromString(userId));
        if(user == null){
            System.out.println("No user found with id " + userId);
            return;
        }

        List<Car> userBookedCars = carBookingService.getUserBookedCars(user.getId());
        if(userBookedCars.isEmpty()){
            System.out.println("This user has no cars booked");
            return;
        }

        for(Car userCar: userBookedCars){
            System.out.println(userCar);
        }

    }
    private static void displayAllBookings(CarBookingService carBookingService){
        List<CarBooking> allBookings = carBookingService.getBookings();

        if(allBookings.isEmpty()){
            System.out.println("There are currently no booked cars");
            return;
        }

        for(CarBooking carBooking: allBookings){
            System.out.println("booking = " + carBooking);
        }
    }
    private static void displayAvailableCars(CarBookingService carBookingService, boolean isElectric){
        List<Car> availableCars = isElectric ? carBookingService.getAvailableElectricCars(): carBookingService.getAvailableCars();
        if(availableCars.isEmpty()){
            System.out.println("No cars available for rent");
            return;
        }

        for(Car availableCar: availableCars){
            System.out.println(availableCar);
        }

    }
    private static void displayAllUsers(UserService userService){
        List<User> users = userService.getUsers();
        if(users.isEmpty()){
            System.out.println("No users in the system!");
            return;
        }

        for(User user: users){
            System.out.println(user);
        }
    }
}