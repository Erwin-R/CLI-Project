package com.potatochip.booking;

import com.potatochip.car.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class CarBookingDAO {
    private static final List<CarBooking> carBookings = new ArrayList<>();


    public List<CarBooking> getAllBookings(){
        return carBookings;
    }

    public void saveBooking (CarBooking carBooking){
        carBookings.add(carBooking);
    }



}
