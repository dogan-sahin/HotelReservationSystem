package commands;

public class CancelBookingCommand {
    private int bookingNumber;

    public CancelBookingCommand(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
}
