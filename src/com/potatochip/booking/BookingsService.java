package com.potatochip.booking;

import com.potatochip.car.Car;
import com.potatochip.user.User;

import java.time.LocalDate;
import java.util.UUID;

public class BookingsService {
    private final BookingsDAO bookingsDAO;

    public BookingsService(BookingsDAO bookingsDAO) {
        this.bookingsDAO = bookingsDAO;
    }

    //need to remove car from cars array
    //remove car from electric cars array
    public Bookings bookACar(User user, Car car, LocalDate bookingTime){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        Bookings newBooking = new Bookings(uuidAsString, user, car, bookingTime);
        bookingsDAO.saveBooking(newBooking);
        user.saveCar(car);
        return newBooking;
    }
    public Bookings[] getBookings(){
        return bookingsDAO.getAllBookings();
    }
}
