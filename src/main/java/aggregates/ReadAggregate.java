package aggregates;

import events.CanceledBookingEvent;
import events.RoomBookedEvent;
import readModels.AvailableRoom;
import readModels.MadeBooking;
import repositories.ReadRepository;

import java.time.LocalDate;
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

            LocalDate newStartDate = roomBookedEvent.getEndDate().plusDays(1);
            LocalDate newEndDate = readRepository.getAvailableRoomByNumber(roomBookedEvent.getRoomNumber()).getAvailableTo();

            readRepository.addAvailableRoom(new AvailableRoom(roomBookedEvent.getRoomNumber(), roomBookedEvent.getNumberBeds(), newStartDate, newEndDate));
            readRepository.deleteAvailableRoom(roomBookedEvent.getRoomNumber());


        } else if(obj instanceof CanceledBookingEvent) {
            CanceledBookingEvent cancelEvent = (CanceledBookingEvent) obj;
            MadeBooking canceledBooking = ReadRepository.getInstance().getMadeBookingByNumber(cancelEvent.getBookingNumber());

            LocalDate newEndDate = readRepository.getAvailableRoomByNumber(canceledBooking.getRoomNumber()).getAvailableTo();
            AvailableRoom availableRoom = new AvailableRoom(canceledBooking.getRoomNumber(), canceledBooking.getNumberBeds(), canceledBooking.getStartDate(), newEndDate);

            readRepository.deleteAvailableRoom(canceledBooking.getRoomNumber());
            readRepository.deleteBooking(cancelEvent.getBookingNumber());
            readRepository.addAvailableRoom(availableRoom);

        }
    }
}
