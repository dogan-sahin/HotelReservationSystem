package repositories;

import domain.Booking;
import domain.Room;

import java.util.ArrayList;
import java.util.List;

public class WriteRepository {

    private static WriteRepository instance;

    private List<Room> rooms;
    private List<Booking> bookings;

    private WriteRepository(){
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        rooms.add(new Room(3));
        rooms.add(new Room(3));
        rooms.add(new Room(2));
        rooms.add(new Room(2));
        rooms.add(new Room(4));
        rooms.add(new Room(1));
        rooms.add(new Room(5));

    }

    public static WriteRepository getInstance(){
        if(instance == null){
            instance = new WriteRepository();
        }
        return instance;
    }


    public void addBooking(Booking booking){
       bookings.add(booking);
    }

    public Room getRoomById(int roomNumber){
        for(Room room : rooms){
            if(room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public Booking deleteBookingById(int bookNumber){
        for(Booking booking : bookings){
            if(booking.getBookingNumber() == bookNumber){
                bookings.remove(booking);
                return booking;
            }
        }
        return null;
    }
}
