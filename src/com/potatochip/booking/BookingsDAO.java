package com.potatochip.booking;

public class BookingsDAO {
    private static Bookings[] bookings;
    private int nextAvailableSlot = 0;

    static{
        bookings = new Bookings[2];
    }

    public Bookings[] getAllBookings(){
        return bookings;
    }

    public void saveBooking (Bookings booking){
        bookings[nextAvailableSlot] = booking;
        nextAvailableSlot++;
    }

}
