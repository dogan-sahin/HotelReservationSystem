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

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }
}
