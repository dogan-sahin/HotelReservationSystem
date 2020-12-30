package domain;

import java.time.LocalDate;


public class Booking {

    private static int nextBookingNumber = 0;

    private int bookingNumber;
    private Room room;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(Room room, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.bookingNumber = ++nextBookingNumber;
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
