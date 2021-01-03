package repositories;

import readModels.AvailableRoom;
import readModels.MadeBooking;

import java.util.ArrayList;
import java.util.List;

public class ReadRepository {

    private List<AvailableRoom> rooms;
    private List<MadeBooking> bookings;

    private static ReadRepository instance;

    private ReadRepository(){
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public static ReadRepository getInstance(){
        if(instance == null){
            instance = new ReadRepository();
        }
        return instance;
    }

   public void deleteAvailableRoom(int roomNumber){
        for(AvailableRoom room : rooms){
            if(room.getRoomNumber() == roomNumber){
                rooms.remove(room);
                return;
            }
        }
   }

   public void addAvailableRoom(AvailableRoom availableRoom){
        rooms.add(availableRoom);
   }

    public List<AvailableRoom> getAvailableRooms(){
        return null;
    }

    public List<MadeBooking> getMadeBookings(){
        return null;
    }

    public void deleteBooking(int bookingNumber){
        for(MadeBooking booking : bookings){
            if(booking.getRoomNumber() == bookingNumber){
                rooms.remove(booking);
                return;
            }
        }
    }

    public void addMadeBooking(MadeBooking madeBooking){
        bookings.add(madeBooking);
    }


}
