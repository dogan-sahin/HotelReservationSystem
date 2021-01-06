package events;

import domain.Customer;
import domain.Room;

import java.time.LocalDate;

public class RoomBookedEvent extends Event {
    private int bookingNumber;
    private int roomNumber;
    private int numberBeds;
    private int customerId;
    private String nameOfPerson;
    private LocalDate startDate;
    private LocalDate endDate;

    public RoomBookedEvent(int bookingNumber, int roomNumber, int numberBeds, int customerId, String nameOfPerson, LocalDate startDate, LocalDate endDate) {
        this.bookingNumber = bookingNumber;
        this.roomNumber = roomNumber;
        this.numberBeds = numberBeds;
        this.customerId = customerId;
        this.nameOfPerson = nameOfPerson;
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

    public int getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberBeds = numberBeds;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
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
