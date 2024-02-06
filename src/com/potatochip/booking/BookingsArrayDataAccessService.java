package com.potatochip.booking;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class BookingsArrayDataAccessService implements BookingsDAO {
    private static final List<Bookings> bookings = new ArrayList<>();
    private int nextAvailableSlot = 0;

    @Override
    public List<Bookings> getAllBookings(){
        return bookings;
    }
    @Override
    public void saveBooking (Bookings booking){
        bookings.add(booking);
        nextAvailableSlot++;
    }

}
