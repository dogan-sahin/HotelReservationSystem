package services;

import aggregates.WriteAggregate;
import commands.BookRoomCommand;
import commands.CancelBookingCommand;

public class WriteService {

    WriteAggregate writeAggregate = new WriteAggregate();

    public void bookRoom(BookRoomCommand bookRoomCommand){
        writeAggregate.bookRoom(bookRoomCommand);
    }

    public void cancelBooking(CancelBookingCommand cancelBookingCommand){
        writeAggregate.cancelBooking(cancelBookingCommand);
    }
}
