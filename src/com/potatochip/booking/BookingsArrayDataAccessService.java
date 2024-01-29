package com.potatochip.booking;

public class BookingsArrayDataAccessService implements BookingsDAO {
    private static final Bookings[] bookings = new Bookings[2];
    private int nextAvailableSlot = 0;

    @Override
    public Bookings[] getAllBookings(){
        return bookings;
    }
    @Override
    public void saveBooking (Bookings booking){
        bookings[nextAvailableSlot] = booking;
        nextAvailableSlot++;
    }

}
