package commands;

import java.time.LocalDate;

public class BookRoomCommand {
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomNumber;
    private String nameOfPerson;

    public BookRoomCommand(LocalDate startDate, LocalDate endDate, int roomNumber, String nameOfPerson) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }
}
