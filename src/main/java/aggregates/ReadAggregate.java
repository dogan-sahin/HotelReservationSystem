package aggregates;

import events.CanceledBookingEvent;
import events.RoomBookedEvent;
import readModels.AvailableRoom;
import readModels.MadeBooking;
import repositories.EventStore;
import repositories.ReadRepository;

import java.util.Observable;
import java.util.Observer;

public class ReadAggregate implements Observer {

    ReadRepository readRepository = ReadRepository.getInstance();
    EventStore eventStore = EventStore.getInstance();

    public ReadAggregate() {
        eventStore.subscribe(this);
    }

    @Override
    public void update(Observable o, Object obj) {
        if(obj instanceof RoomBookedEvent){
            RoomBookedEvent roomBookedEvent = (RoomBookedEvent) obj;
            MadeBooking madeBooking = new MadeBooking(roomBookedEvent.getBookingNumber(), roomBookedEvent.getRoom().getRoomNumber(),roomBookedEvent.getRoom().getNumberBeds(), roomBookedEvent.getStartDate(), roomBookedEvent.getEndDate(), roomBookedEvent.getCustomer().getCustomerId(), roomBookedEvent.getCustomer().getName());
            readRepository.addMadeBooking(madeBooking);
            readRepository.deleteAvailableRoom(roomBookedEvent.getRoom().getRoomNumber());
        } else if(obj instanceof CanceledBookingEvent) {
            CanceledBookingEvent cancelEvent = (CanceledBookingEvent) obj;
            AvailableRoom availableRoom = new AvailableRoom(cancelEvent.getRoom().getRoomNumber(), cancelEvent.getRoom().getNumberBeds());
            readRepository.deleteBooking(cancelEvent.getBookingNumber());
            readRepository.addAvailableRoom(availableRoom);
        }
    }
}
