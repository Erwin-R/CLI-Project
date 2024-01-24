package com.potatochip.booking;

import com.potatochip.car.Car;
import com.potatochip.user.User;

import java.time.LocalDate;
import java.util.UUID;

public class BookingsService {
    private BookingsDAO bookingsDAO;

    public BookingsService() {
        this.bookingsDAO = new BookingsDAO();
    }

    //need to remove car from cars array
    //remove car from electric cars array
//add to user bookings array
    public Bookings bookACar(User user, Car car, LocalDate bookingTime){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        Bookings newBooking = new Bookings(uuidAsString, user, car, bookingTime);
        bookingsDAO.saveBooking(newBooking);
        return newBooking;
    }
    public Bookings[] getBookings(){
        return bookingsDAO.getAllBookings();
    }
}
