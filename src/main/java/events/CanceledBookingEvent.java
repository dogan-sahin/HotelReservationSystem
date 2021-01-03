package events;

import domain.Room;

public class CanceledBookingEvent extends Event{
    private int bookingNumber;
    private Room room;

    public CanceledBookingEvent(int bookingNumber, Room room) {
        this.bookingNumber = bookingNumber;
        this.room = room;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
