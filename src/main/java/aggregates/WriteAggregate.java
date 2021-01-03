package aggregates;

import commands.BookRoomCommand;
import commands.CancelBookingCommand;
import repositories.EventStore;

public class WriteAggregate {

    EventStore eventStore = EventStore.getInstance();

    public void bookRoom(BookRoomCommand bookRoomCommand){

    }

    public void cancelBooking(CancelBookingCommand cancelBookingCommand){

    }
}
