package com.potatochip.booking;

import com.potatochip.user.User;
import com.potatochip.car.Car;

import java.time.LocalDate;
import java.util.UUID;

public class CarBooking {
    /*
    booking class has bookingId, user attached to booking, car attached to booking,
    bookingTime, and isCanceled
   */
    private UUID bookingId;
    private User user;
    private Car car;
    private LocalDate bookingTime;
    private boolean isCanceled = false;



    public CarBooking(UUID bookingId, User user, Car car, LocalDate bookingTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.bookingTime = bookingTime;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDate bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId='" + bookingId + '\'' +
                ", user=" + user +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                ", isCanceled=" + isCanceled +
                '}';
    }


}
