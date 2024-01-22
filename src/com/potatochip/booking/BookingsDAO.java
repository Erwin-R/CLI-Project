package com.potatochip.booking;

public class BookingsDAO {
    private Bookings[] bookings;
    private int nextAvailableSlot = 0;

    public Bookings[] getAllBookings(){
        return bookings;
    }

    public void saveBooking (Bookings booking){
        bookings[nextAvailableSlot] = booking;
        nextAvailableSlot++;
    }

}
