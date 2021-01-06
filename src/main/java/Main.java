import readModels.AvailableRoom;
import readModels.MadeBooking;
import services.ReadService;
import services.WriteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static WriteService writeService = new WriteService();
    private static ReadService readService = new ReadService();


    public static void main(String[] args) {

        System.out.println();
        System.out.println();
        System.out.println("Servus!!");

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println("Please select an operation: ");
            System.out.println("---------------------------");
            System.out.println("Operations:");
            System.out.println("0 --> Make a booking");
            System.out.println("1 --> Cancel a booking");
            System.out.println("2 --> List all available rooms");
            System.out.println("3 --> List all made bookings");
            System.out.println("4 --> Exit");
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println();

            int option = scanner.nextInt();  // Read user input
            System.out.println("Selected option is: " + option);  // Output user input

            switch (option) {
                case 0:
                    makeBookingMenu();
                    break;
                case 1:
                    cancelBookingMenu();
                    break;
                case 2:
                    listAvailableRoomsMenu();
                    break;
                case 3:
                    listBookingsMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }

    private static void makeBookingMenu() {
        while (true) {
            System.out.println("Please enter the room number: ");
            int roomNumber = scanner.nextInt();

            System.out.println("Please enter the start date:         Pattern: dd.MM.yyyy");
            String startDateString = scanner.next();

            System.out.println("Please enter the end date:         Pattern: dd.MM.yyyy");
            String endDateString = scanner.next();


            System.out.println("Please enter the name of customer: ");
            String name = scanner.next();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formatter = formatter.withLocale( Locale.GERMAN );

            LocalDate startDate = LocalDate.parse(startDateString, formatter);
            LocalDate endDate = LocalDate.parse(endDateString, formatter);

            writeService.bookRoom(startDate, endDate, roomNumber, name);

            return;

        }
    }

    private static void  cancelBookingMenu() {
        while (true) {
            System.out.println("Please enter the booking number: ");
            int bookingNumber = scanner.nextInt();
            writeService.cancelBooking(bookingNumber);
            return;
        }
    }

    private static void  listAvailableRoomsMenu(){
        while (true) {

            System.out.println("Please enter the start date:         Pattern: dd.MM.yyyy");
            String startDateString = scanner.next();

            System.out.println("Please enter the end date:         Pattern: dd.MM.yyyy");
            String endDateString = scanner.next();

            System.out.println("Please enter the number of beds: ");
            int numberBeds = scanner.nextInt();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formatter = formatter.withLocale( Locale.GERMAN );

            LocalDate startDate = LocalDate.parse(startDateString, formatter);
            LocalDate endDate = LocalDate.parse(endDateString, formatter);

            List<AvailableRoom> availableRooms = readService.getAvailableRooms(startDate,endDate,numberBeds);
            for(AvailableRoom room : availableRooms){
                System.out.println("-----------------------");
                System.out.println("Room number: " + room.getRoomNumber());
                System.out.println("Number of beds: " + room.getNumberBeds());
                System.out.println("Available from: " + room.getAvailableFrom());
                System.out.println("Available to: " + room.getAvailableTo());
            }
            return;

        }
    }

    private static void listBookingsMenu(){
        while (true) {

            System.out.println("Please enter the start date:         Pattern: dd.MM.yyyy");
            String startDateString = scanner.next();

            System.out.println("Please enter the end date:         Pattern: dd.MM.yyyy");
            String endDateString = scanner.next();


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            formatter = formatter.withLocale( Locale.GERMAN );

            LocalDate startDate = LocalDate.parse(startDateString, formatter);
            LocalDate endDate = LocalDate.parse(endDateString, formatter);

            List<MadeBooking> madeBookings = readService.getBookings(startDate,endDate);
            for(MadeBooking booking : madeBookings){
                System.out.println("-----------------------");
                System.out.println("Booking number: " + booking.getBookingNumber());
                System.out.println("Customer ID: " + booking.getCustomerId());
                System.out.println("Customer name: " + booking.getCustomerName());
                System.out.println("Room number: " + booking.getRoomNumber());
                System.out.println("Number of beds: " + booking.getNumberBeds());
                System.out.println("Start date: " + booking.getStartDate());
                System.out.println("End date: " + booking.getEndDate());
            }
            return;

        }
    }


}
