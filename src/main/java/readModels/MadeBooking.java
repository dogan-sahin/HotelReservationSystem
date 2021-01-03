package readModels;

import java.time.LocalDate;

public class MadeBooking {

    private int bookingNumber;
    private int roomNumber;
    private int numberBeds;
    private LocalDate startDate;
    private LocalDate endDate;
    private int customerId;
    private String customerName;

    public MadeBooking(int bookingNumber, int roomNumber, int numberBeds, LocalDate startDate, LocalDate endDate, int customerId, String customerName) {
        this.bookingNumber = bookingNumber;
        this.roomNumber = roomNumber;
        this.numberBeds = numberBeds;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberBeds = numberBeds;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
