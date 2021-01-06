package aggregates;

import events.CanceledBookingEvent;
import events.RoomBookedEvent;
import readModels.AvailableRoom;
import readModels.MadeBooking;
import repositories.ReadRepository;

import java.util.Observable;
import java.util.Observer;

public class ReadAggregate implements Observer {

    ReadRepository readRepository = ReadRepository.getInstance();

    @Override
    public void update(Observable o, Object obj) {
        if(obj instanceof RoomBookedEvent){
            RoomBookedEvent roomBookedEvent = (RoomBookedEvent) obj;
            MadeBooking madeBooking = new MadeBooking(roomBookedEvent.getBookingNumber(), roomBookedEvent.getRoomNumber(),roomBookedEvent.getNumberBeds(), roomBookedEvent.getStartDate(), roomBookedEvent.getEndDate(), roomBookedEvent.getCustomerId(), roomBookedEvent.getNameOfPerson());
            readRepository.addMadeBooking(madeBooking);
            readRepository.deleteAvailableRoom(roomBookedEvent.getRoomNumber());
        } else if(obj instanceof CanceledBookingEvent) {
            CanceledBookingEvent cancelEvent = (CanceledBookingEvent) obj;
            AvailableRoom availableRoom = new AvailableRoom(cancelEvent.getRoomNumber(), cancelEvent.getNumberOfBeds(), cancelEvent.getStartDate(), cancelEvent.getEndDate());
            readRepository.deleteBooking(cancelEvent.getBookingNumber());
            readRepository.addAvailableRoom(availableRoom);
        }
    }
}
