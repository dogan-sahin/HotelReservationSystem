package events;


import java.time.LocalDate;

public class CanceledBookingEvent extends Event{
    private int bookingNumber;
    private int roomNumber;
    private int numberOfBeds;
    private LocalDate startDate;
    private LocalDate endDate;


    public CanceledBookingEvent(int bookingNumber, int roomNumber, int numberOfBeds, LocalDate startDate, LocalDate endDate) {
        this.bookingNumber = bookingNumber;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
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
