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

    public int getRoomNumber() {
        return roomNumber;
    }


    public int getNumberBeds() {
        return numberBeds;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

}
