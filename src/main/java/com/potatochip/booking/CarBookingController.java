package com.potatochip.booking;

import com.potatochip.car.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CarBookingController {
    private final CarBookingService carBookingService;

    public CarBookingController(CarBookingService carBookingService) {
        this.carBookingService = carBookingService;
    }

    @GetMapping("api/carBookings")
    public List<CarBooking> getAllCarBookings(){
        return carBookingService.getBookings();
    }

    @GetMapping("api/carBookings/{userId}")
    public List<Car> getAllUserBookedCars(@PathVariable("userId") UUID userId){
        return carBookingService.getUserBookedCars(userId);
    }

}
