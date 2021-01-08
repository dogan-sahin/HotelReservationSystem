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

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

}
