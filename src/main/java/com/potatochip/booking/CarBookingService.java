package com.potatochip.booking;

import com.potatochip.car.Car;
import com.potatochip.car.CarService;
import com.potatochip.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class CarBookingService {
    private final CarBookingDAO carBookingDAO;
    private final CarService carService;

    public CarBookingService(CarBookingDAO carBookingDAO, CarService carService) {
        this.carBookingDAO = carBookingDAO;
        this.carService = carService;
    }

    //need to remove car from cars array
    //remove car from electric cars array
    public UUID bookACar(User user, int regNumber){
        List<Car> availableCars = getAvailableCars();

        if(availableCars.isEmpty()){
            throw new IllegalStateException("No cars are available for renting");
        }

        for(Car availableCar: availableCars){
            if(availableCar.getRegNumber() == regNumber){
                Car car = carService.getOneCar(regNumber);
                UUID bookingId = UUID.randomUUID();
                carBookingDAO.saveBooking(
                        new CarBooking(bookingId, user, car, LocalDate.now())
                );

                return bookingId;
            }
        }

        throw new IllegalStateException("Already booked, car with regNumber " + regNumber);
    }

    public List<Car> getUserBookedCars(UUID userId){
        List<CarBooking> carBookings = carBookingDAO.getAllBookings();
        List<Car> userCars = new ArrayList<>();

        for(CarBooking carBooking: carBookings){
            if(carBooking.getUser().getId().equals(userId)){
                userCars.add(carBooking.getCar());
            }
        }

        return userCars;
    }

    public List<CarBooking> getBookings(){
        return carBookingDAO.getAllBookings();
    }

    public List<Car> getAvailableCars(){
        return getCars(carService.getAllCars());
    }

    public List<Car> getAvailableElectricCars(){
        return getCars(carService.getAllElectricCars());
    }

    private List<Car> getCars(List<Car> cars){
        //no cars in system
        if (cars.isEmpty()){
            return Collections.emptyList();
        }

        List<CarBooking> carBookings = carBookingDAO.getAllBookings();

        //no bookings so all cars are available
        if(carBookings.isEmpty()){
            return cars;
        }

        List<Car> availableCars = new ArrayList<>();
        for(Car car: cars){
            boolean booked = false;
            for(CarBooking carBooking: carBookings){
                //if car is not booked
                if(carBooking != null && !carBooking.getCar().equals(car)){
                    continue;
                }
                booked = true;
            }

            if(!booked){
                availableCars.add(car);
            }
        }
        //Booked: {booking1 = car2}
        //car: {car1, car2, car3}

        return availableCars;
    }
}
