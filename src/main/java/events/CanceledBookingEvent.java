package events;



public class CanceledBookingEvent extends Event {
    private int bookingNumber;


    public CanceledBookingEvent(int bookingNumber) {
        this.bookingNumber = bookingNumber;

    }

    public int getBookingNumber() {
        return bookingNumber;
    }

}
