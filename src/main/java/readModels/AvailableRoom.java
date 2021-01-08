package readModels;

import java.util.LinkedList;
import java.util.List;

public class AvailableRoom {
    private int roomNumber;
    private int numberBeds;
    private List<MadeBooking> bookings;

    public AvailableRoom(int roomNumber, int numberBeds) {
        this.roomNumber = roomNumber;
        this.numberBeds = numberBeds;
        this.bookings = new LinkedList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }


    public int getNumberBeds() {
        return numberBeds;
    }


    public List<MadeBooking> getBookings() {
        return bookings;
    }

    public void addBookingToRoom(MadeBooking madeBooking){
        bookings.add(madeBooking);
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


}
