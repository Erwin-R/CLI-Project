package com.potatochip.booking;

import java.util.List;

public interface BookingsDAO {
    List<Bookings> getAllBookings();
    void saveBooking(Bookings booking);
}
