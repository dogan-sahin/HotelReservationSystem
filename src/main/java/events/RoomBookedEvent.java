package events;


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

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }

}
