package com.potatochip.booking;

public interface BookingsDAO {
    Bookings[] getAllBookings();
    void saveBooking(Bookings booking);
}
