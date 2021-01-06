package services;

import queries.GetAvailableRoomsByPeriodAndNumberPerson;
import queries.GetBookingsByPeriod;
import readModels.AvailableRoom;
import readModels.MadeBooking;
import repositories.ReadRepository;

import java.time.LocalDate;
import java.util.List;

public class ReadService {

    ReadRepository readRepository = ReadRepository.getInstance();

    public List<MadeBooking> getBookings(LocalDate startDate, LocalDate endDate){
        GetBookingsByPeriod getBookingsByPeriodQuery = new GetBookingsByPeriod(startDate,endDate);
        return readRepository.getMadeBookings(getBookingsByPeriodQuery);
    }

    public List<AvailableRoom> getAvailableRooms(LocalDate startDate, LocalDate endDate, int numberOfPerson){
        GetAvailableRoomsByPeriodAndNumberPerson getAvailableRoomsQuery = new GetAvailableRoomsByPeriodAndNumberPerson(startDate, endDate, numberOfPerson);
        return readRepository.getAvailableRooms(getAvailableRoomsQuery);
    }
}
