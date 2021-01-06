package services;

import aggregates.WriteAggregate;
import commands.BookRoomCommand;
import commands.CancelBookingCommand;

import java.time.LocalDate;

public class WriteService {

    WriteAggregate writeAggregate = new WriteAggregate();

    public void bookRoom(LocalDate startDate, LocalDate endDate, int roomNumber, String nameOfPerson){
        BookRoomCommand bookRoomCommand = new BookRoomCommand(startDate,endDate,roomNumber,nameOfPerson);
        writeAggregate.bookRoom(bookRoomCommand);
    }

    public void cancelBooking(int bookNumber){
        CancelBookingCommand cancelBookingCommand = new CancelBookingCommand(bookNumber);
        writeAggregate.cancelBooking(cancelBookingCommand);
    }
}
