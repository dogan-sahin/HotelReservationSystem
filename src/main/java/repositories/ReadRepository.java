package repositories;

import domain.Room;
import queries.GetAvailableRoomsByPeriodAndNumberPerson;
import queries.GetBookingsByPeriod;
import readModels.AvailableRoom;
import readModels.MadeBooking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReadRepository {

    private List<AvailableRoom> rooms;
    private List<MadeBooking> bookings;

    private static ReadRepository instance;

    private ReadRepository(){
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        String defaultStartDate = "01.01.2015";
        String defaultEndDate = "31.12.2025";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        formatter = formatter.withLocale( Locale.GERMAN );

        rooms.add(new AvailableRoom(1, 3, LocalDate.parse(defaultStartDate, formatter), LocalDate.parse(defaultEndDate, formatter)));
        rooms.add(new AvailableRoom(2, 3, LocalDate.parse(defaultStartDate, formatter), LocalDate.parse(defaultEndDate, formatter)));
        rooms.add(new AvailableRoom(3, 2, LocalDate.parse(defaultStartDate, formatter), LocalDate.parse(defaultEndDate, formatter)));
        rooms.add(new AvailableRoom(4, 2, LocalDate.parse(defaultStartDate, formatter), LocalDate.parse(defaultEndDate, formatter)));
        rooms.add(new AvailableRoom(5, 4, LocalDate.parse(defaultStartDate, formatter), LocalDate.parse(defaultEndDate, formatter)));
        rooms.add(new AvailableRoom(6, 1, LocalDate.parse(defaultStartDate, formatter), LocalDate.parse(defaultEndDate, formatter)));
        rooms.add(new AvailableRoom(7, 5, LocalDate.parse(defaultStartDate, formatter), LocalDate.parse(defaultEndDate, formatter)));
    }

    public static ReadRepository getInstance(){
        if(instance == null){
            instance = new ReadRepository();
        }
        return instance;
    }

   public void deleteAvailableRoom(int roomNumber){
        AvailableRoom availableRoom = null;

        for(AvailableRoom room : rooms){
            if(room.getRoomNumber() == roomNumber){
                availableRoom = room;
                break;
            }
        }

       if(availableRoom != null){
           rooms.remove(availableRoom);
       }
   }

   public void addAvailableRoom(AvailableRoom availableRoom){
        rooms.add(availableRoom);
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

        for(AvailableRoom availableRoom : rooms){
            if(( getAvailableRoomsQuery.getStartDate().isAfter(availableRoom.getAvailableFrom()) ||  getAvailableRoomsQuery.getStartDate().isEqual(availableRoom.getAvailableFrom()))
                    && ( getAvailableRoomsQuery).getEndDate().isBefore(availableRoom.getAvailableTo()) ||  getAvailableRoomsQuery.getEndDate().isEqual((availableRoom.getAvailableTo()))){
                if(availableRoom.getNumberBeds() >= getAvailableRoomsQuery.getNumberPerson()){
                    availableRoomsInCriteria.add(availableRoom);
                }
            }
        }
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
