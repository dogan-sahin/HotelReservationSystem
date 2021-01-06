package aggregates;

import commands.BookRoomCommand;
import commands.CancelBookingCommand;

import domain.Booking;
import domain.Customer;
import domain.Room;
import events.CanceledBookingEvent;
import events.Event;
import events.RoomBookedEvent;
import repositories.EventStore;
import repositories.WriteRepository;

import java.time.LocalDate;
import java.util.List;

public class WriteAggregate {

    EventStore eventStore = EventStore.getInstance();
    WriteRepository writeRepository = WriteRepository.getInstance();

    public void bookRoom(BookRoomCommand bookRoomCommand){

        Room room = writeRepository.getRoomById(bookRoomCommand.getRoomNumber());

        if(room != null){
            if(checkIsRoomAvailable(room.getRoomNumber(), bookRoomCommand.getStartDate()) == true){
               Booking booking = new Booking(room, new Customer(bookRoomCommand.getNameOfPerson()), bookRoomCommand.getStartDate(), bookRoomCommand.getEndDate());
               writeRepository.addBooking(booking);
               Event bookingEvent = new RoomBookedEvent(booking.getBookingNumber(), bookRoomCommand.getRoomNumber(), booking.getRoom().getNumberBeds(), booking.getCustomer().getCustomerId(), booking.getCustomer().getName(), booking.getStartDate(), booking.getEndDate());
               eventStore.publish(bookingEvent);
               System.out.println("Booking is successful!");
            } else {
                System.out.println("The room is not available!");
            }
        } else {
            System.out.println("The room with the number " + bookRoomCommand.getRoomNumber() + " does not exist!");
        }
    }

    public void cancelBooking(CancelBookingCommand cancelBookingCommand){

        Booking booking = writeRepository.deleteBookingById(cancelBookingCommand.getBookingNumber());

        if(booking != null){
            Event cancelEvent = new CanceledBookingEvent(booking.getBookingNumber(), booking.getRoom().getRoomNumber(), booking.getRoom().getNumberBeds(), booking.getStartDate(), booking.getEndDate());
            eventStore.publish(cancelEvent);
            System.out.println("The booking with the number " + cancelBookingCommand.getBookingNumber() + " is successfully canceled!");
        } else {
            System.out.println("The booking with the number " + cancelBookingCommand.getBookingNumber() + " does not exist!");
        }
    }

    private boolean checkIsRoomAvailable(int roomNumber, LocalDate startDate){
        List<Booking> bookings = writeRepository.getAllBookings();
        for(Booking booking : bookings){
            if(booking.getRoom().getRoomNumber() == roomNumber){
                if(!startDate.isAfter(booking.getEndDate())) {
                    return false;
                }
            }
        }
        return true;
    }
}
