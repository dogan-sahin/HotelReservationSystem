package readModels;

import java.time.LocalDate;

public class AvailableRoom {
    private int roomNumber;
    private int numberBeds;
    private LocalDate availableFrom;
    private LocalDate availableTo;

    public AvailableRoom(int roomNumber, int numberBeds, LocalDate availableFrom, LocalDate availableTo) {
        this.roomNumber = roomNumber;
        this.numberBeds = numberBeds;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
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

    public LocalDate getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDate availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalDate getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalDate availableTo) {
        this.availableTo = availableTo;
    }
}
