package repositories;

import queries.GetAvailableRoomsByPeriodAndNumberPerson;
import queries.GetBookingsByPeriod;
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

        rooms.add(new AvailableRoom(1, 3));
        rooms.add(new AvailableRoom(2, 3));
        rooms.add(new AvailableRoom(3, 2));
        rooms.add(new AvailableRoom(4, 2));
        rooms.add(new AvailableRoom(5, 4));
        rooms.add(new AvailableRoom(6, 1));
        rooms.add(new AvailableRoom(7, 5));
    }

    public static ReadRepository getInstance(){
        if(instance == null){
            instance = new ReadRepository();
        }
        return instance;
    }

    public List<MadeBooking> getMadeBookings(GetBookingsByPeriod getBookingsByPeriodQuery){
        
        List<MadeBooking> madeBookingsInPeriod = new ArrayList<>();
        for(MadeBooking madeBooking : bookings){
            if((getBookingsByPeriodQuery.getStartDate().isBefore(madeBooking.getStartDate()) || getBookingsByPeriodQuery.getStartDate().isEqual(madeBooking.getStartDate()))
            && (getBookingsByPeriodQuery.getEndDate().isAfter(madeBooking.getEndDate()) || getBookingsByPeriodQuery.getEndDate().isEqual(madeBooking.getEndDate()))){
                madeBookingsInPeriod.add(madeBooking);
            }
        }
        return madeBookingsInPeriod;
    }

    public List<AvailableRoom> getAvailableRooms(GetAvailableRoomsByPeriodAndNumberPerson getAvailableRoomsQuery){

        List<AvailableRoom> availableRoomsInCriteria = new ArrayList<>();
        List<AvailableRoom> roomsToRemove = new ArrayList<>();

        for(AvailableRoom room : rooms){
            if(room.getBookings().size() == 0){
                if(room.getNumberBeds() >= getAvailableRoomsQuery.getNumberPerson()){
                    availableRoomsInCriteria.add(room);
                }
            }

            for(MadeBooking madeBooking : room.getBookings()){
                if((getAvailableRoomsQuery.getStartDate().isBefore(madeBooking.getStartDate()) && getAvailableRoomsQuery.getEndDate().isBefore(madeBooking.getStartDate()))
                        || (getAvailableRoomsQuery.getStartDate().isAfter(madeBooking.getEndDate()) && getAvailableRoomsQuery.getEndDate().isAfter(madeBooking.getEndDate()))){
                    if(room.getNumberBeds() >= getAvailableRoomsQuery.getNumberPerson() && !availableRoomsInCriteria.contains(room)){
                        availableRoomsInCriteria.add(room);
                    }
                } else if(availableRoomsInCriteria.contains(room)) {
                    roomsToRemove.add(room);
                }
            }
        }

        availableRoomsInCriteria.removeAll(roomsToRemove);
        return availableRoomsInCriteria;
    }

    public void deleteBooking(int bookingNumber){

        MadeBooking canceledBooking = null;

        for(MadeBooking booking : bookings){
            if(booking.getBookingNumber() == bookingNumber){
                canceledBooking = booking;
                break;
            }
        }
        if(canceledBooking != null){
            bookings.remove(canceledBooking);
        }
    }

    public void addMadeBooking(MadeBooking madeBooking){
        bookings.add(madeBooking);
    }


    public AvailableRoom getAvailableRoomByNumber (int roomNumber){
        for(AvailableRoom room : rooms){
            if(room.getRoomNumber() == roomNumber){
                return room;
            }
        }
       return null;
    }

    public MadeBooking getMadeBookingByNumber (int bookingNumber){
        for(MadeBooking booking : bookings){
            if(booking.getBookingNumber() == bookingNumber){
                return booking;
            }
        }
        return null;
    }




}
