package queries;

import java.time.LocalDate;

public class GetAvailableRoomsByPeriodAndNumberPerson {
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberPerson;

    public GetAvailableRoomsByPeriodAndNumberPerson(LocalDate startDate, LocalDate endDate, int numberPerson) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberPerson = numberPerson;
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }


    public int getNumberPerson() {
        return numberPerson;
    }

}
